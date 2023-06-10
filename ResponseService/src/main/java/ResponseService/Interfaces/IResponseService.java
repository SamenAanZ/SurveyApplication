package ResponseService.Interfaces;

import ResponseService.Model.ResponseList;

import java.util.Map;

public interface IResponseService {
    ResponseList getResponses(String surveyId);
    boolean createResponse(String surveyId, Map<String, String> answers);
}
