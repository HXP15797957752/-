package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.AssertFalse;

public class AssertFalseValidator extends AbstractValidator<AssertFalse, Boolean> {

    @Override
    public boolean isValid(AssertFalse anno, Boolean obj) {
        if (obj != null && obj != false) {
            message = "必须是False";
            return false;
        }
        return true;
    }

}
