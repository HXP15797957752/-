package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.NotEmpty;

public class NotEmptyValidator extends AbstractValidator<NotEmpty, String>{

    @Override
    public boolean isValid(NotEmpty anno, String obj) {
        if (obj != null && "".equals(obj)) {
            message = "不能为空";
            return false;
        }
        return true;
    }

}
