package cn.bluedot.core.service.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.bluedot.core.service.user.validation.NotEmptyValidator;
import cn.bluedot.core.service.user.validation.SizeValidator;

/*
 * @Retention 注解的保留时间
 * @Documented
 * @Target
 * @Inherited 不继承注解
 * @Repeatable 可重复性的注解
 * 注解的属性也叫做成员变量。注解只有成员变量，
 * 没有方法。注解的成员变量在注解的定义中以“无形参的方法”形式来声明，
 * 其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型...
 * 
 * 注解中属性可以有默认值，默认值需要用 default 关键值指定 : public int id() default -1;
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.FIELD})
@ConstraintClass(validation=NotEmptyValidator.class)
public @interface NotEmpty {}
