package SurveyService.Interfaces;

import SurveyService.Model.Question;
import SurveyService.Model.Survey;
import SurveyService.Model.SurveyState;

import java.io.IOException;
import java.util.List;

public interface IFormsService {
    String createNewForm(Survey survey) throws IOException;
    Survey changeSurveyState(String id, SurveyState newState);
    List<Survey> getForms();
    Survey getForm(String id);
    List<Survey> getSurveysByOwnerId(String ownerId);
    List<Survey> getSurveysByUserId(String userId);
}
