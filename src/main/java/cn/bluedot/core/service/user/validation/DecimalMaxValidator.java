package cn.bluedot.core.service.user.validation;

import java.math.BigDecimal;

import cn.bluedot.core.service.user.validation.annotation.DecimalMax;

public class DecimalMaxValidator extends AbstractValidator<DecimalMax, BigDecimal>{

    @Override
    public boolean isValid(DecimalMax anno, BigDecimal obj) {
        if (obj != null) {
            BigDecimal max = new BigDecimal(anno.maxDecimal());
            if (obj.compareTo(max) > 0) {
                message = "不能超过" + max.toString();
                return false;
            }
        }
        return true;
    }
    
}
