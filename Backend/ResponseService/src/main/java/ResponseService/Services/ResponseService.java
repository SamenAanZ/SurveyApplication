package ResponseService.Services;

import ResponseService.Interfaces.IResponseRepository;
import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.DTO.ResponseMessage;
import ResponseService.Model.Response;
import ResponseService.Model.ResponseList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResponseService implements IResponseService {

    private IResponseRepository responseRepository;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ResponseService(IResponseRepository repository, RabbitTemplate template) {
        this.rabbitTemplate = template;
        this.responseRepository = repository;
    }

    public ResponseList getResponses(String surveyId) {
        Response[] responses = responseRepository.getResponses(surveyId);
        List<Map<String, String>> answers = new ArrayList<Map<String, String>>();
        for (Response response : responses) {
            Map<String, String> answerMap = response.getAnswerList();
            answers.add(answerMap);
        }

        int totalResponses = responses.length;

        ResponseList responseList = new ResponseList(totalResponses, answers);
        return responseList;
    }

    public void verifyResponse(String surveyId, Map<String, String> answers) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage(surveyId, answers);
        ObjectMapper objectMapper = new ObjectMapper();
        rabbitTemplate.convertAndSend("UnverifiedResponseQueue", objectMapper.writeValueAsString(responseMessage));
    }

    public void createVerifiedResponse(Response response) {
        responseRepository.createResponse(response);
    }
}
