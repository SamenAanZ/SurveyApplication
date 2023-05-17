package SurveyApplication.SurveyService.Repository.Interfaces;

import SurveyApplication.SurveyService.Model.Survey;
import org.springframework.data.repository.CrudRepository;

public interface ISurveyDatabase extends CrudRepository<Survey, String> {
}
