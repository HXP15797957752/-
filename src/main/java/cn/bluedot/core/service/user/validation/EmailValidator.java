package cn.bluedot.core.service.user.validation;

import java.util.regex.Pattern;

import cn.bluedot.core.service.user.validation.annotation.Email;

public class EmailValidator extends AbstractValidator<Email, String>{

    @Override
    public boolean isValid(Email anno, String obj) {
        if (obj != null) {
            Pattern p = Pattern.compile("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
            if (!p.matcher(obj).matches()) {
                message = "错误的邮箱格式";
                return false;
            }
        }
        return true;
    }
}
