package SurveyService.Model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter @Setter
public class ResponseMessage implements Serializable {
    private String surveyId;
    private Map<String, String> answers;

    public ResponseMessage(String surveyId, Map<String, String> answers) {
        this.surveyId = surveyId;
        this.answers = answers;
    }
}
