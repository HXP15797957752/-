package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.Size;

public class SizeValidator extends AbstractValidator<Size, Integer>{

    @Override
    public boolean isValid(Size anno, Integer obj) {
        if (obj != null && (anno.min() > obj || anno.max() < obj)) {
            message = "不在指定范围[" + anno.min() + ", " + anno.max() + "]";
            return false;
        }
        
        return true;
    }

}
