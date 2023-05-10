import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {QuestionnairesComponent} from "./views/questionnaires/questionnaires.component";
import {CreateQuestionnaireComponent} from "./views/create-questionnaire/create-questionnaire.component";
import { HomeComponent } from './views/home/home.component';
import { AuthGuard } from './auth/app.guard';
import { ProfileComponent } from './views/profile/profile.component';
import { QuestionnaireResultsComponent } from './views/questionnaire-results/questionnaire-results.component';
import { ApplicationRole } from './models/application-roles';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', pathMatch: 'full', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'questionnaires', component: QuestionnairesComponent, canActivate: [AuthGuard] },
  { path: 'create-questionnaire', component: CreateQuestionnaireComponent, canActivate: [AuthGuard], data: { roles: [ApplicationRole.Manager, ApplicationRole.Researcher]} },
  { path: 'questionnaire-results', component: QuestionnaireResultsComponent, canActivate: [AuthGuard], data: { roles: [ApplicationRole.Researcher]}},
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }