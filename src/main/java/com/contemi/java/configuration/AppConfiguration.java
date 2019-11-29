package com.contemi.java.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.contemi.java.controllers")
@EnableJpaRepositories("com.contemi.java.repositories")
@PropertySource("classpath:general-conf.properties")
public class AppConfiguration {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "project.driver";
	private static final String PROPERTY_NAME_DATABASE_URL = "project.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "project.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "project.password";

//	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5InnoDBDialect";
//	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "false";
//	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "true";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.contemi.java.models";

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource setDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		driverManagerDataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		driverManagerDataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		driverManagerDataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return driverManagerDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(setDataSource());
		localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		localContainerEntityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
//		localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
		return localContainerEntityManagerFactoryBean;
	}

//	private Properties hibernateProperties() {
//		Properties properties = new Properties();
//		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
//		properties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
//		return properties;
//	}

	@Bean
	public JpaTransactionManager transactionManager() throws NamingException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
