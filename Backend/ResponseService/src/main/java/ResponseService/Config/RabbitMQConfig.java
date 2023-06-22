package ResponseService.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue unverifiedResponseQueue() {
        return new Queue("UnverifiedResponseQueue", false);
    }

    @Bean
    public Queue verifiedResponseQueue() {
        return new Queue("VerifiedResponseQueue", false);
    }
}