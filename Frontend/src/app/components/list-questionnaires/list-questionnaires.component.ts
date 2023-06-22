import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Survey } from 'src/app/models/survey';

@Component({
  selector: 'app-list-questionnaires',
  templateUrl: './list-questionnaires.component.html',
  styleUrls: ['./list-questionnaires.component.css']
})
export class ListQuestionnairesComponent {
  @Input() surveys: Survey[] = [];
  @Output() loadSelectedSurvey: EventEmitter<Survey> = new EventEmitter<Survey>();
  public searchTerm: string = '';

  get filterItems(): Survey[] {
    return this.surveys.filter(survey => {
      return survey.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      survey.description.toLowerCase().includes(this.searchTerm.toLowerCase());
    });
  }

  public onLoadSurvey(survey: Survey): void {
    this.loadSelectedSurvey.emit(survey);
  }
}
