package SurveyApplication.SurveyService.Controllers;

import SurveyApplication.SurveyService.Interfaces.IFormsService;
import SurveyApplication.SurveyService.Model.DTO.QuestionDTO;
import SurveyApplication.SurveyService.Model.DTO.SurveyDTO;
import SurveyApplication.SurveyService.Model.Question;
import SurveyApplication.SurveyService.Model.QuestionType;
import SurveyApplication.SurveyService.Model.RadioQuestion;
import SurveyApplication.SurveyService.Model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : survey.getQuestions()) {
            switch (question.getType()) {
                case RADIOGROUP:
                    questionDTOS.add(new QuestionDTO(question, ((RadioQuestion) question).getChoices()));
            }
        }
        return new SurveyDTO(survey.getName(), survey.getTitle(), questionDTOS);
    }

//    private Survey toSurvey(SurveyDTO surveyDTO) {
//        List<Question> questions = new ArrayList<>();
//        for (QuestionDTO questionDTO : surveyDTO.getElements()) {
//            switch (questionDTO.getType()) {
//                case RADIOGROUP:
//                    questions.add(new RadioQuestion(questionDTO, questionDTO.getChoices()));
//            }
//        }
//        return new Survey(surveyDTO.getName(), surveyDTO.getTitle(), questions);
//    }

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

    @PostMapping
    public ResponseEntity createSurvey(@RequestBody (required = false) SurveyDTO data) throws GeneralSecurityException, IOException {
        if(data == null) return ResponseEntity.badRequest().build();

        List<Question> questions = new ArrayList<>();
        for (QuestionDTO questionDTO : data.getElements()) {
            Question question = new Question(questionDTO.getName(), questionDTO.getTitle(), questionDTO.isRequired(), questionDTO.getType());

            switch (questionDTO.getType()) {
                case RADIOGROUP:
                    questions.add(new RadioQuestion(question, questionDTO.getChoices()));
            }
        }

        String formId = formsService.createNewForm(data.getName(), data.getTitle(), questions);

        if(formId == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(formId);
    }
}
