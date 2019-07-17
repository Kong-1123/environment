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
                /**
                 * ----除了通过包路径配置扫描接口外，还可以通过配置其他方式扫描接口，这里注释一下所有的配置方式：
                 * any() // 扫描所有，项目中的所有接口都会被扫描到
                 * none() // 不扫描接口
                 * withMethodAnnotation(final Class<? extends Annotation> annotation)// 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                 * withClassAnnotation(final Class<? extends Annotation> annotation) // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                 * basePackage(final String basePackage) // 根据包路径扫描接口
                 */
                .apis(RequestHandlerSelectors.basePackage("com.xdmd.environment.*.controller"))
                //.apis(RequestHandlerSelectors.any())

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
