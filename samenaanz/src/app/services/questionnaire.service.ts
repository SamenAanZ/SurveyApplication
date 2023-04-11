import { Injectable } from '@angular/core';
import {Questionnaire} from "./questionnaire";
import {Client} from "../api/client";
import {Observable, Subject} from "rxjs";
import {Mutation} from "./mutation";

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {

  private readonly api: Client;
  private readonly mutationsSubject: Subject<Mutation>;

  public constructor(api: Client) {
    this.api = api;
    this.mutationsSubject = new Subject<Mutation>();
  }

  public get Mutations(): Observable<Mutation> {
    return this.mutationsSubject;
  }

  public async RetrieveAll(): Promise<readonly Questionnaire[]> {

    return (await this.api.RetrieveAll())
      .map(x => new Questionnaire(x.formId, x.info.title, x.answerUrl, x.info.description));
  }
}
