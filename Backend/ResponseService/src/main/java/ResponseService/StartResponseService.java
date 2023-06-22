package ResponseService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class StartResponseService {

	public static void main(String[] args) {
		SpringApplication.run(StartResponseService.class, args);
	}

}
