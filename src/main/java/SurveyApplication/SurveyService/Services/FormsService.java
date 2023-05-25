package SurveyApplication.SurveyService.Services;

import SurveyApplication.SurveyService.Interfaces.IFormsService;
import SurveyApplication.SurveyService.Interfaces.ISurveyRepository;
import SurveyApplication.SurveyService.Model.Question;
import SurveyApplication.SurveyService.Model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormsService implements IFormsService {
    private ISurveyRepository surveyRepository;

    @Autowired
    public FormsService(ISurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public String createNewForm(String title, String description, List<Question> questions) {
        Survey createdSurvey = surveyRepository.createSurvey(new Survey(title, description, questions));
        if (createdSurvey == null) return null;
        return createdSurvey.getId();
    }

    public List<Survey> getForms() {
        return surveyRepository.getSurveys();
    }

    public Survey getForm(String id) {
        return surveyRepository.getSurvey(id);
    }

}
