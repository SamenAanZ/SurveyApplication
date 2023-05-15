package ResponseService.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class ResponseList {
    private int totalResponses;
    private List<Map<String, String>> answers;

    public ResponseList(int totalResponses, List<Map<String, String>> answers) {
        this.totalResponses = totalResponses;
        this.answers = answers;
    }
}
