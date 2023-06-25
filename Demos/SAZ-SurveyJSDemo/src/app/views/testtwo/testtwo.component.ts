import { Component } from '@angular/core';
import { SurveyModel } from 'survey-core';

@Component({
  selector: 'app-testtwo',
  templateUrl: './testtwo.component.html',
  styleUrls: ['./testtwo.component.css']
})
export class TesttwoComponent {
  title = 'My First Survey';
  surveyModel: SurveyModel;

  constructor(){
    this.surveyModel = this.createSurvey();
    this.surveyModel.onComplete.add(this.onCompleteForm);
  }

  createSurvey(): SurveyModel {
      // Create an empty model
    const survey = new SurveyModel();

    // Add a PersonalDetails page to the model
    const page = survey.addNewPage("PersonalDetails");

    // Add a FirstName question to the page
    const firstName = page.addNewQuestion("text", "FirstName");
    firstName.title = "Enter your first name:";

    // Add a LastName question to the page
    const lastName = page.addNewQuestion("text", "LastName");
    lastName.title = "Enter your last name:";

    // Add a Contacts panel to the page
    const panel = page.addNewPanel("Contacts");
    panel.title = "Contacts (optional)";
    panel.state = "collapsed";

    // Add a Telegram question to the panel
    const telegram = panel.addNewQuestion("text", "Telegram");
    telegram.title = "Telegram:"

    // Add a GitHub question to the panel
    const github = panel.addNewQuestion("text", "GitHub");
    github.title = "GitHub username:"

    return survey;
  }

  addQuestion() {
    const page = this.surveyModel.getPageByName("PersonalDetails");
    const question = page.addNewQuestion("text", "TestQuestion");
    question.title = "TestQuestionTitle";
  }

  onCompleteForm(sender: SurveyModel) {
    const resultJson = JSON.stringify(sender.data);
    alert(resultJson);
  }
}
