package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.NotNull;

public class NotNullValidator extends AbstractValidator<NotNull, Object>{


    @Override
    public boolean isValid(NotNull anno, Object obj) {
        if (obj == null) {
            message = "不能为Null";
            return false;
        }
        return true;
    }

}

