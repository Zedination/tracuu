package vn.edu.utc.tracuu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vn.edu.utc.tracuu.intereptor.SessionIntereptor;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> listPath = Arrays.asList("/admin/*");
        registry.addInterceptor(new SessionIntereptor()).addPathPatterns(listPath);
    }
}