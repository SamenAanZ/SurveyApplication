package SurveyApplication.SurveyService.Model;

import SurveyApplication.SurveyService.Model.DTO.QuestionDTO;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@MappedSuperclass
@TypeDef(name = "json", typeClass = JsonType.class)
@Getter @Setter @NoArgsConstructor
public class Question {
    private String name;
    private String title;
    private QuestionType type;
    private boolean isRequired;

    public Question(String name, String title, boolean isRequired, QuestionType type) {
        this.name = name;
        this.title = title;
        this.isRequired = isRequired;
        this.type = type;
    }

    public Question(Question question) {
        this.name = question.name;
        this.title = question.title;
        this.type = question.type;
        this.isRequired = question.isRequired;
    }

    public Question(QuestionDTO question) {
        this.name = question.getName();
        this.title = question.getTitle();
        this.type = question.getType();
        this.isRequired = question.isRequired();
    }
}
