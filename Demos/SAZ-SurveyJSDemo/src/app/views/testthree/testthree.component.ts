import { Component } from '@angular/core';
import { SurveyModel } from 'survey-core';

const surveyJson = {
  pages: [{
    name: "PersonalDetails",
    elements: [{
      type: "text",
      name: "FirstName",
      title: "Enter your first name:"
    }, {
      type: "text",
      name: "LastName",
      title: "Enter your last name:"
    }, {
      type: "panel",
      name: "Contacts",
      title: "Contacts (optional)",
      elements: [{
        type: "text",
        name: "GitHub"
      }]
    }]
  }]
};

@Component({
  selector: 'app-testthree',
  templateUrl: './testthree.component.html',
  styleUrls: ['./testthree.component.css']
})
export class TestthreeComponent {
  title = 'My First Survey';
  surveyModel: SurveyModel;

  constructor(){
    this.surveyModel = new SurveyModel(surveyJson);
  }

  addQuestion() {
    const page = this.surveyModel.getPageByName("PersonalDetails");
    const question = page.addNewQuestion("text", "NewQuestion");
    question.title = "NewQuestionTitle";
  }
}
