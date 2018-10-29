package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.Max;

public class MaxValidator extends AbstractValidator<Max, Integer>{

    @Override
    public boolean isValid(Max anno, Integer obj) {
        if (obj != null && obj > anno.max()) {
            message = "最大值为:" + anno.max();
            return false;
        }
        return true;
    }
    
}
