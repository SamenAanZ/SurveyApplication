import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestfiveComponent } from './testfive.component';

describe('TestfiveComponent', () => {
  let component: TestfiveComponent;
  let fixture: ComponentFixture<TestfiveComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TestfiveComponent]
    });
    fixture = TestBed.createComponent(TestfiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
