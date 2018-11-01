package cn.bluedot.core.service.user.validation;

/**
 * 校验注解逻辑处理类的接口
 * 
 * @author renzhijiang
 *
 * @param <A> 校验注解类型
 * @param <V> 被校验对象的类型
 */
public interface Validator<A, V>{
    boolean isValid(A anno, V obj);
    
    String message();
}
