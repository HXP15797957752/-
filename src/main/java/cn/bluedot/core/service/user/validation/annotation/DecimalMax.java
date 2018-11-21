package cn.bluedot.core.service.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.bluedot.core.service.user.validation.DecimalMaxValidator;
import cn.bluedot.core.service.user.validation.SizeValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.FIELD})
@ConstraintClass(validation=DecimalMaxValidator.class)
public @interface DecimalMax {
    /**
     * 一个小数, Java中被校验的元素是 BigDecimal 类型
     */
    public String maxDecimal();
}
