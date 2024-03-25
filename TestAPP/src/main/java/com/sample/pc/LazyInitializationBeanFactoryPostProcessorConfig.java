//package com.sample.pc;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.boot.LazyInitializationBeanFactoryPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.tmax.proobject.runtime.logger.ProObjectLogger;
//import com.tmax.proobject.runtime.logger.SystemLogger;
//
//@Configuration
//public class LazyInitializationBeanFactoryPostProcessorConfig {
//	
//	public ProObjectLogger logger = SystemLogger.getLogger();
//	@PostConstruct
//	public void adfasdad() {
//		logger.info("소병권");
//	}
//	@Bean
//	public LazyInitializationBeanFactoryPostProcessor testss ()
//	
//	{		
//		logger.info("소병권222");
//		return new LazyInitializationBeanFactoryPostProcessor();
//		
//	}
//}
