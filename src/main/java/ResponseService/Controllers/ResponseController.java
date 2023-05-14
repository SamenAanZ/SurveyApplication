package ResponseService.Controllers;

import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.DTO.SurveyResponseDTO;
import ResponseService.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/response")
public class ResponseController {

    private IResponseService responseService;

    @Autowired
    public ResponseController(IResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity createResponse(@RequestBody (required = true) SurveyResponseDTO data) {
        if(data == null) return ResponseEntity.badRequest().build();

        boolean responseCreated = responseService.createResponse(data.getSurveyId(), data.getAnswers());

        if(responseCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
