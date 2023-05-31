package SurveyApplication.SurveyService.Repository.Interfaces;

import SurveyApplication.SurveyService.Model.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISurveyDatabase extends CrudRepository<Survey, String> {
    List<Survey> findAllByOwnerId(String ownerId);

    @Query("SELECT survey FROM Survey survey WHERE :userId MEMBER OF survey.userIds")
    List<Survey> findAllByUserIdsContaining(@Param("userId") String userId);
}
