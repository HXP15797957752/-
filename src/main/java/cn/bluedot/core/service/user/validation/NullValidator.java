package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.Null;

public class NullValidator extends AbstractValidator<Null, Object>{

    @Override
    public boolean isValid(Null anno, Object obj) {
        if (obj != null) {
            message = "必须为Null";
            return false;
        }
        return true;
    }

}
