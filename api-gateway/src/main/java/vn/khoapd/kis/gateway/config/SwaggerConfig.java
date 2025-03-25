package vn.khoapd.kis.gateway.config;

import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springdoc.core.utils.Constants.DEFAULT_API_DOCS_URL;

@Configuration
public class SwaggerConfig {


    @Bean
    @Lazy(false)
    public Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> apis(RouteDefinitionLocator locator, SwaggerUiConfigProperties swaggerUiConfigProperties) {
        Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        if (definitions != null) {
            definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
                String name = routeDefinition.getId().replaceAll("-service", "");
                AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl = new AbstractSwaggerUiConfigProperties.SwaggerUrl(name, DEFAULT_API_DOCS_URL + "/" + name, null);
                urls.add(swaggerUrl);
            });
        }
        swaggerUiConfigProperties.setUrls(urls);
        return urls;
    }
}
