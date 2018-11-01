package cn.bluedot.core.service.user.validation;
/**
 * Validator的基本实现, 所有的Validator都可以继承这个类
 * @param <A> 注解类型
 */
public abstract class AbstractValidator<A, V> implements Validator<A, V> {


    @Override
    public String message() {
        
        return message;
    }
    
    
    /**
     * 子类通过设定这个值给出出错提示
     */
    protected String message = "";
}
