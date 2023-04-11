export class Questionnaire {
  public readonly id: string;
  public readonly title: string;
  public readonly answerUrl: string;
  public readonly description: string;

  public constructor(id: string, title: string, answerUrl: string, description: string ) {
    this.id = id;
    this.title = title;
    this.answerUrl = answerUrl;
    this.description = description;
  }
}
