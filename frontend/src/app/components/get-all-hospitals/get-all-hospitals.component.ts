import { Component, OnInit } from '@angular/core';
import {HospitalService} from "../../shared/hospital.service";

@Component({
  selector: 'app-get-all-hospitals',
  templateUrl: './get-all-hospitals.component.html',
  styleUrls: ['./get-all-hospitals.component.css']
})
export class GetAllHospitalsComponent implements OnInit {
hospitals: Array<any>;

  constructor(private hospitalService: HospitalService) { }

  ngOnInit() {
    this.hospitalService.getAllHospitals().subscribe(data => {
      this.hospitals = data;
    });
  }

}
