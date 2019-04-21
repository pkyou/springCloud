package com.boco.app.provider.Yserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * swwagger UI 配置类 在swagger UI 页面上只展示指定URL的接口
 *
 * @author pangkang 2018-1-25 11:56:03
 */
@Configuration
@EnableSwagger2
//@Controller
////@ApiIgnore
public class SwaggerConfig {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("y service 接口文档").description("服务提供y service").build();
    }

    @Value("${swagger.enable}")
    private boolean swaggerEnable;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // api扫包范围
                .apis(RequestHandlerSelectors.any()).build().enable(swaggerEnable);
    }
//    @Bean
//    public Docket api() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//
//        tokenPar.name("authorization").description("token").modelRef(new ModelRef("string")).defaultValue("")
//                .parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//                // .paths(PathSelectors.regex("/ap(i|p)/((?!login).)*"))
//                .paths(PathSelectors.regex("/ap(i|p)/.*")).build().globalOperationParameters(pars).apiInfo(apiInfo());
//    }

    @RequestMapping("/api")
    public void api(HttpServletResponse response) {
        try {
            String rUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/swagger-ui.html").build()
                    .toUriString();
            response.sendRedirect(rUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
