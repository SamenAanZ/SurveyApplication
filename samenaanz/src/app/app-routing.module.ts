import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import { QuestionnairesComponent } from "./views/questionnaires/questionnaires.component";
import {CreateQuestionnaireComponent} from "./views/create-questionnaire/create-questionnaire.component";
import { HomeComponent } from './views/home/home.component';
import { AuthGuard } from './auth/app.guard';
import { ProfileComponent } from './views/profile/profile.component';
import { ApplicationRole } from './models/application-roles';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { QuestionnaireDetailComponent } from './views/questionnaire-detail/questionnaire-detail.component';
import { UnauthorizedComponent } from './components/unauthorized/unauthorized.component';

const routes: Routes = [
  { path: 'not-found', component: NotFoundComponent, canActivate: [AuthGuard] },
  { path: 'unauthorized', component: UnauthorizedComponent, canActivate: [AuthGuard] },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', pathMatch: 'full', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'questionnaires', component: QuestionnairesComponent, canActivate: [AuthGuard], data: { roles: [ApplicationRole.Employee]}  },
  { path: 'questionnaires/:id', component: QuestionnaireDetailComponent, canActivate: [AuthGuard], data: { roles: [ApplicationRole.Employee]}  },
  { path: 'create-questionnaire', pathMatch: 'full', component: CreateQuestionnaireComponent, canActivate: [AuthGuard], data: { roles: [ApplicationRole.Manager, ApplicationRole.Researcher]} },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: 'not-found' }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }