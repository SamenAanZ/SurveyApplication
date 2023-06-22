import { TestBed } from '@angular/core/testing';

import { SurveyLocalStorageService } from './survey-local-storage.service';

describe('SurveyLocalStorageService', () => {
  let service: SurveyLocalStorageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurveyLocalStorageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
