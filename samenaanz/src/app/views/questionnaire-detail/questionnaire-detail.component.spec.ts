import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionnaireDetailComponent } from './questionnaire-detail.component';

describe('QuestionnaireDetailComponent', () => {
  let component: QuestionnaireDetailComponent;
  let fixture: ComponentFixture<QuestionnaireDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [QuestionnaireDetailComponent]
    });
    fixture = TestBed.createComponent(QuestionnaireDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
