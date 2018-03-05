package com.github.rnowley.trainer.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.sql.SQLException;
import java.util.regex.Pattern;

@Configuration
@Import(JpaConfig.class)
@ComponentScan(basePackages = {"com.github.rnowley.trainer"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)})
public class RootConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public org.h2.tools.Server h2WebConsoleServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webDaemon", "-webPort", "8082");
    }

    public static class WebPackage extends RegexPatternTypeFilter {

        public WebPackage() {
            super(Pattern.compile("com\\.github\\.rnowley\\.trainer\\.web"));
        }

    }
}
