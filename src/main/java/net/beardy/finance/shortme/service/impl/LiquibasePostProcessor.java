package net.beardy.finance.shortme.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class LiquibasePostProcessor {

    private static final String CREATE_SCHEME = "CREATE SCHEMA IF NOT EXISTS %s";

    private final JdbcTemplate jdbcTemplate;

    private final String defaultSchema;

    public LiquibasePostProcessor(DataSource dataSource, String defaultSchema) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.defaultSchema = defaultSchema;
    }

    public void initSchema() {
        jdbcTemplate.update(String.format(CREATE_SCHEME, defaultSchema));
    }

}
