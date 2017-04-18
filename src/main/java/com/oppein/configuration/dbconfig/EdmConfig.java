package com.oppein.configuration.dbconfig;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.oppein.configuration.dbprop.EdmDatasourceProp;
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
@EnableJpaRepositories(basePackages = "com.oppein.repository.edm", entityManagerFactoryRef = "edmEntityManager", transactionManagerRef = "transactionManager")
@EnableConfigurationProperties(EdmDatasourceProp.class)
public class EdmConfig {

	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;

	@Autowired
	private EdmDatasourceProp edmDatasourceProp;

	@Bean(name = "edmDataSource", initMethod = "init", destroyMethod = "close")
	public DataSource edmDataSource() throws SQLException {
		 MariaDbDataSource mariaXaDataSource = new MariaDbDataSource();
		 mariaXaDataSource.setUrl(edmDatasourceProp.getUrl());
		 mariaXaDataSource.setPassword(edmDatasourceProp.getPassword());
		 mariaXaDataSource.setUser(edmDatasourceProp.getUsername());
		 AtomikosDataSourceBean oxaDataSource = new AtomikosDataSourceBean();
		 oxaDataSource.setXaDataSource(mariaXaDataSource);
		 oxaDataSource.setUniqueResourceName(edmDatasourceProp.getUniqueResourceName());
		 oxaDataSource.setBorrowConnectionTimeout(edmDatasourceProp.getBorrowConnectionTimeout());
		 oxaDataSource.setMaxPoolSize(edmDatasourceProp.getMaxPoolSize());
		 oxaDataSource.setMinPoolSize(edmDatasourceProp.getMinPoolSize());
		 return oxaDataSource;
	}

	@Bean(name = "edmEntityManager")
	public LocalContainerEntityManagerFactoryBean orderEntityManager() throws Throwable {

		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
		properties.put("javax.persistence.transactionType", "JTA");

		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(edmDataSource());
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.setPackagesToScan("com.oppein.domain.edm");
		entityManager.setPersistenceUnitName("edmPersistenceUnit");
		entityManager.setJpaPropertyMap(properties);
		return entityManager;
	}

}
