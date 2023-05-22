import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SurveyLocalStorageService {
  public localSurveyId: string = "survey-json";

  constructor() { }

  public setItem(key: string, value: string): void {
    localStorage.setItem(key, value);
  }

  public getItem(key: string): string | null {
    const item = localStorage.getItem(key);
    return item;
  }

  public getAllItems(): Record<string, any> {
    const items: Record<string, any> = {};

    for (let i = 0; i < localStorage.length; i++) {
      const key = localStorage.key(i);
      if (key) {
        items[key] = this.getItem(key);
      }
    }

    return items;
  }

  public removeItem(key: string): void {
    localStorage.removeItem(key);
  }

  public clear(): void {
    localStorage.clear();
  }
}
