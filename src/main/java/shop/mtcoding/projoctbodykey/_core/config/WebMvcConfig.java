package shop.mtcoding.projoctbodykey._core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import shop.mtcoding.projoctbodykey._core.interceptor.LoginInterceptor;
import shop.mtcoding.projoctbodykey.activity.ActivityService;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final ActivityService activityService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 로그인 인증
        registry.addInterceptor(new LoginInterceptor(activityService))
                .addPathPatterns("/api/**")
                .excludePathPatterns("/login", "/join");

//        // 로그인 시 호출
//        registry.addInterceptor(new LoginInterceptor(activityService))
//                .addPathPatterns("/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        //upload 폴더에 파일 저장
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:./upload/")
                .setCachePeriod(60 * 60) // 초 단위 => 한시간
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
