import { Injectable } from '@angular/core';
import {Questionnaire} from "./questionnaire";
import {Client} from "../api/client";

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {

  private readonly api: Client;


  public constructor(api: Client) {
    this.api = api;
  }

  public async RetrieveAll(): Promise<readonly Questionnaire[]> {

    return (await this.api.RetrieveAll())
      .map(x => new Questionnaire(x.formId, x.info.title, x.answerUrl, x.info.description));
  }
}
