package SurveyService.Interfaces;

import SurveyService.Model.Survey;

import java.io.IOException;
import java.util.List;

public interface IFormsService {
    Long createNewForm(String title, String description) throws IOException;
    List<Survey> getForms();
    Survey getForm(Long id);
}
