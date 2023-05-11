package SurveyService.Interfaces;

import SurveyService.Model.Survey;

import java.util.List;

public interface ISurveyRepository {
    boolean createSurvey(Survey survey);
    List<Survey> getSurveys();
    Survey getSurvey(String id);
}
