package SurveyService.Interfaces;

import SurveyService.Model.Survey;

import java.util.List;

public interface ISurveyRepository {
    Survey createSurvey(Survey survey);
    List<Survey> getSurveys();
    Survey getSurvey(Long id);
}
