import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {RequestOptions} from "@angular/http";


@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  constructor(private http: HttpClient) { }

  getAllVariables(): Observable<any> {
    return this.http.get('//localhost:8086/hospital/allVariables');
  }

  getVariableById(variable_id: number):Observable<any>{

    return this.http.get('//localhost:8086/hospital/allVariables/'+variable_id)
  }

  getVariablesByHospitalAndVersionId(hospital_id: number, version_id: number):Observable<any>{
    return this.http.get('//localhost:8086/hospital/'+hospital_id+'/variables/'+version_id)
  }

  getAllHospitals(): Observable<any> {
    return this.http.get('//localhost:8086/hospitals/hosp');
  }

  getVariableById2(variableId: string): Observable<any> {
    const params = new HttpParams().set('variable_id',variableId);
    return this.http.get('//localhost:8086/hospital/allVariables/',{params})

  }

}
