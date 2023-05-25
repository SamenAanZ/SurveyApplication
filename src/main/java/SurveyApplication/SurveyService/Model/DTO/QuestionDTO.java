package SurveyApplication.SurveyService.Model.DTO;

import SurveyApplication.SurveyService.Model.Choice;
import SurveyApplication.SurveyService.Model.Question;
import SurveyApplication.SurveyService.Model.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class QuestionDTO {
    private String name;
    private String title;
    private QuestionType type;
    private boolean isRequired;

    // ------ Question type props ------
    public List<Choice> choices;

    public QuestionDTO(String name, String title, boolean isRequired, List<Choice> choices) {
        this.name = name;
        this.title = title;
        this.type = QuestionType.RADIOGROUP;
        this.isRequired = isRequired;
        this.choices = choices;
    }

    public QuestionDTO(Question question, List<Choice>choices) {
        this.name = question.getName();
        this.title = question.getTitle();
        this.type = question.getType();
        this.isRequired = question.isRequired();
        this.choices = choices;
    }
}
