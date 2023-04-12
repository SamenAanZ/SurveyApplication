package SpringbootApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Survey {
    @Id
    private String formId;
    private String answerUrl;
    private String title;

    public Survey() {}

    public Survey(String id, String url, String title) {
        this.formId = id;
        this.answerUrl = url;
        this.title = title;
    }

    public String getFormId() {
        return this.formId;
    }
    public void setFormId(String id) {
        this.formId = id;
    }
    public String getAnswerUrl() {
        return this.answerUrl;
    }
    public void setAnswerUrl(String answerUrl) {
        this.answerUrl = answerUrl;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
