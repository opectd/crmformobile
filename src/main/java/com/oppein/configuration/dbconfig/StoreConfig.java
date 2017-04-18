package com.oppein.configuration.dbconfig;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.oppein.configuration.dbprop.StoreDatasourceProp;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;


@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "com.oppein.repository.store", entityManagerFactoryRef = "storeEntityManager", transactionManagerRef = "transactionManager")
@EnableConfigurationProperties(StoreDatasourceProp.class)
public class StoreConfig {

	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;

	@Autowired
	private StoreDatasourceProp storeDatasourceProp;

	@Bean(name = "storeDataSource", initMethod = "init", destroyMethod = "close")
	public DataSource storeDataSource() throws SQLException {
		MariaDbDataSource mariaXaDataSource = new MariaDbDataSource();
		mariaXaDataSource.setUrl(storeDatasourceProp.getUrl());
		mariaXaDataSource.setPassword(storeDatasourceProp.getPassword());
		mariaXaDataSource.setUser(storeDatasourceProp.getUsername());
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();

		xaDataSource.setXaDataSource(mariaXaDataSource);
		xaDataSource.setUniqueResourceName(storeDatasourceProp.getUniqueResourceName());
		xaDataSource.setBorrowConnectionTimeout(storeDatasourceProp.getBorrowConnectionTimeout());
		xaDataSource.setMaxPoolSize(storeDatasourceProp.getMaxPoolSize());
		xaDataSource.setMinPoolSize(storeDatasourceProp.getMinPoolSize());
		return xaDataSource;

	}


	@Bean(name = "storeEntityManager")
	@DependsOn("transactionManager")
	public LocalContainerEntityManagerFactoryBean customerEntityManager() throws Throwable {

		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
		properties.put("javax.persistence.transactionType", "JTA");

		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(storeDataSource());
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.setPackagesToScan("com.oppein.domain.store");
		entityManager.setPersistenceUnitName("crmPersistenceUnit");
		entityManager.setJpaPropertyMap(properties);
		return entityManager;
	}

}
