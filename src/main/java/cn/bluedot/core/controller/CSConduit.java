package cn.bluedot.core.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 控制层 调用业务层之间的管道
 *
 */
public final class CSConduit {
    
    private CSConduit() {}
    private static volatile CSConduit instance;
    public static CSConduit getIntance() {
        if (instance == null) {
            synchronized (CSConduit.class) {
                if (instance == null)
                    instance = new CSConduit();
            }
        }
        return instance;
    }

    /**
     * 放入任务
     * @param callable
     * @return
     */
    public Future<Object> exeTask(Callable<Object> callable) {
        return es.submit(callable);
    }
    
    private final ExecutorService es = Executors.newFixedThreadPool(1);
    
    /**
     *  shutdown the es
     */
    private final Object finalizerGuardian = new Object() {

        @Override
        protected void finalize() throws Throwable {
            es.shutdown();
        }
    };
    
}
