import { VariableByIdComponent } from './components/variable-by-id/variable-by-id.component';
import { AllVariablesComponent } from './components/all-variables/all-variables.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HospitalService} from "./shared/hospital.service";

const routes: Routes = [
  { path: '', redirectTo: '/hospital', pathMatch: 'full' },
  { path: 'hospital/:variable_id', component: VariableByIdComponent },
  { path: 'hospital',  component: AllVariablesComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
