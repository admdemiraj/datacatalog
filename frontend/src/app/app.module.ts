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

@NgModule({
  declarations: [
    AppComponent,
    HospitalVariablesComponent,
    VariableByIdComponent,
    AllVariablesComponent
  ],
  imports: [

    BrowserModule,
    HttpClientModule,
    BrowserModule,
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
    AppRoutingModule
  ],

  providers: [HospitalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
