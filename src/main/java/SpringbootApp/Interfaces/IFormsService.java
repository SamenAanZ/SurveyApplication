package SpringbootApp.Interfaces;

import SpringbootApp.Model.Survey;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IFormsService {
    String createNewForm() throws IOException;
    List<Survey> getForms();
    Survey getForm(String id);
}
