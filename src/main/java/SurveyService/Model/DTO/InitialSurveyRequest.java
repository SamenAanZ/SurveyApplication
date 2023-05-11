package SurveyService.Model.DTO;

public class InitialSurveyRequest {
    private String title;
    private String description;

    public InitialSurveyRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
