package ResponseService.Model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class SurveyResponseDTO {
    private String surveyId;
    private Map<String, String> answers;

    public SurveyResponseDTO(String surveyId, Map<String, String> answers) {
        this.surveyId = surveyId;
        this.answers = answers;
    }
}
