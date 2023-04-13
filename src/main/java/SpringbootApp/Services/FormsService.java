package SpringbootApp.Services;

import SpringbootApp.Interfaces.IFormsService;
import SpringbootApp.Interfaces.IGoogleFormService;
import SpringbootApp.Interfaces.ISurveyRepository;
import SpringbootApp.Model.Survey;
import SpringbootApp.Repository.SurveyRepository;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.forms.v1.Forms;
import com.google.api.services.forms.v1.FormsScopes;
import com.google.api.services.forms.v1.model.Form;
import com.google.api.services.forms.v1.model.Info;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FormsService implements IFormsService {
    private ISurveyRepository surveyRepository;
    private IGoogleFormService googleFormService;

    @Autowired
    public FormsService(ISurveyRepository surveyRepository, IGoogleFormService googleFormService) {
        this.surveyRepository = surveyRepository;
        this.googleFormService = googleFormService;
    }

    public String createNewForm(String title, String description) throws IOException {
        Form form = googleFormService.createGoogleForm();
        if(form == null) return null;

        Survey survey = new Survey(form.getFormId(), form.getResponderUri(), form.getInfo().getTitle(), "");

        if(!surveyRepository.createSurvey(survey)) return null;

        return form.getFormId();
    }

    public List<Survey> getForms() {
        return surveyRepository.getSurveys();
    }

    public Survey getForm(String id) {
        return surveyRepository.getSurvey(id);
    }

}
