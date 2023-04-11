import { Component } from '@angular/core';
import {QuestionnaireService} from "../../services/questionnaire.service";

@Component({
  selector: 'app-create-questionnaire',
  templateUrl: './create-questionnaire.component.html',
  styleUrls: ['./create-questionnaire.component.scss']
})
export class CreateQuestionnaireComponent {

  private readonly questionnaireService: QuestionnaireService;

  public inputTitle: string | undefined;
  public inputDescription: string | undefined;

  public constructor(questionnaireService: QuestionnaireService) {
    this.questionnaireService = questionnaireService;
  }

  public async Create(): Promise<void> {
    if(!this.inputTitle || this.inputTitle.trim().length === 0) {
      return;
    }

    if(!this.inputDescription || this.inputDescription.trim().length === 0) {
      return;
    }

    await this.questionnaireService.Create(this.inputTitle, this.inputDescription);

    this.inputTitle = this.inputDescription = undefined;
  }
}
