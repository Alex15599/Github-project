package com.dt.platform.common.swagger;

import com.dt.platform.framework.PlatformMeta;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.github.foxnic.web.framework.knife4j.BasicSwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * Swagger API 相关配置
 */
@Configuration
public class SwaggerConfig4Common extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4Common(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver, PlatformMeta.COMMON_PACKAGE);
    }


    @Bean("CommonApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("管理")
                .description("管理相关的接口。")
                .version(PlatformMeta.VERSION)
                .build();
    }

}
