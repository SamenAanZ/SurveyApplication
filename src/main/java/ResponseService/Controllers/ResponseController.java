package ResponseService.Controllers;

import ResponseService.Interfaces.IResponseService;
import ResponseService.Model.DTO.ResponseListDTO;
import ResponseService.Model.DTO.SurveyResponseDTO;
import ResponseService.Model.ResponseList;
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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseListDTO> getSurveyResponses(@PathVariable(value = "id") String id) {
        if(id == null) return ResponseEntity.badRequest().build();

        ResponseList responses = responseService.getResponses(id);

        if(responses == null) return ResponseEntity.badRequest().build();

        ResponseListDTO returnData = new ResponseListDTO(responses.getTotalResponses(), responses.getResponses());
        return ResponseEntity.ok(returnData);
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
