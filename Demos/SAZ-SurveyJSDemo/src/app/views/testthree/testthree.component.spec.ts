import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestthreeComponent } from './testthree.component';

describe('TestthreeComponent', () => {
  let component: TestthreeComponent;
  let fixture: ComponentFixture<TestthreeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TestthreeComponent]
    });
    fixture = TestBed.createComponent(TestthreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
