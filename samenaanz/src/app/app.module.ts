// Angular Core
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { APP_INITIALIZER } from '@angular/core';

// SurveyJS
import { SurveyModule } from 'survey-angular-ui';
import { SurveyCreatorModule } from 'survey-creator-angular';

// Custom components
import { AppComponent } from './app.component';
import { QuestionnairesComponent } from './views/questionnaires/questionnaires.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateQuestionnaireComponent } from './views/create-questionnaire/create-questionnaire.component';

// Keycloak
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { initializeKeycloak } from './auth/app.init';
import { HomeComponent } from './views/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { ProfileComponent } from './views/profile/profile.component';
import { QuestionnaireDetailComponent } from './views/questionnaire-detail/questionnaire-detail.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionnairesComponent,
    NavbarComponent,
    CreateQuestionnaireComponent,
    HomeComponent,
    HeaderComponent,
    ProfileComponent,
    QuestionnaireDetailComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    KeycloakAngularModule,
    SurveyModule,
    SurveyCreatorModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
      }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
