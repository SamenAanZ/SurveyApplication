package SurveyService.Controllers;

import SurveyService.Interfaces.IFormsService;
import SurveyService.Model.DTO.QuestionDTO;
import SurveyService.Model.DTO.SurveyDTO;
import SurveyService.Model.Question;
import SurveyService.Model.Survey;
import SurveyService.Model.SurveyState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/survey")
public class SurveyController {

    private IFormsService formsService;

    @Autowired
    public SurveyController(IFormsService formsService) {
        this.formsService = formsService;
    }

    private SurveyDTO toSurveyDTO(Survey survey) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (Question question : survey.getQuestions()) {
            questionDTOs.add(new QuestionDTO(question));
        }
        return new SurveyDTO(survey.getId(), survey.getName(), survey.getTitle(), survey.getDescription(), survey.getOwnerId(), survey.getState(), survey.getUserIds(), questionDTOs);
    }

    private Survey toSurvey(SurveyDTO surveyDTO) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDTO questionDTO : surveyDTO.getQuestions()) {
            questions.add(new Question(questionDTO));
        }
        if (surveyDTO.getId() == null) {
            return new Survey(surveyDTO.getName(), surveyDTO.getTitle(), surveyDTO.getDescription(), surveyDTO.getOwnerId(), surveyDTO.getState(), surveyDTO.getUserIds(), questions);
        } else {
            return new Survey(surveyDTO.getId(), surveyDTO.getName(), surveyDTO.getTitle(), surveyDTO.getDescription(), surveyDTO.getOwnerId(), surveyDTO.getState(), surveyDTO.getUserIds(), questions);
        }

    }

    @GetMapping
    public ResponseEntity getSurveys() throws IOException {
        List<Survey> surveys = formsService.getForms();

        if(surveys == null) return ResponseEntity.badRequest().build();
        if(surveys.isEmpty()) return ResponseEntity.noContent().build();

        List<SurveyDTO> returnData = new ArrayList<>();
        for (Survey survey : surveys) {
            returnData.add(toSurveyDTO(survey));
        }

        if (returnData.size() != surveys.size()) {
            System.out.println("Something went wrong trying to map surveys. Retrieved size: " + surveys.size() + ", DTO size: " + returnData.size());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(returnData);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSurvey(@PathVariable(value = "id") String id) {
        if(id == null) return ResponseEntity.badRequest().build();

        Survey survey = formsService.getForm(id);

        if(survey == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(toSurveyDTO(survey));
    }

    @GetMapping(params = "ownerId")
    public ResponseEntity getSurveysByOwnerId(@RequestParam("ownerId") String ownerId) {
        List<Survey> surveys = formsService.getSurveysByOwnerId(ownerId);

        if (surveys.size() <= 0) return ResponseEntity.noContent().build();

        List<SurveyDTO> surveyDTOS = new ArrayList<>();
        for (Survey survey : surveys) {
            surveyDTOS.add(toSurveyDTO(survey));
        }

        return ResponseEntity.ok(surveyDTOS);
    };

    @GetMapping(params = "userId")
    public ResponseEntity getSurveysByUserId(@RequestParam("userId") String userId) {
        List<Survey> surveys = formsService.getSurveysByUserId(userId);

        if (surveys.size() <= 0) return ResponseEntity.noContent().build();

        List<SurveyDTO> surveyDTOS = new ArrayList<>();
        for (Survey survey : surveys) {
            surveyDTOS.add(toSurveyDTO(survey));
        }

        return ResponseEntity.ok(surveyDTOS);
    };

    @PostMapping
    public ResponseEntity createSurvey(@RequestBody (required = false) SurveyDTO data) throws GeneralSecurityException, IOException {
        if(data == null) return ResponseEntity.badRequest().build();

        String formId = formsService.createNewForm(toSurvey(data));

        if(formId == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(formId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateSurveyState (@PathVariable(value = "id") String id, @RequestBody (required = true) String newState) {
        if(id == null) return ResponseEntity.badRequest().build();

        SurveyState formattedState;
        try {
            formattedState = SurveyState.valueOf(newState.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid enum provided. Expected OPEN or CLOSED, got " + newState.toUpperCase());
        }
        Survey survey = formsService.changeSurveyState(id, formattedState);

        if(survey == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(toSurveyDTO(survey));
    }
}
