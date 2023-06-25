import { Component } from '@angular/core';
import { SurveyModel } from 'survey-core';

const surveyJson = {
    // Use these values to allow the user to review the survey answers
    showPreviewBeforeComplete: "showAnsweredQuestions",
    previewText: "Preview answers",
    // HTML that is shown when the user completes the survey
    completedHtml: "Thank you for your feedback!",
    // These values have to be set if you want to use a start page
    firstPageIsStarted: true,
    startSurveyText: "Take the Survey",
    showProgressBar: "bottom",
    pages: [
      // This is the start page and will not count in the numbering
      {
        elements: [{
            type: "html",
            html: "<h2>In this survey, we will ask you a couple questions about your impressions of our product.</h2>"
        }]
      },
      {
        elements: [{
            name: "satisfaction-score",
            title: "How would you describe your experience with our product?",
            type: "radiogroup",
            choices: [
                { value: 5, text: "Fully satisfying" },
                { value: 4, text: "Generally satisfying" },
                { value: 3, text: "Neutral" },
                { value: 2, text: "Rather unsatisfying" },
                { value: 1, text: "Not satisfying at all" }
            ],
            isRequired: true
        }]
    }, {
        elements: [{
            name: "what-would-make-you-more-satisfied",
            title: "What can we do to make your experience more satisfying?",
            type: "comment",
            visibleIf: "{satisfaction-score} = 4"
        }, {
            name: "nps-score",
            title: "On a scale of zero to ten, how likely are you to recommend our product to a friend or colleague?",
            type: "rating",
            rateMin: 0,
            rateMax: 10
        }],
        visibleIf: "{satisfaction-score} >= 4"
    }, {
        elements: [{
            name: "how-can-we-improve",
            title: "In your opinion, how could we improve our product?",
            type: "comment"
        }],
        visibleIf: "{satisfaction-score} = 3"
    }, {
        elements: [{
            name: "disappointing-experience",
            title: "Please let us know why you had such a disappointing experience with our product",
            type: "comment"
        }],
        visibleIf: "{satisfaction-score} =< 2"
    }],
    // showQuestionNumbers: "off"
};


@Component({
  selector: 'app-testfour',
  templateUrl: './testfour.component.html',
  styleUrls: ['./testfour.component.css']
})
export class TestfourComponent {
  title = 'My First Survey';
  surveyModel: SurveyModel;

  constructor(){
    this.surveyModel = new SurveyModel(surveyJson);
  }
}
