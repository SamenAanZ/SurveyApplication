package SurveyApplication.ResponseService.Repository;

import SurveyApplication.ResponseService.Interfaces.IResponseRepository;
import SurveyApplication.ResponseService.Model.Response;
import SurveyApplication.ResponseService.Repository.Interfaces.IResponseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResponseRepository implements IResponseRepository {

    IResponseDatabase database;

    @Autowired
    public ResponseRepository(IResponseDatabase database) {
        this.database = database;
    }

    public Response[] getResponses(String surveyId) {
        return database.findAllBySurveyId(surveyId);
    }

    public boolean createResponse(Response response) {
        try {
            database.save(response);
            return true;
        } catch (Exception exception) {
            System.out.println(exception);
            return false;
        }
    }
}
