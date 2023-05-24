import { Component, OnInit } from '@angular/core';
import { QuestionnaireService } from 'src/app/services/questionnaire.service';
import { Questionnaire } from 'src/app/services/questionnaire';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-questionnaire-detail',
  templateUrl: './questionnaire-detail.component.html',
  styleUrls: ['./questionnaire-detail.component.css']
})
export class QuestionnaireDetailComponent implements OnInit{
  public questionnaire: Questionnaire | null = null;

  constructor(
    private readonly router: ActivatedRoute,
    private readonly questionnaireService: QuestionnaireService) {}

  async ngOnInit(): Promise<void> {
    // Make call to get specific questionnaire.

    this.router.paramMap.subscribe(params => {
      const questionnaireId = params.get('id');

      if (questionnaireId)
        this.questionnaire = new Questionnaire(questionnaireId, "Title", "Url", "Description");
    });
  }
}
