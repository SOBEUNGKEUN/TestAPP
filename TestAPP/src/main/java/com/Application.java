package com;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.tmax.proobject.runtime.ProObjectServletInitializer;
import com.tmax.proobject.runtime.application.autoconfigure.ProObjectApplication;

@ProObjectApplication(exclude = { JdbcTemplateAutoConfiguration.class }, scanBasePackageClasses = Application.class)
public class Application extends ProObjectServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		super.configure(application);
		return application.sources(Application.class);
	}
}
