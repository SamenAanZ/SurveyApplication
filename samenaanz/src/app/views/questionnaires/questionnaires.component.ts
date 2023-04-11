import {Component, OnDestroy, OnInit} from '@angular/core';
import {QuestionnaireService} from "../../services/questionnaire.service";
import {Questionnaire} from "../../services/questionnaire";
import {Mutation} from "../../services/mutation";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-questionnaires',
  templateUrl: './questionnaires.component.html',
  styleUrls: ['./questionnaires.component.scss']
})
export class QuestionnairesComponent implements OnInit, OnDestroy {

  private subscription: Subscription | undefined;

  private readonly questionnaireService: QuestionnaireService;
  public questionnaires: readonly Questionnaire[];

  public constructor(questionnaireService: QuestionnaireService) {
    this.questionnaireService = questionnaireService;
    this.questionnaires = [];
  }

  private async RetrieveQuestionnaires(): Promise<void> {
    this.questionnaires = await this.questionnaireService.RetrieveAll();
  }

  public async ngOnInit(): Promise<void> {
    await this.RetrieveQuestionnaires();

    this.subscription = this.questionnaireService.Mutations.subscribe(async m => {
      if(m === Mutation.Questionnaires) {
        await this.RetrieveQuestionnaires();
      }
    })
  }

  public ngOnDestroy(): void {
    this.subscription?.unsubscribe();
  }
}
