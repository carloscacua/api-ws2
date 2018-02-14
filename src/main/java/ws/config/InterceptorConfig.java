package ws.config;

import ws.interceptors.HeaderValidatorInterceptor;
import ws.interceptors.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private HeaderValidatorInterceptor headerValidator;

    @Autowired
    private LoggerInterceptor loggerInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerValidator).addPathPatterns("/header/**");
        registry.addInterceptor(loggerInterceptor);
    }
}
