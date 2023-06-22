package ApiGateway;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${survey-service.host}")
    private String surveyServiceHost;

    @Value("${response-service.host}")
    private String responseServiceHost;

    @Bean
    public RouteLocator internalRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/survey/**")
                        .uri("http://" + surveyServiceHost + ":8082"))
                .route(p -> p
                        .path("/response/**")
                        .uri("http://" + responseServiceHost + ":8083"))
                .build();
    }


}

