package net.beardy.finance.shortme.config;

import liquibase.integration.spring.SpringLiquibase;
import net.beardy.finance.shortme.service.impl.LiquibasePostProcessor;
import org.springframework.boot.autoconfigure.AbstractDependsOnBeanFactoryPostProcessor;

public class LiquibaseDependsOnBeanFactoryPostProcessor extends AbstractDependsOnBeanFactoryPostProcessor {

    public LiquibaseDependsOnBeanFactoryPostProcessor() {
        super(SpringLiquibase.class, LiquibasePostProcessor.class);
    }

}
