import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponent } from './views/test/test.component';
import { SurveyModule } from 'survey-angular-ui';
import { TesttwoComponent } from './views/testtwo/testtwo.component';
import { TestthreeComponent } from './views/testthree/testthree.component';
import { TestfourComponent } from './views/testfour/testfour.component';
import { TestfiveComponent } from './views/testfive/testfive.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    TesttwoComponent,
    TestthreeComponent,
    TestfourComponent,
    TestfiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SurveyModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
