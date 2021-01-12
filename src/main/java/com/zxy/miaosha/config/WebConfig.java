package com.zxy.miaosha.config;

import com.zxy.miaosha.access.AccessInterceptor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author Zhang xingyu
 * @Date 2020/12/8 09:32
 * @Version 1.0
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Autowired
  UserArgumentResolver userArgumentResolver;

  @Autowired
  AccessInterceptor accessInterceptor;

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(userArgumentResolver);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(accessInterceptor);
  }
}
