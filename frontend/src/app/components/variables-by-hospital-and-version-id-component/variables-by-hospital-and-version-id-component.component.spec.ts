import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VariablesByHospitalAndVersionIdComponentComponent } from './variables-by-hospital-and-version-id-component.component';

describe('VariablesByHospitalAndVersionIdComponentComponent', () => {
  let component: VariablesByHospitalAndVersionIdComponentComponent;
  let fixture: ComponentFixture<VariablesByHospitalAndVersionIdComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VariablesByHospitalAndVersionIdComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VariablesByHospitalAndVersionIdComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
