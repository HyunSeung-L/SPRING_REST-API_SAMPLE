package org.hsl.sample_api.config;

import org.hsl.sample_api.aspect.ValidationAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean
    public ValidationAspect ValidationAspect() {
        return new ValidationAspect();
    }
}
