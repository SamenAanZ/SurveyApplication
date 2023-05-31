package SurveyApplication.SurveyService.Interfaces;

import SurveyApplication.SurveyService.Model.Question;
import SurveyApplication.SurveyService.Model.Survey;

import java.io.IOException;
import java.util.List;

public interface IFormsService {
    String createNewForm(Survey survey) throws IOException;
    List<Survey> getForms();
    Survey getForm(String id);
    List<Survey> getSurveysByOwnerId(String ownerId);
    List<Survey> getSurveysByUserId(String userId);
}
