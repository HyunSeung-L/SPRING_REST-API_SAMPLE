package org.hsl.sample_api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hsl.sample_api.utils.ValidationUtils;

@Aspect
public class ValidationAspect {

    @Pointcut("execution(* org.hsl.sample_api.service.UserService.joinUser(..))")
    private void joinUserTarget() {
    }

    @Around("joinUserTarget()")
    public Object checkEmail(ProceedingJoinPoint joinPoint) throws Throwable {
        String email = (String) joinPoint.getArgs()[0];
        if (ValidationUtils.isNotValidEmail(email)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다");
        }
        Object result = joinPoint.proceed();
        return result;
    }
}
