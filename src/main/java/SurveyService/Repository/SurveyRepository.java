package SurveyService.Repository;

import SurveyService.Interfaces.ISurveyRepository;
import SurveyService.Model.Survey;
import SurveyService.Repository.Interfaces.ISurveyDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SurveyRepository implements ISurveyRepository {

    ISurveyDatabase database;

    @Autowired
    public SurveyRepository(ISurveyDatabase db) {
        this.database = db;
    }

    public Survey createSurvey(Survey survey) {
        try {
            Survey savedSurvey = database.save(survey);
            return savedSurvey;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Survey> getSurveys() {
        return (List<Survey>) database.findAll();
    }

    public Survey getSurvey(String id) {
        Optional<Survey> dbResponse = database.findById(id);
        return dbResponse.isEmpty() ? null : dbResponse.get();
    }
}
