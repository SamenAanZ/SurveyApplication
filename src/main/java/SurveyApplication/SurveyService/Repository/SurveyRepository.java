package SurveyApplication.SurveyService.Repository;

import SurveyApplication.SurveyService.Interfaces.ISurveyRepository;
import SurveyApplication.SurveyService.Model.Survey;
import SurveyApplication.SurveyService.Repository.Interfaces.ISurveyDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public Survey updateSurvey(Survey survey) {
        return database.save(survey);
    }

    public List<Survey> getSurveys() {
        return (List<Survey>) database.findAll();
    }

    public Survey getSurvey(String id) {
        try {
            Optional<Survey> dbResponse = database.findById(id);
            return dbResponse.isEmpty() ? null : dbResponse.get();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Survey> getSurveysByOwnerId(String ownerId) {
        return new ArrayList<>(database.findAllByOwnerId(ownerId));
    }

    public List<Survey> getSurveysByUserId(String userId) {
        return new ArrayList<>(database.findAllByUserIdsContaining(userId));
    }
}
