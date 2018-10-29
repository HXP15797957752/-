package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.Min;

public class MinValidator extends AbstractValidator<Min, Integer>{
    @Override
    public boolean isValid(Min anno, Integer obj) {
        if (obj < anno.min()) {
            message = "最小值为:" + anno.min();
            return false;
        }
        return true;
    }
}
