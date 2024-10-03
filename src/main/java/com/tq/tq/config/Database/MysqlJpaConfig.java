package com.tq.tq.config.Database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.tq.tq.persistence.mysql.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
@EnableTransactionManagement
public class MysqlJpaConfig {
    @Primary
    @Bean("mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(@Qualifier("mysqlDatasource") DataSource mysqlDatasource) {

        LocalContainerEntityManagerFactoryBean localContainer = new LocalContainerEntityManagerFactoryBean();
        localContainer.setDataSource(mysqlDatasource);
        localContainer.setPersistenceUnitName("mysql");
        localContainer.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, String> additionalProperties = new HashMap<>();
        additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        additionalProperties.put("hibernate.hbm2ddl.auto", "update");  // Configura el ddl-auto aquí

        localContainer.setJpaPropertyMap(additionalProperties);
        localContainer.setPackagesToScan("com.tq.tq.persistence.mysql.entity");
        return localContainer;
    }

    @Bean("mysqlTransactionManager")
    public JpaTransactionManager getMysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(mysqlEntityManagerFactory.getObject()));
    }
}