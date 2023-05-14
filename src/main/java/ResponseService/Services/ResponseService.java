package ResponseService.Services;

import ResponseService.Interfaces.IResponseRepository;
import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.Response;
import SurveyService.Interfaces.IFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResponseService implements IResponseService {

    private IResponseRepository responseRepository;
    private IFormsService formService;

    @Autowired
    public ResponseService(IResponseRepository repository, IFormsService formService) {
        this.responseRepository = repository;
        this.formService = formService;
    }

    public boolean createResponse(String surveyId, Map<String, String> answers) {
        // This should later be replaced with either an API call, message bus etc.
        if(formService.getForm(surveyId) == null) return false;

        Response response = new Response(surveyId, answers);

        if(!responseRepository.createResponse(response)) return false;
        return true;
    }
}
