package ResponseService.Model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter @Setter @NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    private String surveyId;

    @ElementCollection
    @MapKeyColumn
    private Map<String, String> answerList = new HashMap<String, String>();

    public Response(String surveyId, Map<String, String> answers) {
        this.surveyId = surveyId;
        this.answerList = answers;
    }
}
