package com.post.az.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@EnableSwagger2
@Import({ModelMapperConfig.class
//        ,GlobalExceptionHandler.class,
//        LoggingTcpConfiguration.class, SpringFoxConfig.class,
//        SwaggerCorsConfigurer.class
})
@Configuration
public class Config {

}
