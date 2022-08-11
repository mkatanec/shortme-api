package net.beardy.finance.shortme.config;

import net.beardy.finance.shortme.service.impl.LiquibasePostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(LiquibaseDependsOnBeanFactoryPostProcessor.class)
public class LiquibasePostProcessorConfig {

    @Bean
    public LiquibasePostProcessor liquibasePostProcessor(DataSource dataSource,
        @Value("${spring.liquibase.default-schema}") String defaultSchema) {
        final LiquibasePostProcessor liquibasePostProcessor = new LiquibasePostProcessor(dataSource, defaultSchema);

        liquibasePostProcessor.initSchema();

        return liquibasePostProcessor;
    }

}
