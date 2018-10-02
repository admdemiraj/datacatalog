import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../../shared/hospital.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-variables-by-hospital-and-version-id-component',
  templateUrl: './variables-by-hospital-and-version-id-component.component.html',
  styleUrls: ['./variables-by-hospital-and-version-id-component.component.css']
})
export class VariablesByHospitalAndVersionIdComponentComponent implements OnInit {
  variables: Array<any>;
  constructor(private hospitalService: HospitalService,
              private route: ActivatedRoute,
              private location: Location) { }

  ngOnInit():void {
    this.route.params
      .switchMap((params: Params) => this.hospitalService.getVariablesByHospitalAndVersionId(+params['hospital_id'],+params['version_id']))
      .subscribe(variables => this.variables = variables)
  }

  goBack(): void {
    this.location.back();
  }

}

