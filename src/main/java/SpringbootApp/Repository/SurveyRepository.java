package SpringbootApp.Repository;

import SpringbootApp.Model.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, String> {
}
