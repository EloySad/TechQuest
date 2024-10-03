package com.tq.tq.config.Database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = "com.tq.tq.persistence.postgre.repository",
        entityManagerFactoryRef = "postgresqlEMF",
        transactionManagerRef = "postgresqlTrxManager"
)
@EnableTransactionManagement
public class PostgreSqlJpaConfig {

    @Bean("postgresqlEMF")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(
            @Qualifier("postgresqlDatasource") DataSource postgresqlDS,
            EntityManagerFactoryBuilder builder) {

        Map<String, String> additionalProps = new HashMap<>();
        additionalProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        additionalProps.put("hibernate.hbm2ddl.auto", "update");

        return builder
                .dataSource(postgresqlDS)
                .persistenceUnit("postgresql")
                .properties(additionalProps)
                .packages("com.tq.tq.persistence.postgre.entity")
                .build();
    }

    @Bean("postgresqlTrxManager")
    public JpaTransactionManager getPostgresqlTrxManager(@Qualifier("postgresqlEMF") LocalContainerEntityManagerFactoryBean postgresqlEMF) {
        return new JpaTransactionManager(Objects.requireNonNull(postgresqlEMF.getObject()));
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
}
