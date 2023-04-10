import {Component, OnInit} from '@angular/core';
import {QuestionnaireService} from "../../services/questionnaire.service";
import {Questionnaire} from "../../services/questionnaire";

@Component({
  selector: 'app-questionnaires',
  templateUrl: './questionnaires.component.html',
  styleUrls: ['./questionnaires.component.scss']
})
export class QuestionnairesComponent implements OnInit {

  private readonly questionnaireService: QuestionnaireService;
  public questionnaires: readonly Questionnaire[];

  public constructor(questionnaireService: QuestionnaireService) {
    this.questionnaireService = questionnaireService;
    this.questionnaires = [];
  }

  public async ngOnInit(): Promise<void> {
    this.questionnaires = await this.questionnaireService.RetrieveAll();
  }
}
