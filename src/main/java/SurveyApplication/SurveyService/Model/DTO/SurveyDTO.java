package SurveyApplication.SurveyService.Model.DTO;

import SurveyApplication.SurveyService.Model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class SurveyDTO {

    private String name;
    private String title;
    private List<Question> elements;

    public SurveyDTO(String name, String title, List<Question> elements) {
        this.name = name;
        this.title = title;
        this.elements = elements;
    }
}