package SurveyService.Controllers;

import SurveyService.Interfaces.IFormsService;
import SurveyService.Model.DTO.InitialSurveyRequest;
import SurveyService.Model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
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

        return ResponseEntity.ok(surveys);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSurvey(@PathVariable(value = "id") Long id) {
        if(id == null) return ResponseEntity.badRequest().build();

        Survey survey = formsService.getForm(id);

        if(survey == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(survey);
    }

    @PostMapping
    public ResponseEntity createSurvey(@RequestBody (required = false) InitialSurveyRequest data) throws GeneralSecurityException, IOException {
        if(data == null) return ResponseEntity.badRequest().build();

        Long formId = formsService.createNewForm(data.getTitle(), data.getDescription());

        if(formId == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(formId);
    }
}
