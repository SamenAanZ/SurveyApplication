package ResponseService.Repository.Interfaces;

import ResponseService.Model.Response;
import org.springframework.data.repository.CrudRepository;

public interface IResponseDatabase extends CrudRepository<Response, String> {
    Response[] findAllBySurveyId(String surveyId);
}
