package ResponseService.Controllers;

import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.DTO.ResponseListDTO;
import ResponseService.Model.DTO.SurveyResponseDTO;
import ResponseService.Model.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/response")
public class ResponseController {

    private IResponseService responseService;

    @Autowired
    public ResponseController(IResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseListDTO> getSurveyResponses(@PathVariable(value = "id") String id) {
        if(id == null) return ResponseEntity.badRequest().build();

        ResponseList responses = responseService.getResponses(id);

        if(responses == null) return ResponseEntity.badRequest().build();

        ResponseListDTO returnData = new ResponseListDTO(responses.getTotalResponses(), responses.getAnswers());
        return ResponseEntity.ok(returnData);
    }

    @PostMapping
    public ResponseEntity createResponse(@RequestBody (required = true) SurveyResponseDTO data) throws IOException {
        if(data == null) return ResponseEntity.badRequest().build();

        responseService.verifyResponse(data.getSurveyId(), data.getAnswers());

        return ResponseEntity.ok().build();
    }
}
