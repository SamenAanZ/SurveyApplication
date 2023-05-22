import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Survey } from '../models/survey';
import { surveyEndpoints } from 'src/environments/environment';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SurveyPersistanceService {

  constructor(private readonly httpClient: HttpClient) { }

  public getUserSurveys(userId: string): Observable<Survey[]> {
    const url = `${surveyEndpoints.URL}/${userId}`;
    return this.httpClient.get<Survey[]>(url);
  }
}