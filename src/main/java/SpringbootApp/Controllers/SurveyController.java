package SpringbootApp.Controllers;

import SpringbootApp.Interfaces.IFormsService;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.forms.v1.Forms;
import com.google.api.services.forms.v1.FormsScopes;
import com.google.api.services.forms.v1.model.Form;
import com.google.api.services.forms.v1.model.Info;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.annotation.Autowired;
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


    private IFormsService formsService;

    @Autowired
    public SurveyController(IFormsService formsService) {
        this.formsService = formsService;
    }

    @PostMapping
    public ResponseEntity createSurvey() throws GeneralSecurityException, IOException {
        String formId = formsService.createNewForm();

        if(formId == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(formId);
    }
}
