package cn.bluedot.core.service.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.bluedot.core.service.user.validation.Validator;

@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.TYPE})
public @interface ConstraintClass {
    public Class<? extends Validator> validation();
}
