import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { QuestionnaireDto } from "./questionnaire-dto";

@Injectable({
  providedIn: 'root',
})
export class Client {

  private readonly apiUrl = 'https://example.com/api/questionnaires';

  constructor(private http: HttpClient) { }

  public RetrieveAll(): Observable<readonly QuestionnaireDto[]> {
    return this.http.get<readonly QuestionnaireDto[]>(this.apiUrl);
  }

  public Create(title: string, description: string): Observable<void> {
    const id = Math.floor(Math.random() * 100);

    const newQuestionnaire: QuestionnaireDto = {
      "formId": `${id}`,
      "answerUrl": `#${id}`,
      "info": {
        "title": title,
        "description": description
      }
    };

    return this.http.post<void>(this.apiUrl, newQuestionnaire);
  }
}
