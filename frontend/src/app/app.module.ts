import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HospitalService } from './shared/hospital.service';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTabsModule, MatExpansionModule, MatIconModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { HospitalVariablesComponent } from './shared/hospital-variables/hospital-variables.component';
import {RouterModule, Routes} from "@angular/router";
import {VariableByIdComponent} from "./components/variable-by-id/variable-by-id.component";
import {AllVariablesComponent} from "./components/all-variables/all-variables.component";
import {AppRoutingModule} from "./app-routing.module";
import { VariablesByHospitalAndVersionIdComponentComponent } from './components/variables-by-hospital-and-version-id-component/variables-by-hospital-and-version-id-component.component';
import { GetAllHospitalsComponent } from './components/get-all-hospitals/get-all-hospitals.component';
import { GetVersionsPerVariableComponent } from './components/get-versions-per-variable/get-versions-per-variable.component';
import { FormsModule } from '@angular/forms';
import {LogService} from "./shared/log.service";

@NgModule({
  declarations: [
    AppComponent,
    HospitalVariablesComponent,
    VariableByIdComponent,
    AllVariablesComponent,
    VariablesByHospitalAndVersionIdComponentComponent,
    GetAllHospitalsComponent,
    GetVersionsPerVariableComponent

  ],
  imports: [

    BrowserModule,
    HttpClientModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatTabsModule,
    MatExpansionModule,
    MatIconModule,
    AppRoutingModule,
    FormsModule
  ],

  providers: [HospitalService, LogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
