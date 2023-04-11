import {QuestionnaireDto} from "./questionnaire-dto";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class Client {

  private readonly questionnaires: QuestionnaireDto[] = [
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
  ];

  public async RetrieveAll(): Promise<readonly QuestionnaireDto[]> {
    return this.questionnaires;
  }

  public async Create(title: string, description: string): Promise<void> {
    const id = Math.floor(Math.random() * 100);

    this.questionnaires.push({
      "formId": `${id}`,
      "answerUrl": `#${id}`,
      "info": {
        "title": title,
        "description": description
      }
    })
  }
}
