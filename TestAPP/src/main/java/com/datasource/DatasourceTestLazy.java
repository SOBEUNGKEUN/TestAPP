//package com.datasource;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jndi.JndiObjectFactoryBean;
//import org.springframework.jndi.JndiTemplate;
//
//import com.tmax.proobject.runtime.logger.ProObjectLogger;
//import com.tmax.proobject.runtime.logger.SystemLogger;
//import com.tmax.proobject.service.persistence.mybatis.spring.ProObjectSqlSessionFactoryBean;
//
//@Lazy
//@Configuration
//@MapperScan(basePackages="com", annotationClass=DatabaseTest.class, lazyInitialization = "true", sqlSessionFactoryRef="nonXaSqlSessionFactoryTest")
//public class DatasourceTestLazy {
//		
//		public ProObjectLogger logger = SystemLogger.getLogger();
//	
//	
//		@Bean(name = "jndiTemplateTest")
//		public JndiTemplate jndiTemplate() {
//			JndiTemplate jndiTemplate = new JndiTemplate();
//			Properties environment = new Properties(); 
//			environment.setProperty("java.naming.factory.initial", "jeus.jndi.JNSContextFactory");
//			jndiTemplate.setEnvironment(environment);
//
//			return jndiTemplate;
//		}
//		
//		@Bean(name="nonXaDataSourceTest")
//		public JndiObjectFactoryBean nonXaDataSource(@Qualifier("jndiTemplateTest")JndiTemplate jndiTemplateTest) { 
//			JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
//			
//			logger.info("\n### Test 데이터 소스 생성 ###");
//			jpfb.setJndiName("po21");
//			jpfb.setJndiTemplate(jndiTemplateTest);
//			jpfb.setProxyInterface(javax.sql.DataSource.class);
//			try {
//				jpfb.afterPropertiesSet();
////				return (DataSource) jpfb.getObject();
//				return jpfb;
//			}catch (Exception e){
//				throw new RuntimeException("Error creating DataSource bean from JNDI", e);
//			}
//		}
//		
//		@Bean(name="nonXaTransactionManagerTest")
//		public DataSourceTransactionManager nonXaTransactionManager(@Qualifier("nonXaDataSourceTest") DataSource nonXaDataSource) {
//			DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(nonXaDataSource);
//			
//			return transactionManager;
//		}
//
//		@Bean(name="nonXaSqlSessionFactoryTest")
//		public SqlSessionFactoryBean nonXaSqlSessionFactory(@Qualifier("nonXaDataSourceTest") DataSource nonXaDataSource, ApplicationContext applicationContext) throws Exception {
//			
//			logger.info("\n### Test ProObjectSqlSessionFactoryBean 생성 ###");
//			
//			ProObjectSqlSessionFactoryBean factoryBean = new ProObjectSqlSessionFactoryBean();
//			
//			factoryBean.setDataSource(nonXaDataSource);
//			factoryBean.setConfigLocation(applicationContext.getResource("classpath:com/datasource/DatasourceTest.xml"));
//			
//			return factoryBean;
//		}
//		
//		@Bean(name="nonXaSqlSessionTemplateTest")
//		public SqlSessionTemplate nonXaSqlSessionTemplate(@Qualifier("nonXaSqlSessionFactoryTest") SqlSessionFactory nonXaSqlSessionFactory) throws Exception {
//			return new SqlSessionTemplate(nonXaSqlSessionFactory);
//		}
//		
//	}
//
