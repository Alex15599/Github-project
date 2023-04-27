package com.dt.platform.wms.swagger;

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
public class SwaggerConfig4Wms extends BasicSwaggerConfig {

    @Autowired
    public SwaggerConfig4Wms(OpenApiExtensionResolver openApiExtensionResolver) {
        super(openApiExtensionResolver, PlatformMeta.WMS_PACKAGE);
    }


    @Bean("WmsApiDocket")
    public Docket createRestApi() {
        return super.createRestApi();
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Wms系统")
                .description("Wms系统相关的接口。")
                .version(PlatformMeta.VERSION)
                .build();
    }

}
