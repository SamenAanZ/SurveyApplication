package SurveyApplication.SurveyService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String name;
    private String title;
    private String description;
    private String ownerId;

    private SurveyState state;

    @ElementCollection
    private List<String> userIds;

    @Column(columnDefinition = "json")
    @Type(type = "json")
    @ElementCollection
    private List<Question> questions;

    public Survey(String name, String title, String description, String ownerId, SurveyState state, List<String> userIds, List<Question> questions) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.state = state;
        this.userIds = userIds;
        this.questions = questions;
    }
}
