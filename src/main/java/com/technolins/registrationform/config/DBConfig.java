package com.technolins.registrationform.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.technolins.registrationform"})
@EnableJpaRepositories(
		entityManagerFactoryRef = "dbEntityManagerFactory",
		transactionManagerRef = "dbTransactionManager",
		basePackages = { "com.technolins.registrationform"})
public class DBConfig {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String urlDB;
	@Value("${spring.datasource.username}")
	private String userNameDb;
	@Value("${spring.datasource.password}")
	private String passwordDb;
	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "dbDataSource")
	public DataSource dbDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(urlDB);
		dataSource.setUsername(userNameDb);
		dataSource.setPassword(passwordDb);

		return dataSource;
	}

	@Primary
	@Bean(name = "dbEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean dbEntityManagerFactory(
			EntityManagerFactoryBuilder builder,
			@Qualifier("dbDataSource") DataSource dbDataSource
			) {
		return builder
				.dataSource(dbDataSource)
				.packages("com.technolins.registrationform")
				.persistenceUnit("db")
				.build();
	}

	@Primary
	@Bean(name = "dbTransactionManager")
	public PlatformTransactionManager dbTransactionManager(
			@Qualifier("dbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
}