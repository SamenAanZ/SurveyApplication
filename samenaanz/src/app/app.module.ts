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
import { NbEvaIconsModule } from '@nebular/eva-icons';

// Keycloak
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { initializeKeycloak } from './auth/app.init';

@NgModule({
  declarations: [
    AppComponent,
    QuestionnairesComponent,
    NavbarComponent,
    CreateQuestionnaireComponent
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
    KeycloakAngularModule
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
