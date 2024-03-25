package com.datasource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import com.tmax.proobject.runtime.logger.ProObjectLogger;
import com.tmax.proobject.runtime.logger.SystemLogger;

@Configuration
@MapperScan(basePackages="com", annotationClass=DatabaseTest.class, sqlSessionFactoryRef="nonXaSqlSessionFactoryTest")
public class DatasourceTest {
		
		public ProObjectLogger logger = SystemLogger.getLogger();
		
		@Bean(name = "jndiTemplateTest")
		public JndiTemplate jndiTemplate() {
			JndiTemplate jndiTemplate = new JndiTemplate();
			Properties environment = new Properties();
			environment.setProperty("java.naming.factory.initial", "jeus.jndi.JNSContextFactory");
			jndiTemplate.setEnvironment(environment);

			return jndiTemplate;
		}
		
		@Bean(name="nonXaDataSourceTest")
		public JndiObjectFactoryBean nonXaDataSource(@Qualifier("jndiTemplateTest")JndiTemplate jndiTemplateTest) { 
			JndiObjectFactoryBean jpfb = new JndiObjectFactoryBean();
			
			logger.info("\n### Test 데이터 소스 생성 ###");
			jpfb.setJndiName("po21");
			jpfb.setJndiTemplate(jndiTemplateTest);
			
			logger.info("\n### Test 데이터 소스 생성 성공 ###");
			return jpfb;
		}
		
		@Bean(name="nonXaTransactionManagerTest")
		public DataSourceTransactionManager nonXaTransactionManager(@Qualifier("nonXaDataSourceTest") DataSource nonXaDataSource) {
			DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(nonXaDataSource);
			
			return transactionManager;
		}

		@Bean(name="nonXaSqlSessionFactoryTest")
		public SqlSessionFactory nonXaSqlSessionFactory(@Qualifier("nonXaDataSourceTest") DataSource nonXaDataSource, ApplicationContext applicationContext) throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			
			factoryBean.setDataSource(nonXaDataSource); 
			factoryBean.setConfigLocation(applicationContext.getResource("classpath:com/datasource/DatasourceTest.xml"));
			
			return factoryBean.getObject();
		}
		
		@Bean(name="nonXaSqlSessionTemplateTest")
		public SqlSessionTemplate nonXaSqlSessionTemplate(@Qualifier("nonXaSqlSessionFactoryTest") SqlSessionFactory nonXaSqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(nonXaSqlSessionFactory);
		}
		
	}

