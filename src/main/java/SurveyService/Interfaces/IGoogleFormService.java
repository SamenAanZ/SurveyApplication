package SurveyService.Interfaces;

import com.google.api.services.forms.v1.model.Form;

import java.io.IOException;

public interface IGoogleFormService {
    Form createGoogleForm() throws IOException;
    boolean updateGoogleForm(String formId, String title, String description) throws IOException;
}
