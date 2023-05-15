package ResponseService.Services;

import ResponseService.Interfaces.IResponseRepository;
import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.Response;
import ResponseService.Model.ResponseList;
import SurveyService.Interfaces.IFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResponseService implements IResponseService {

    private IResponseRepository responseRepository;

    @Autowired
    public ResponseService(IResponseRepository repository) {
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

    public boolean createResponse(String surveyId, Map<String, String> answers) {
        // This should later be replaced with either an API call, message bus etc.
        // if(formService.getForm(surveyId) == null) return false;

        Response response = new Response(surveyId, answers);

        return responseRepository.createResponse(response);
    }
}
