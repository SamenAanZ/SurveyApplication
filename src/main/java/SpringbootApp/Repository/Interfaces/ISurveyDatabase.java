package SpringbootApp.Repository.Interfaces;

import SpringbootApp.Model.Survey;
import org.springframework.data.repository.CrudRepository;

public interface ISurveyDatabase extends CrudRepository<Survey, String> {
}
