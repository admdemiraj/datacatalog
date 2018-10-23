import { Component, OnInit } from '@angular/core';
import {HospitalService} from "../../shared/hospital.service";

@Component({
  selector: 'app-get-versions-per-variable',
  templateUrl: './get-versions-per-variable.component.html',
  styleUrls: ['./get-versions-per-variable.component.css']
})
export class GetVersionsPerVariableComponent implements OnInit {
versions : Array<any>;
  constructor(private hospitalService: HospitalService) { }

  ngOnInit() {
  }

}
