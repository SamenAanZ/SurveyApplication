package SurveyApplication.SurveyService.Model;

import SurveyApplication.SurveyService.Model.DTO.QuestionDTO;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Getter @Setter @NoArgsConstructor
public class RadioQuestion extends Question {
    @Column(columnDefinition = "json")
    @Type(type = "json")
    public List<Choice> choices;

    public RadioQuestion(Question question, List<Choice> choices) {
        super(question);
        this.choices = choices;
        this.setType(QuestionType.RADIOGROUP);
    }

    public RadioQuestion(QuestionDTO question, List<Choice> choices) {
        super(question);
        this.choices = choices;
        this.setType(QuestionType.RADIOGROUP);
    }
}
