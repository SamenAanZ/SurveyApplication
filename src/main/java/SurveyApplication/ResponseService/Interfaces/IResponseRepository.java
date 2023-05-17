package SurveyApplication.ResponseService.Interfaces;

import SurveyApplication.ResponseService.Model.Response;

public interface IResponseRepository {
    Response[] getResponses(String surveyId);
    boolean createResponse(Response response);
}
