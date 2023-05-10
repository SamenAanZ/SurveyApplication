// Angular Core
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { APP_INITIALIZER } from '@angular/core';

// Custom components
import { AppComponent } from './app.component';
import { QuestionnairesComponent } from './views/questionnaires/questionnaires.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateQuestionnaireComponent } from './views/create-questionnaire/create-questionnaire.component';

// Nebula
import { NbThemeModule, NbLayoutModule, NbSidebarModule, NbButtonModule } from '@nebular/theme';
import { NbMenuModule } from '@nebular/theme';
import { NbUserModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { NbTabsetModule, NbTabComponent } from '@nebular/theme';

// Keycloak
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { initializeKeycloak } from './auth/app.init';
import { HomeComponent } from './views/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { ProfileComponent } from './views/profile/profile.component';
import { QuestionnaireResultsComponent } from './views/questionnaire-results/questionnaire-results.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionnairesComponent,
    NavbarComponent,
    CreateQuestionnaireComponent,
    HomeComponent,
    HeaderComponent,
    ProfileComponent,
    QuestionnaireResultsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({ name: 'default' }),
    NbLayoutModule,
    NbEvaIconsModule,
    NbSidebarModule.forRoot(),
    NbButtonModule,
    NbMenuModule.forRoot(),
    NbUserModule,
    KeycloakAngularModule,
    NbTabsetModule
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
