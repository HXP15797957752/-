package cn.bluedot.core.service.user.validation;

import cn.bluedot.core.service.user.validation.annotation.Pattern;

public class PatternValidator extends AbstractValidator<Pattern, String>{

    @Override
    public boolean isValid(Pattern anno, String obj) {
        if (obj != null && !java.util.regex.Pattern.matches(anno.regular(), obj)) {
            message = "不匹配给定的正规表达式:" + anno.regular();
            return false;
        }
        
        return true;
    }
    
}
