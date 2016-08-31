package com.yihukurama.websercice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yihukurama.websercice"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("微服务中的RESTful APIs 文档")
                .description("该服务是使用springboot搭建，运用nginx反向代理服务器和tomcat容器在centOS下运行，"
                		+ "并采用Jenkins持续集成的个人小项目")
                .termsOfServiceUrl("http://www.lovebanks.cn/webservice")
                .contact("yihukurama")
                .version("1.0")
                .build();
    }

}