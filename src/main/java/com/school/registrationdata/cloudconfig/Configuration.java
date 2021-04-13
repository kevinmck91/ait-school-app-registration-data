package com.school.registrationdata.cloudconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("registration-data")
@Component
public class Configuration {
	

	private String environmentCode;

	public String getEnvironmentCode() {
		return environmentCode;
	}

	public void setEnvironmentCode(String environmentCode) {
		this.environmentCode = environmentCode;
	}

	@Override
	public String toString() {
		return "Configuration : " +
				",  environmentCode = '" + environmentCode + '\'' ;
	}
}
