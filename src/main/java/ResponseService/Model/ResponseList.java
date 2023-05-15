package ResponseService.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseList {
    private int totalResponses;
    private Response[] responses;

    public ResponseList(int totalResponses, Response[] responses) {
        this.totalResponses = totalResponses;
        this.responses = responses;
    }
}
