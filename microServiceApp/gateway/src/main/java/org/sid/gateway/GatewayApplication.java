package org.sid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder ){
		return builder.routes()
				.route(r->r.path("/Costumer/**").uri("http://localhost:8081/"))
				.route(r->r.path("/Product/**")).uri("http://localhost:8082"))
		.build();
	}
}
