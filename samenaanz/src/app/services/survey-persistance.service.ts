import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Survey } from '../models/survey';

@Injectable({
  providedIn: 'root'
})
export class SurveyPersistanceService {

  constructor() { }

      public getSurveysByUserId(userId: string): void {}
      public getSurveyDetailsById(surveyId: string): void {}
      public postSurvey(survey: Survey): void {}
}