package SurveyService.Services;

import SurveyService.Interfaces.IFormsService;
import SurveyService.Interfaces.IGoogleFormService;
import SurveyService.Interfaces.ISurveyRepository;
import SurveyService.Model.Survey;
import com.google.api.services.forms.v1.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
        Survey survey = new Survey();

        if(!title.isEmpty() || !description.isEmpty()) {
            if(googleFormService.updateGoogleForm(form.getFormId(), title, description)) {
                survey = new Survey(form.getFormId(), form.getResponderUri(), title, description);
            }
        } else {
            survey = new Survey(form.getFormId(), form.getResponderUri(), form.getInfo().getTitle(), "");
        }

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
