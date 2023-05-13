package SurveyService.Services;

import SurveyService.Interfaces.IFormsService;
import SurveyService.Interfaces.ISurveyRepository;
import SurveyService.Model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FormsService implements IFormsService {
    private ISurveyRepository surveyRepository;

    @Autowired
    public FormsService(ISurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Long createNewForm(String title, String description) {
        Survey createdSurvey = surveyRepository.createSurvey(new Survey(title, description));
        System.out.println(createdSurvey.getId());
        return createdSurvey.getId();
    }

    public List<Survey> getForms() {
        return surveyRepository.getSurveys();
    }

    public Survey getForm(Long id) {
        return surveyRepository.getSurvey(id);
    }

}
