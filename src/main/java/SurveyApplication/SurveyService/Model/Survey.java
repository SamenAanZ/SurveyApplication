package SurveyApplication.SurveyService.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String title;

    @ElementCollection
    private List<Question> questions;

    public Survey(String name, String title, List<Question> questions) {
        this.name = name;
        this.title = title;
        this.questions = questions;
    }
}
