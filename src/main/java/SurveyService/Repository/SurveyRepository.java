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

    public boolean createSurvey(Survey survey) {
        try {
            database.save(survey);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public List<Survey> getSurveys() {
        return (List<Survey>) database.findAll();
    }

    public Survey getSurvey(String id) {
        Optional<Survey> dbResponse = database.findById(id);
        return dbResponse.isEmpty() ? null : dbResponse.get();
    }
}
