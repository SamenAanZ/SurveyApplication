package ResponseService.Repository;

import ResponseService.Interfaces.IResponseRepository;
import ResponseService.Model.Response;
import ResponseService.Repository.Interfaces.IResponseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ResponseRepository implements IResponseRepository {

    private IResponseDatabase database;

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
        } catch (Exception exception) {
            System.out.println(exception);
            return false;
        }
        return true;
    }
}
