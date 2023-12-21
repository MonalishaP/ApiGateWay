package org.jt.ApiGetWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGetWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetWayApplication.class, args);
	}
	
	
	@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("patient-service", r -> r
                        .path("/api/**")
                        .uri("http://localhost:8089")) // Forward to service running at http://localhost:8081
                .build();
    }

}
