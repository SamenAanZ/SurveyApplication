package ResponseService.Interfaces;

import ResponseService.Model.Response;

public interface IResponseRepository {
    Response[] getResponses(String surveyId);
    boolean createResponse(Response response);
}
