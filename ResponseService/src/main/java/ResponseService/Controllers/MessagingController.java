package ResponseService.Controllers;

import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.DTO.ResponseMessage;
import ResponseService.Model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessagingController {
    private final IResponseService responseService;

    @Autowired
    public MessagingController(IResponseService responseService) {
        this.responseService = responseService;
    }

    @RabbitListener(queues = "VerifiedResponseQueue")
    public void receiveVerifiedResponse(String message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseMessage responseMessage = objectMapper.readValue(message, ResponseMessage.class);

        Response response = new Response(responseMessage.getSurveyId(), responseMessage.getAnswers());
        this.responseService.createVerifiedResponse(response);
    }
}
