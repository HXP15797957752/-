package cn.bluedot.core.service.user.validation;

import java.util.Date;

import cn.bluedot.core.service.user.validation.annotation.Past;

public class PastValidator extends AbstractValidator<Past, Date>{
    @Override
    public boolean isValid(Past anno, Date obj) {
        if (obj != null) {
            if (!obj.before(new Date())) {
                message = "必须是先前的时间";
                return false;
            }
        }
        return true;
    }
}
