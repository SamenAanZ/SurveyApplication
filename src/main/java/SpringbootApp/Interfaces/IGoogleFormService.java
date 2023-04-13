package SpringbootApp.Interfaces;

import com.google.api.services.forms.v1.model.Form;

import java.io.IOException;

public interface IGoogleFormService {
    Form createGoogleForm() throws IOException;
}
