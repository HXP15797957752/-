package cn.bluedot.core.service.user.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.NameValuePair;

import cn.bluedot.core.service.user.validation.annotation.ConstraintClass;
import cn.bluedot.core.util.MyBeanUtils;


/**
 * JSR 303 参考实现(部分)
 * @Null 被注释的元素必须是null
 * @NotNull 被注释的元素必须不为null
 * @AssertTrue 被注释的元素必须是true
 * @AssertFalse 被注释的元素必须是false
 * @Min(value) 被注释的元素必须是一个数字且其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字且其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字(BigDecimal类型), 其值必须大于等于指定值
 * @DecimalMax(value) 被注释的元素必须是一个数字, 其值必须小于等于指定值 
 * @Size(min, max) 被注释的数字必须在指定的范围内
 * @Past 被注释的元素必须是一个过去的时间
 * @Future 被注释的元素必须是一个将来的时间
 * @Pattern(value) 被指定的元素必须满足指定的正则表达式
 * 
 * @Email 被注释的字符串必须是电子邮箱地址
 * @Length(min, max) 被注释字符串长度必须在指定范围内
 * @NotEmpty 被注释的字符串必须非空
 * 
 * @author renzhijiang
 */
public class ValidationUtil {
    /**
     * 校验PO对象某个属性
     * @param attrName
     * @param obj
     * @return 返回提示信息; 返回值为"" 表示没有违背注解, 否则表示违背
     */
    public static String validat(String attrName, Object obj) {
        String msg = "";
        try {
            Class clazz = obj.getClass();
            Field field = obj.getClass().getDeclaredField(attrName);
            for (Annotation annotation:field.getAnnotations()) {
                ConstraintClass cclass = annotation.annotationType().getAnnotation(ConstraintClass.class);
                if (cclass == null) {
                    throw new RuntimeException("@" + annotation
                            .annotationType().getSimpleName()+"没有处理类");
                }else {
                    // 得到注解处理类
                    Validator<Annotation, Object> validator = cclass.validation().newInstance();
                    
                    // 校验并返回提示信息
                    Field afield = clazz.getDeclaredField(attrName);
                    afield.setAccessible(true);
                    validator.isValid(annotation, afield.get(obj));
                    msg = validator.message();    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    /**
     * 校验整个domain对象
     * @param domain
     * @return 将提示信息放入 map中, key为attrName且值为提示信息;
     * 如果所有需要校验的属性的提示信息都是"", 这个对象是校验正确的;
     */
    public static Map<String, String> validat(Object domain){
        Map<String, String> cur = new HashMap<>(0);
        Class clazz = domain.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            cur.put(field.getName(), validat(field.getName(), domain));
        }
        return cur;
    }
    /**
     * 一般和 Map<String, String> validat(Object domain) 配合使用.
     * 
     * @param map 上述函数返回的Map
     * @return 该domain对象是否通过注解的校验
     */
    public static boolean validat(Map<String, String> map){
        for (String key:map.keySet()) {
            if (!"".equals(map.get(key))){
                return false;
            }
        }
        return true;
    }
    
    /**
     * 用于添加Domain对象时校验使用,返回的字符串可以用于错误消息回显;
     * 当验证不通过时返回错误消息, 当验证通过时返回""
     * @param req HttpServletRequest
     * @param clazz 需要校验的Class类
     * @param name_name request的map中对应于属性字段名的key, 该属性字段名为class中的属性且也是需要校验的属性
     * @param value_name request的map中对应于上述属性字段需要验证的值的key.
     * @return
     */
    public static String validat(HttpServletRequest req, Class clazz, String name_name, String value_name) {
        Field field = null;
        Map myMap = new HashMap<>();
        myMap.put(req.getParameter(name_name), req.getParameter(value_name));
        Object obj = MyBeanUtils.toBean(myMap, clazz);
        try {
            field = clazz.getDeclaredField(req.getParameter(name_name));
        } catch (Exception e) {
            e.printStackTrace();
        } 
        if (field != null) {
            return validat(req.getParameter(name_name), obj);
        }
        return "";
    }
    
}


