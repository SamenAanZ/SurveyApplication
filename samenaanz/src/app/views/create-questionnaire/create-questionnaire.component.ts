import { Component } from '@angular/core';
import { SurveyCreatorModel } from 'survey-creator-core';
import { surveyCreatorSettings } from 'src/environments/environment';
import { Survey } from 'src/app/models/survey';
import { KeycloakProviderService } from 'src/app/services/auth/keycloak-provider.service';
import { ClaimType } from 'src/app/models/claim-types';
import { SurveyPersistanceService } from 'src/app/services/survey-persistance.service';

@Component({
  selector: 'app-create-questionnaire',
  templateUrl: './create-questionnaire.component.html',
  styleUrls: ['./create-questionnaire.component.scss']
})
export class CreateQuestionnaireComponent {
  public ownedSurveys: Survey[] = [];
  public selectedSurvey: string | null = null;
  public surveyCreatorModel: SurveyCreatorModel;

  constructor(
    private readonly keycloak: KeycloakProviderService,
    private readonly surveyService: SurveyPersistanceService){
    // Get a list of created surveys to populate the dropdown
    this.getCreatedSurveys();
    
    // Configure surveyJS creator
    this.surveyCreatorModel = this.configureCreator();
  }

  private configureCreator(): SurveyCreatorModel{
    // Creates the default survey to show
    const creator = new SurveyCreatorModel(surveyCreatorSettings);

    // Show a save button if auto-save has been disabled
    if (!surveyCreatorSettings.isAutoSave)
      creator.showSaveButton = true;

    // Dont allow additional page with questions
    creator.pageEditMode = "single";
    creator.allowModifyPages = false;
    creator.showPagesInPreviewTab = false;
    creator.showPageSelectorInToolbar = false;

    creator.saveSurveyFunc = (surveyNo: number, callback: Function) => {

      const surveyJson = this.surveyCreatorModel.getSurveyJSON();
      const questions = surveyJson["pages"][0].elements;

      const survey = {
        name: surveyJson['title'],
        title: surveyJson['title'],
        description: surveyJson['description'],
        ownerId: this.keycloak.getTokenClaim(ClaimType.id),
        state: "OPEN",
        questions: questions
      }

      this.surveyCreatorModel = creator;
      callback(true);

      this.surveyService.createSurvey(survey);
    }

    return creator;
  }

  private getCreatedSurveys(): void {
    const userId = this.keycloak.getTokenClaim(ClaimType.id);
    this.surveyService.getSurveysByOwnerId(userId).subscribe(response => {
      this.ownedSurveys = response;
    })
  }

  public loadSurvey(): void {
    // Check if a survey is selected
    if (this.selectedSurvey) {

      // Retrieve the survey JSON based on the selected survey ID
      const selectedSurvey = this.ownedSurveys.find(survey => survey.id === this.selectedSurvey);
      
      if (selectedSurvey) {
        console.log(selectedSurvey);
        this.surveyCreatorModel.JSON = selectedSurvey;
      }
    }
  }
}
