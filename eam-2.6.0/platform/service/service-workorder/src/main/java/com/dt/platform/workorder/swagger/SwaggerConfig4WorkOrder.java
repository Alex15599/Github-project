package com.dt.platform.workorder.swagger;

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
public class SwaggerConfig4WorkOrder extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4WorkOrder(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver, PlatformMeta.WORKORDER_PACKAGE);
    }


    @Bean("DcApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工单管理")
                .description("工单管理相关的接口。")
                .version(PlatformMeta.VERSION)
                .build();
    }

}
