package SurveyService.Repository.Interfaces;

import SurveyService.Model.Survey;
import org.springframework.data.repository.CrudRepository;

public interface ISurveyDatabase extends CrudRepository<Survey, String> {
}
