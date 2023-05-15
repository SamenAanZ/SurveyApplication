package SurveyService.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class Question {
    // In the future, add more question types in the enum
    public enum questionType { TEXT }

    private String name;
    private String title;
    private questionType type;

    public Question(String name, String title, questionType type) {
        this.name = name;
        this.title = title;
        this.type = type;
    }
}
