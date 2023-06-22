import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Survey } from '../models/survey';
import { backendEnvironment } from 'src/environments/environment';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SurveyPersistanceService {

  constructor(private readonly httpClient: HttpClient) { }

  public createSurvey(survey: Object): void {
    const url = `${backendEnvironment.url}/survey`;
    
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    console.log(survey);
    const jsonSurvey = JSON.stringify(survey);

    this.httpClient.post(url, jsonSurvey, httpOptions).subscribe();
  }

  public getSurveysByUserId(userId: string): Observable<Survey[]> {
    const url = `${backendEnvironment.url}/survey?userId=${userId}`;
    return this.httpClient.get<Survey[]>(url).pipe(
      map((response: Survey[]) => {
        return response;
      })
    )
  }

  public getSurveysByOwnerId(ownerId: string): Observable<Survey[]> {
    const url = `${backendEnvironment.url}/survey?ownerId=${ownerId}`;
    return this.httpClient.get<Survey[]>(url).pipe(
      map((response: Survey[]) => {
        return response;
      })
    )
  }

  public getSurveyBySurveyId(surveyId: string): Observable<Survey> {
    const url = `${backendEnvironment.url}/survey/${surveyId}`;
    return this.httpClient.get<Survey>(url).pipe(
      map((response: Survey) => {
        return response;
      })
    )
  }
}