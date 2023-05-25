package SurveyApplication.SurveyService.Model.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class SurveyDTO {

    private String name;
    private String title;
    private List<QuestionDTO> elements;

    public SurveyDTO(String name, String title, List<QuestionDTO> elements) {
        this.name = name;
        this.title = title;
        this.elements = elements;
    }
}