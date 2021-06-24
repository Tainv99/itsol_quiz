import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatQuizComponent } from './creat-quiz.component';

describe('CreatQuizComponent', () => {
  let component: CreatQuizComponent;
  let fixture: ComponentFixture<CreatQuizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatQuizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
