import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailQuComponent } from './detail-qu.component';

describe('DetailQuComponent', () => {
  let component: DetailQuComponent;
  let fixture: ComponentFixture<DetailQuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailQuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailQuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
