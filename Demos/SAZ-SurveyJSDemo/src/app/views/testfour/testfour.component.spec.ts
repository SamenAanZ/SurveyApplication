import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestfourComponent } from './testfour.component';

describe('TestfourComponent', () => {
  let component: TestfourComponent;
  let fixture: ComponentFixture<TestfourComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TestfourComponent]
    });
    fixture = TestBed.createComponent(TestfourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
