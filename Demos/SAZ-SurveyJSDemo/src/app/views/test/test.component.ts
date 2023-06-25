import { Component } from '@angular/core';
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
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})

export class TestComponent{
  title = 'My First Survey';
  surveyModel: SurveyModel;

  constructor(){
    this.surveyModel = new SurveyModel(surveyJson);
    this.surveyModel.onComplete.add(this.surveyComplete);
  }

  surveyComplete(sender: SurveyModel){
    const results = JSON.stringify(sender.data);
    alert(results);
  }
}

