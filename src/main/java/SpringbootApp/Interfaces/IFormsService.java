package SpringbootApp.Interfaces;

import SpringbootApp.Model.Survey;

import java.io.IOException;
import java.util.List;

public interface IFormsService {
    String createNewForm(String title, String description) throws IOException;
    List<Survey> getForms();
    Survey getForm(String id);
}
