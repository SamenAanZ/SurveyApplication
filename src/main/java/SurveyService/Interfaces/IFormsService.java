package SurveyService.Interfaces;

import SurveyService.Model.Question;
import SurveyService.Model.Survey;

import java.io.IOException;
import java.util.List;

public interface IFormsService {
    String createNewForm(String title, String description, List<Question> questions) throws IOException;
    List<Survey> getForms();
    Survey getForm(String  id);
}
