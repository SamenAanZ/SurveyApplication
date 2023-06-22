package SurveyService.Model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import java.io.Serializable;

@TypeDef(name = "json", typeClass = JsonType.class)
@Getter @Setter @NoArgsConstructor
public class Choice implements Serializable  {
    public int value;
    public String text;

    public Choice(int value, String text) {
        this.value = value;
        this.text = text;
    }
}
