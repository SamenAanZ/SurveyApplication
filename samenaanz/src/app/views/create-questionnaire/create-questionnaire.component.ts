import { Component } from '@angular/core';
import { SurveyCreatorModel } from 'survey-creator-core';
import { surveyCreatorSettings } from 'src/environments/environment';
import { defaultSurveyCreatorTemplate } from 'src/environments/environment';
import { SurveyLocalStorageService } from 'src/app/services/survey-local-storage.service';

@Component({
  selector: 'app-create-questionnaire',
  templateUrl: './create-questionnaire.component.html',
  styleUrls: ['./create-questionnaire.component.scss']
})
export class CreateQuestionnaireComponent {
  public selectedSurvey: string | null = null;
  public surveyCreatorModel: SurveyCreatorModel;

  constructor(private readonly localSurveyService: SurveyLocalStorageService){
    // Configure surveyJS creator
    this.surveyCreatorModel = this.configureCreator();
  }

  public loadSurvey(): void {
    alert(this.selectedSurvey);
  }

  private configureCreator(): SurveyCreatorModel{
    // Creates the default survey to show
    const creator = new SurveyCreatorModel(surveyCreatorSettings);

    // Show a save button if auto-save has been disabled
    if (!surveyCreatorSettings.isAutoSave)
      creator.showSaveButton = true;

    // Assign the saved surveyJson. If it does not exist, then use the default JSON template.
    creator.text = this.localSurveyService.getItem(this.localSurveyService.localSurveyId) || JSON.stringify(defaultSurveyCreatorTemplate);

    // When the survey is saved in the editor, it is stored in localstorage
    creator.saveSurveyFunc = (surveyNumber: number, callback: Function) => {

      this.localSurveyService.setItem(this.localSurveyService.localSurveyId, creator.text);
      callback(surveyNumber, true);
      this.surveyCreatorModel = creator;
    }

    return creator;
  }
}
