package SurveyService.Model.DTO;

import SurveyService.Model.Choice;
import SurveyService.Model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter @NoArgsConstructor
public class QuestionDTO {
    private String name;
    private String title;

    private String type;
    private boolean isRequired;

    public List<Choice> choices;

    public QuestionDTO(String name, String title, boolean isRequired, String type, List<Choice> choices) {
        this.name = name;
        this.title = title;
        this.isRequired = isRequired;
        this.type = type;
        this.choices = choices;
    }

    public QuestionDTO(Question question) {
        this.name = question.getName();
        this.title = question.getTitle();
        this.isRequired = question.isRequired();
        this.type = question.getType().toString();
        this.choices = question.getChoices();
    }
}
