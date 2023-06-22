package SurveyService.Controllers;

import SurveyService.Interfaces.IFormsService;
import SurveyService.Model.DTO.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageController {
    IFormsService formsService;
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    public MessageController(IFormsService formsService, RabbitTemplate template, ObjectMapper mapper) {
        this.formsService = formsService;
        this.rabbitTemplate = template;
        this.objectMapper = mapper;
    }

    @RabbitListener(queues = "UnverifiedResponseQueue")
    public void receiveResponse(String message) throws JsonProcessingException {
        ResponseMessage response = objectMapper.readValue(message, ResponseMessage.class);

        if (formsService.getForm(response.getSurveyId()) != null) {
            rabbitTemplate.convertAndSend("VerifiedResponseQueue", message);
        } else {
            System.out.println("Given survey could not be found! " + response.getSurveyId());
        }
        // Response already gets consumed, so nothing else has to be done
    }
}
