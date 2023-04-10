import { Injectable } from '@angular/core';
import {Questionnaire} from "./questionnaire";

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {
  public async RetrieveAll(): Promise<readonly Questionnaire[]> {
    return [
      new Questionnaire("01", "Quest", "#"),
      new Questionnaire("02", "DCD", "#"),
      new Questionnaire("03", "AFG", "#")
    ]
  }
}
