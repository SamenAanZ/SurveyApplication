import {QuestionnaireDto} from "./questionnaire-dto";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class Client {

  public async RetrieveAll(): Promise<readonly QuestionnaireDto[]> {
    return [
      {
        "formId": "01",
        "answerUrl": "#01",
        "info": {
          "title": "ABC",
          "description": "aaa"
        },
      },
      {
        "formId": "02",
        "answerUrl": "#02",
        "info": {
          "title": "DEF",
          "description": "bbb"
        },
      },
      {
        "formId": "03",
        "answerUrl": "#03",
        "info": {
          "title": "GHI",
          "description": "ccc"
        },
      }
    ]
  }
}
