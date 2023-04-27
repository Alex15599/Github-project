package com.dt.platform.wrapper;

import com.dt.platform.framework.PlatformMeta;
import com.foxnicweb.web.contract.framework.ContractMeta;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		// Foxnic-Web
		FoxnicWebMeta.SERVICE_STORAGE_PACKAGE ,
		FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE ,
		FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		FoxnicWebMeta.SERVICE_HRM_PACKAGE,
		FoxnicWebMeta.SERVICE_PCM_PACKAGE,
		FoxnicWebMeta.SERVICE_CHANGES_PACKAGE,
		FoxnicWebMeta.SERVICE_BPM_PACKAGE,
		FoxnicWebMeta.SERVICE_DATA_PERM_PACKAGE,
		FoxnicWebMeta.SERVICE_JOB_PACKAGE,
		FoxnicWebMeta.SERVICE_DOCS_PACKAGE,
		FoxnicWebMeta.SERVICE_EXAMPLE_PACKAGE,
		// EAM
		PlatformMeta.FRAMEWORK_PACKAGE,
		PlatformMeta.SERVICE_EAM_PACKAGE,
		PlatformMeta.SERVICE_HR_PACKAGE,
		PlatformMeta.DATACENTER_PACKAGE,
		PlatformMeta.CMS_PACKAGE,
		PlatformMeta.OPS_PACKAGE,
		PlatformMeta.COMMON_PACKAGE,
		PlatformMeta.KNOWLEDGEBASE_PACKAGE,
		PlatformMeta.JOB_PACKAGE,
		PlatformMeta.CUSTOMER_PACKAGE,
		PlatformMeta.VEHICLE_PACKAGE,
		PlatformMeta.WORKORDER_PACKAGE,
		PlatformMeta.MOBILE_PACKAGE,
		PlatformMeta.WMS_PACKAGE,
		PlatformMeta.OA_PACKAGE,
		// 合同
		ContractMeta.SERVICE_CONTRACT_PACKAGE
})
@SpringBootApplication
public class WrapperAllApp {
	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}
}
