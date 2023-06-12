package ResponseService.Interfaces;

import ResponseService.Model.Response;
import ResponseService.Model.ResponseList;

import java.io.IOException;
import java.util.Map;

public interface IResponseService {
    ResponseList getResponses(String surveyId);
    void verifyResponse(String surveyId, Map<String, String> answers) throws IOException;
    void createVerifiedResponse(Response response) throws IOException;
}
