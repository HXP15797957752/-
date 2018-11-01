package cn.bluedot.core.service.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.bluedot.core.service.user.validation.EmailValidator;
import cn.bluedot.core.service.user.validation.SizeValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.FIELD})
@ConstraintClass(validation=EmailValidator.class)
public @interface Email {}
