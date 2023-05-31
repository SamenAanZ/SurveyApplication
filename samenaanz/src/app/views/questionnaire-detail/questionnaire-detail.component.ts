import { Component, OnInit } from '@angular/core';
import { QuestionnaireService } from 'src/app/services/questionnaire.service';
import { Questionnaire } from 'src/app/services/questionnaire';
import { ActivatedRoute } from '@angular/router';
import { SurveyModel } from 'survey-core';

const surveyJson = {
  elements: [{
    name: "FirstName",
    title: "Enter your first name:",
    type: "text"
  }, {
    name: "LastName",
    title: "Enter your last name:",
    type: "text"
  }]
};

@Component({
  selector: 'app-questionnaire-detail',
  templateUrl: './questionnaire-detail.component.html',
  styleUrls: ['./questionnaire-detail.component.css']
})
export class QuestionnaireDetailComponent implements OnInit{
  surveyModel: SurveyModel;
  public questionnaire: Questionnaire | null = null;

  constructor(
    private readonly router: ActivatedRoute,
    private readonly questionnaireService: QuestionnaireService) {
      const survey = new SurveyModel(surveyJson);
      this.surveyModel = survey;
    }

  async ngOnInit(): Promise<void> {
    // Todo:
    // - Make call to backend to get specific questionnaire
    // - To make the request the surveyId and userId (sub) are used
    // - When the survey is retrieved it will extract the properties and survey JSON
    // - The survey is refreshed and displayed
    
    // - Connect the survey send button to create a post request with survey results
    // - The results will be sent with the id of the survey

    this.router.paramMap.subscribe(async params => {
      const questionnaireId = params.get('id');

      if (questionnaireId)
      {
        const questionnaires = await this.questionnaireService.RetrieveAll();
        const foundQuestionnaire = questionnaires.find(q => q.id == questionnaireId);

        if (foundQuestionnaire)
          this.questionnaire = foundQuestionnaire;
      }
    });
  }
}
