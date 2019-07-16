package com.xdmd.environment.common;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    /**
     * 配置docket以配置Swagger具体参数
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.xdmd.environment.*"))
                .apis(RequestHandlerSelectors.any())
                //筛选接口
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Kong", "暂无", "kong_9527@outlook.com");
        return new ApiInfoBuilder()
                .title("Environment_API接口文档")
                .description("环保科研课题系统接口文档")
                .contact(contact)
                .version("v1.0.0")
                .build();
    }
}
