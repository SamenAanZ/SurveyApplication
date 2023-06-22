import { Component, OnInit } from '@angular/core';
import { Questionnaire } from 'src/app/services/questionnaire';
import { ActivatedRoute } from '@angular/router';
import { SurveyModel } from 'survey-core';
import { SurveyPersistanceService } from 'src/app/services/survey-persistance.service';

@Component({
  selector: 'app-questionnaire-detail',
  templateUrl: './questionnaire-detail.component.html',
  styleUrls: ['./questionnaire-detail.component.css']
})
export class QuestionnaireDetailComponent implements OnInit{
  public surveyTitle: string = "";
  public surveyDescription: string = "";
  surveyModel: SurveyModel;
  public questionnaire: Questionnaire | null = null;

  constructor(
    private readonly router: ActivatedRoute,
    private readonly surveyService: SurveyPersistanceService) {
      this.surveyModel = new SurveyModel();
    }

  async ngOnInit(): Promise<void> {
    this.router.paramMap.subscribe(async params => {
      const questionnaireId = params.get('id');

      if (questionnaireId)
      {
        this.surveyService.getSurveyBySurveyId(questionnaireId).subscribe(response => {
          console.log(response);

          this.surveyTitle = response.title;
          this.surveyDescription = response.description;
          this.surveyModel.setJsonObject(response);
          this.surveyModel.onComplete.add(this.onCompleteSurvey);
        })
      }
    });
  }

  private onCompleteSurvey(model: SurveyModel): void {
    console.log(model.data);
    alert(model.data);
  }
}
