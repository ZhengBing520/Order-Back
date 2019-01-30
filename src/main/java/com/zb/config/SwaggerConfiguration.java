package com.zb.config;

/**
 * Created by bzheng on 2019/1/7.
 */

import com.zb.common.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .globalOperationParameters(setHeaderToken())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zb.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置token参数（放在header中）
     * @return
     */
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(Constant.X_Auth_Token).description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    /**
     * API文档名称和版本
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商家对账系统--API文档")
                .description("本文档包含对账业务全部API数据接口。统一时间格式为“yyyy-MM-dd HH:mm:ss”，遇特殊情况会单独说明。")
                .version("1.1.0-SNAPSHOT") // 版本
                .build();
    }

}
