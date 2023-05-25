package SurveyApplication.SurveyService.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter @Setter @NoArgsConstructor
public class Choice implements Serializable  {
    public int value;
    public String text;

    public Choice(int value, String text) {
        this.value = value;
        this.text = text;
    }
}
