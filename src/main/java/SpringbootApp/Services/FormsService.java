package SpringbootApp.Services;

import SpringbootApp.Interfaces.IFormsService;
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

    private static final String APPLICATION_NAME = "Forms test app";
    private static Forms formsService;

    @Autowired
    private SurveyRepository surveyRepository;

    static {
        try {
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            formsService = new Forms.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                    jsonFactory, null)
                    .setApplicationName(APPLICATION_NAME).build();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public FormsService() {
    }

    private String getAccessToken() throws IOException {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("google-app-credentials.json");
        GoogleCredentials credential = GoogleCredentials.fromStream(Objects.requireNonNull(resource)).createScoped(FormsScopes.all());
        String accessToken = credential.getAccessToken() != null ?
                credential.getAccessToken().getTokenValue() :
                credential.refreshAccessToken().getTokenValue();
        return accessToken;
    }

    public List<Survey> getForms() {
        return (List<Survey>) surveyRepository.findAll();
    }

    public Survey getForm(String id) {
        Optional<Survey> dbResponse = surveyRepository.findById(id);
        return dbResponse.isEmpty() ? null : dbResponse.get();
    }

    @Override
    public String createNewForm() throws IOException {
        String token = getAccessToken();
        Form form = new Form();
        form.setInfo(new Info());
        form.getInfo().setTitle("This is a default new form");

        form = formsService.forms().create(form)
                .setAccessToken(token)
                .execute();

        Survey survey = new Survey(form.getFormId(), form.getResponderUri(), form.getInfo().getTitle());

        try {
            surveyRepository.save(survey);
        } catch (Exception ex) {
            return null;
        }
        return form.getFormId();
    }
}
