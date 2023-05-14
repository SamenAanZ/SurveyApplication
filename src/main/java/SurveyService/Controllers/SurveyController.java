package SurveyService.Controllers;

import SurveyService.Interfaces.IFormsService;
import SurveyService.Model.DTO.SurveyDTO;
import SurveyService.Model.Survey;
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

    @GetMapping
    public ResponseEntity getSurveys() throws IOException {
        List<Survey> surveys = formsService.getForms();

        if(surveys == null) return ResponseEntity.badRequest().build();
        if(surveys.isEmpty()) return ResponseEntity.noContent().build();

        List<SurveyDTO> returnData = new ArrayList<>();
        for (Survey survey : surveys) {
            SurveyDTO surveyDTO = new SurveyDTO(survey.getName(), survey.getTitle(), survey.getQuestions());
            returnData.add(surveyDTO);
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

        SurveyDTO returnData = new SurveyDTO(survey.getName(), survey.getTitle(), survey.getQuestions());

        return ResponseEntity.ok(returnData);
    }

    @PostMapping
    public ResponseEntity createSurvey(@RequestBody (required = false) SurveyDTO data) throws GeneralSecurityException, IOException {
        if(data == null) return ResponseEntity.badRequest().build();

        String formId = formsService.createNewForm(data.getName(), data.getTitle(), data.getElements());

        if(formId == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(formId);
    }
}
