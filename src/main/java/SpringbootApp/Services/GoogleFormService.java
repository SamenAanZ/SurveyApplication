package SpringbootApp.Services;

import SpringbootApp.Interfaces.IGoogleFormService;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.forms.v1.Forms;
import com.google.api.services.forms.v1.FormsScopes;
import com.google.api.services.forms.v1.model.*;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Objects;

@Service
public class GoogleFormService implements IGoogleFormService {
    private static final String APPLICATION_NAME = "Forms test app";
    private static Forms formsService;

    @Autowired
    public GoogleFormService() {
        try {
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            formsService = new Forms.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                    jsonFactory, null)
                    .setApplicationName(APPLICATION_NAME).build();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    private String getAccessToken() throws IOException {
        InputStream resource;
        try {
            resource = getClass().getClassLoader().getResourceAsStream("google-app-credentials.json");
        } catch (NullPointerException ex) {
            System.out.println("Google app credentials resource not found! " + ex);
            return null;
        }

        GoogleCredentials credential = GoogleCredentials.fromStream(Objects.requireNonNull(resource)).createScoped(FormsScopes.all());
        String accessToken = credential.getAccessToken() != null ?
                credential.getAccessToken().getTokenValue() :
                credential.refreshAccessToken().getTokenValue();
        return accessToken;
    }

    public Form createGoogleForm() throws IOException{
        String token = getAccessToken();
        if(token == null) return null;

        Form form = new Form();
        form.setInfo(new Info());
        form.getInfo().setTitle("This is the default form title");

        form = formsService.forms().create(form)
                .setAccessToken(token)
                .execute();

        return form;
    }

    public boolean updateGoogleForm(String formId, String title, String description) throws IOException {
        String token = getAccessToken();
        if(token == null) return false;

        BatchUpdateFormRequest batchRequest = new BatchUpdateFormRequest();
        Request request = new Request();
        request.setUpdateFormInfo(new UpdateFormInfoRequest());

        request.getUpdateFormInfo().setInfo(new Info()
                .setTitle(title)
                .setDescription(description)
        );
        request.getUpdateFormInfo().setUpdateMask("*");

        batchRequest.setRequests(Collections.singletonList(request));

        try {
            formsService.forms().batchUpdate(formId, batchRequest)
                    .setAccessToken(token)
                    .execute();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }
}
