import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { QuestionnairesComponent } from './views/questionnaires/questionnaires.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateQuestionnaireComponent } from './views/create-questionnaire/create-questionnaire.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    QuestionnairesComponent,
    NavbarComponent,
    CreateQuestionnaireComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
