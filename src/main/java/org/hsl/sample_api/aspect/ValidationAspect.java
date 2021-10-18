package org.hsl.sample_api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hsl.sample_api.utils.ValidationUtils;

@Aspect
public class ValidationAspect {

    @Pointcut("@annotation(org.hsl.sample_api.annotation.ValidationAnnotation.CheckEmailFormat)")
    private void checkEmailPoint() {
    }

    @Before(value = "checkEmailPoint()")
    public void checkEmail(JoinPoint joinPoint) {
        String email = (String) joinPoint.getArgs()[0];
        if (ValidationUtils.isNotValidEmail(email)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다");
        }
    }
}
