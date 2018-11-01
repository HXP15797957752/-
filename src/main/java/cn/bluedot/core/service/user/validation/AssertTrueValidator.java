package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.AssertFalse;

public class AssertTrueValidator extends AbstractValidator<AssertFalse, Boolean> {

    @Override
    public boolean isValid(AssertFalse anno, Boolean obj) {
        if (obj != null && obj != true) {
            message = "必须是True";
            return false;
        }
        
        return true;
    }

}
