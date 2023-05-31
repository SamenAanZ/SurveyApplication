import {QuestionnaireDto} from "./questionnaire-dto";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class Client {

  private readonly questionnaires: QuestionnaireDto[] = [
    {
      "formId": "68a96100-8cc1-4d0d-bf69-8455bae4412d",
      "answerUrl": "#01",
      "info": {
        "title": "Employee Health Survey",
        "description": "VitalCare Health Solutions"
      },
    },
    {
      "formId": "01191117-8a96-466c-8759-c88dc1fdb30a",
      "answerUrl": "#02",
      "info": {
        "title": "Workplace Health Assessment Survey",
        "description": "Harmony Health Institute"
      },
    },
    {
      "formId": "75039f9e-e432-4852-b2c7-6b801f0c5ede",
      "answerUrl": "#03",
      "info": {
        "title": "Employee Feedback Survey",
        "description": "HealthMatters"
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
