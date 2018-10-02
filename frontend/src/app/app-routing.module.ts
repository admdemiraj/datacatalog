import { VariableByIdComponent } from './components/variable-by-id/variable-by-id.component';
import { AllVariablesComponent } from './components/all-variables/all-variables.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HospitalService} from "./shared/hospital.service";
import {VariablesByHospitalAndVersionIdComponentComponent} from "./components/variables-by-hospital-and-version-id-component/variables-by-hospital-and-version-id-component.component";
import {GetAllHospitalsComponent} from "./components/get-all-hospitals/get-all-hospitals.component";

const routes: Routes = [
  { path: '', redirectTo: '/hospital', pathMatch: 'full' },
  { path: 'hospital/:variable_id', component: VariableByIdComponent },
  { path: 'hospital',  component: AllVariablesComponent },
  {path:'hospital/:hospital_id/variables/:version_id', component: VariablesByHospitalAndVersionIdComponentComponent},
  {path:'hospitals/hosp', component: GetAllHospitalsComponent},
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
