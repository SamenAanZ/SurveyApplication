package SurveyService.Interfaces;

import SurveyService.Model.Survey;

import java.util.List;

public interface ISurveyRepository {
    Survey createSurvey(Survey survey);
    Survey updateSurvey(Survey survey);
    List<Survey> getSurveys();
    Survey getSurvey(String id);
    List<Survey> getSurveysByOwnerId(String ownerId);
    List<Survey> getSurveysByUserId(String userId);
}
