package ru.manannikov.jooqjpa.config;

import org.jooq.SQLDialect;
import org.jooq.conf.ExecuteWithoutWhere;
import org.jooq.conf.QueryPoolable;
import org.jooq.conf.RenderNameCase;
import org.jooq.conf.RenderQuotedNames;
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {
    @Bean
    public DefaultConfigurationCustomizer configurationCustomizer() {
        return c -> {
            c.setSQLDialect(SQLDialect.MARIADB);
            c.settings()
                .withRenderNameCase(RenderNameCase.AS_IS)
                .withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED)
                .withRenderSchema(false)
                .withRenderGroupConcatMaxLenSessionVariable(false)

                .withRenderFormatted(true)

                .withExecuteUpdateWithoutWhere(ExecuteWithoutWhere.THROW)
                .withExecuteDeleteWithoutWhere(ExecuteWithoutWhere.THROW)

                .withQueryTimeout(30)
                .withQueryPoolable(QueryPoolable.DEFAULT)
                .withMaxRows(1000);
        };
    }
}
