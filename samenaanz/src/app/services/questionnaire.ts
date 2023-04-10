export class Questionnaire {
  public readonly id: string;
  public readonly name: string;
  public readonly link: string;

  public constructor(id: string, name: string, link: string) {
    this.id = id;
    this.name = name;
    this.link = link;
  }
}
