package cn.bluedot.core.service.user.validation;

import java.util.Date;

import cn.bluedot.core.service.user.validation.annotation.Future;

public class FutureValidator extends AbstractValidator<Future, Date>{

    @Override
    public boolean isValid(Future anno, Date obj) {
        if (obj != null) {
            if (!obj.after(new Date())) {
                message = "必须是未来的时间";
                return false;
            }
        }
        return true;
    }
}
