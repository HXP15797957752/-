package cn.bluedot.core.service.user.validation;

import java.math.BigDecimal;

import cn.bluedot.core.service.user.validation.annotation.DecimalMin;

public class DecimalMinValidator extends AbstractValidator<DecimalMin, BigDecimal>{

    @Override
    public boolean isValid(DecimalMin anno, BigDecimal obj) {
        if (obj != null) {
            BigDecimal min = new BigDecimal(anno.minDecimal());
            if (obj.compareTo(min) < 0) {
                message = "不能小于" + min.toString();
                return false;
            }
        }
        return true;
    }
    
}
