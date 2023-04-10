package Services;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.forms.v1.Forms;
import com.google.api.services.forms.v1.FormsScopes;
import com.google.api.services.forms.v1.model.Form;
import com.google.api.services.forms.v1.model.Info;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Objects;


@RestController
@RequestMapping("/survey")
public class SurveyController {

    private static final String APPLICATION_NAME = "Forms test app";
    private static Drive driveService;
    private static Forms formsService;

    static {
        try {
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

            driveService = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                    jsonFactory, null)
                    .setApplicationName(APPLICATION_NAME).build();

            formsService = new Forms.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                    jsonFactory, null)
                    .setApplicationName(APPLICATION_NAME).build();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getAccessToken() throws IOException {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("google-app-credentials.json");
        GoogleCredentials credential = GoogleCredentials.fromStream(Objects.requireNonNull(resource)).createScoped(FormsScopes.all());
        String accessToken = credential.getAccessToken() != null ?
                credential.getAccessToken().getTokenValue() :
                credential.refreshAccessToken().getTokenValue();
        return accessToken;
    }

    private static String createNewForm(String token) throws IOException {
        Form form = new Form();
        form.setInfo(new Info());
        form.getInfo().setTitle("This is a default new form");

        form = formsService.forms().create(form)
                .setAccessToken(token)
                .execute();

        return form.getFormId();
    }

    @GetMapping("/token")
    public ResponseEntity getToken() throws IOException {
        String token = getAccessToken();
        if(token == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(token);
    }

    @PostMapping
    public ResponseEntity createSurvey() throws GeneralSecurityException, IOException {

        String token = getAccessToken();

        String formId = createNewForm(token);

        if(formId == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(formId);
    }
}
