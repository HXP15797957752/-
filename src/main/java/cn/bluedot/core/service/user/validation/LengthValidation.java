package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.Length;

/**
 * 验证字符串长度
 * @author renzhijiang
 *
 */
public class LengthValidation extends AbstractValidator<Length, String> {
    @Override
    public boolean isValid(Length anno, String obj) {
        if (obj != null && (obj.length() < anno.min() || obj.length() > anno.max())) {
            if (anno.min() != anno.max()) {
                message = "长度必须在" + anno.min() + "-" + anno.max() + "范围内";
            }else {
                message = "长度必须为:" + anno.min();
            }
            
            return false;
        }
        return true;
    }
}
