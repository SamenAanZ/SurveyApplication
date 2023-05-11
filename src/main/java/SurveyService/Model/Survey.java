package SurveyService.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Survey {
    @Id
    private String formId;
    private String answerUrl;
    private String title;
    private String description;

    public Survey(String id, String url, String title, String description) {
        this.formId = id;
        this.answerUrl = url;
        this.title = title;
        this.description = description;
    }

    public Survey() {}

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
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
