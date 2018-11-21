package cn.bluedot.core.service.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.bluedot.core.service.user.validation.LengthValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.FIELD})
@ConstraintClass(validation=LengthValidation.class)
public @interface Length {
    public int min();
    public int max();
}
