package SurveyApplication.SurveyService.Repository.Interfaces;

import SurveyApplication.SurveyService.Model.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISurveyDatabase extends CrudRepository<Survey, String> {
    List<Survey> findAllByOwnerId(String ownerId);
}
