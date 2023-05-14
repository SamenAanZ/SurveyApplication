package SurveyService.Model.DTO;

import SurveyService.Model.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
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
