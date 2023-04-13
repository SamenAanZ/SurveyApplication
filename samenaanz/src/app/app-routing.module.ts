import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {QuestionnairesComponent} from "./views/questionnaires/questionnaires.component";
import {CreateQuestionnaireComponent} from "./views/create-questionnaire/create-questionnaire.component";

const routes: Routes = [
  { path: 'questionnaires', component: QuestionnairesComponent },
  { path: 'create-questionnaire', component: CreateQuestionnaireComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
