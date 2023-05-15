package ResponseService.Model.DTO;

import ResponseService.Model.Response;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseListDTO {
    private int totalResponses;
    private Response[] responses;

    public ResponseListDTO(int totalResponses, Response[] responses) {
        this.totalResponses = totalResponses;
        this.responses = responses;
    }
}
