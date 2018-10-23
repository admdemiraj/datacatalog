import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetVersionsPerVariableComponent } from './get-versions-per-variable.component';

describe('GetVersionsPerVariableComponent', () => {
  let component: GetVersionsPerVariableComponent;
  let fixture: ComponentFixture<GetVersionsPerVariableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetVersionsPerVariableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetVersionsPerVariableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
