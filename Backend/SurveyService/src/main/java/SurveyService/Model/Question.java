package SurveyService.Model;

import SurveyService.Model.DTO.QuestionDTO;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

@Embeddable
@TypeDef(name = "json", typeClass = JsonType.class)
@Getter @Setter @NoArgsConstructor
public class Question {
    private String name;
    private String title;

    @Enumerated(EnumType.STRING)
    private QuestionType type;
    private boolean isRequired;

    @Column(columnDefinition = "json")
    @Type(type = "json")
    public List<Choice> choices;

    public Question(String name, String title, boolean isRequired, QuestionType type, List<Choice> choices) {
        this.name = name;
        this.title = title;
        this.isRequired = isRequired;
        this.type = type;
        this.choices = choices;
    }

    public Question(Question question) {
        this.name = question.name;
        this.title = question.title;
        this.type = question.type;
        this.isRequired = question.isRequired;
        this.choices = question.choices;
    }

    public Question(QuestionDTO question) {
        this.name = question.getName();
        this.title = question.getTitle();
        this.type = QuestionType.valueOf(question.getType().toUpperCase());;
        this.isRequired = question.isRequired();
        this.choices = question.getChoices();
    }
}
