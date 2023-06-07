package SurveyApplication.SurveyService.Services;

import SurveyApplication.SurveyService.Interfaces.IFormsService;
import SurveyApplication.SurveyService.Interfaces.ISurveyRepository;
import SurveyApplication.SurveyService.Model.Question;
import SurveyApplication.SurveyService.Model.Survey;
import SurveyApplication.SurveyService.Model.SurveyState;
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

    public String createNewForm(Survey survey) {
        Survey createdSurvey = surveyRepository.createSurvey(survey);
        if (createdSurvey == null) return null;
        return createdSurvey.getId();
    }

    public Survey changeSurveyState(String id, SurveyState newState) {
        Survey survey = surveyRepository.getSurvey(id);
        if (survey == null) return null;

        survey.setState(newState);

        return surveyRepository.updateSurvey(survey);
    }

    public List<Survey> getForms() {
        return surveyRepository.getSurveys();
    }

    public Survey getForm(String id) {
        return surveyRepository.getSurvey(id);
    }

    public List<Survey> getSurveysByOwnerId(String ownerId) {
        return surveyRepository.getSurveysByOwnerId(ownerId);
    }

    public List<Survey> getSurveysByUserId(String userId) {
        return surveyRepository.getSurveysByUserId(userId);
    }

}
