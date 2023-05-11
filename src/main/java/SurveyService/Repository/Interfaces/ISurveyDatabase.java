package SurveyService.Repository.Interfaces;

import SurveyService.Model.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ISurveyDatabase extends CrudRepository<Survey, String> {
    Optional<Survey> findById(Long id);
}
