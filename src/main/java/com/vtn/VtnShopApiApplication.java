package com.vtn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
public class VtnShopApiApplication {

    //	@Configuration
//    public class WebConfig implements WebMvcConfigurer {      
//        @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/**")
//            .addResourceLocations("classpath:/static/","classpath:/image/")
//            .setCachePeriod(0);
//        }
//    }
    public static void main(String[] args) {
        SpringApplication.run(VtnShopApiApplication.class, args);
    }



}
