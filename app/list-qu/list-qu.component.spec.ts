import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListQUComponent } from './list-qu.component';

describe('ListQUComponent', () => {
  let component: ListQUComponent;
  let fixture: ComponentFixture<ListQUComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListQUComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListQUComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
