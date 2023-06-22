import { TestBed } from '@angular/core/testing';

import { SurveyPersistanceService } from './survey-persistance.service';

describe('SurveyPersistanceService', () => {
  let service: SurveyPersistanceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurveyPersistanceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
