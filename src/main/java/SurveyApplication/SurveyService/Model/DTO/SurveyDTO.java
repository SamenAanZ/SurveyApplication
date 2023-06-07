package SurveyApplication.SurveyService.Model.DTO;

import SurveyApplication.SurveyService.Model.SurveyState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SurveyDTO {
    private String id;
    private String name;
    private String title;
    private String description;
    private String ownerId;
    private SurveyState state;
    private List<String> userIds;
    private List<QuestionDTO> questions;

    public SurveyDTO(String name, String title, String description, String ownerId, SurveyState state, List<String> userIds, List<QuestionDTO> questions) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.state = state;
        this.userIds = userIds;
        this.questions = questions;
    }
}