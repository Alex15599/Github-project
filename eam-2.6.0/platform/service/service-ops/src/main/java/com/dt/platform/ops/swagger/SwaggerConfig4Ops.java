package com.dt.platform.ops.swagger;

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
public class SwaggerConfig4Ops extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4Ops(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver, PlatformMeta.OPS_PACKAGE);
    }


    @Bean("OpsApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("运维服务管理")
                .description("运维服务管理相关的接口。")
                .version(PlatformMeta.VERSION)
                .build();
    }

}
