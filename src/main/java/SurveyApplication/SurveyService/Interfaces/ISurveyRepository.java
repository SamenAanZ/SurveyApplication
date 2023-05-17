package SurveyApplication.SurveyService.Interfaces;

import SurveyApplication.SurveyService.Model.Survey;

import java.util.List;

public interface ISurveyRepository {
    Survey createSurvey(Survey survey);
    List<Survey> getSurveys();
    Survey getSurvey(String id);
}
