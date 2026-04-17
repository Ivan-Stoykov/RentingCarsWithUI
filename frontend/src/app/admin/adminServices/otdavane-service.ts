import { inject, Injectable, signal } from '@angular/core';
import { Rent } from './rents-service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root',
})
export class OtdavaneService {
  private otdavaniq = signal<Rent[]>([]);
  private zaOtdavane = signal<Rent[]>([]);
  private otdadeni = signal<Rent[]>([]);
  private http = inject(HttpClient);

  constructor() {
    this.fetchAllOtdavaniq();
  }

  get getOtdavaniq(){
    return this.otdavaniq.asReadonly();
  }
  get getZaOtdavane(){
    return this.zaOtdavane.asReadonly();
  }
  get getOtdadeni(){
    return this.otdadeni.asReadonly();
  }

  otdavane(zaem_id:number, data:Date){
    this.http.post(`http://${environment.apiUrl}/otdavaniq/otdavane`, {zaem_id, data}).subscribe({
      next:(resData)=>{
        console.log(resData);
      }
    })
  }

  vrushtane(zaem_id:number, data:Date){
    this.http.post(`http://${environment.apiUrl}/otdavaniq/vrushtane`, {zaem_id, data}).subscribe({
      next:(resData)=>{
        console.log(resData);
      }
    })
  }


  fetchAllOtdavaniq() {
    let url = `http://${environment.apiUrl}/otdavaniq`;
    console.log(url);

    this.http.get<Rent[]>(url).subscribe({
      next: (otdavaniq) => {
        this.otdavaniq.set(otdavaniq);
        console.log(otdavaniq);
      },
    });
  }

  fetchZaOtdavane() {
    let url = `http://${environment.apiUrl}/otdavaniq/zaOtdavane`;
    console.log(url);

    this.http.get<Rent[]>(url).subscribe({
      next: (otdavaniq) => {
        this.zaOtdavane.set(otdavaniq);
        console.log(otdavaniq);
      },
    });
  }

  fetchOtdadeni() {
    let url = `http://${environment.apiUrl}/otdavaniq/otdadeni`;
    console.log(url);

    this.http.get<Rent[]>(url).subscribe({
      next: (otdavaniq) => {
        this.otdadeni.set(otdavaniq);
        console.log(otdavaniq);
      },
    });
  }

  deleteOtdavane(id: number) {
    this.http.delete(`http://${environment.apiUrl}/otdavaniq/${id}`).subscribe({
      next: (resData) => {
        console.log(resData);
        this.fetchAllOtdavaniq();
      },
    });
  }

  fetchOtdavane(id: number): Observable<Rent> {
    return this.http.get<Rent>(`http://${environment.apiUrl}/otdavaniq/${id}`);
  }

  updateOtdavane(rentData: {
    Id: number;
    avtomobil_id: number;
    klient_ID: number;
    dataZaemane: string;
    dataVrushtane: string;
    broiDni: number;
  }) {
    {
      console.log('Изпращане на данни за обновяване:', rentData);
      this.http.put(`http://${environment.apiUrl}/otdavaniq/${rentData.Id}`, rentData).subscribe({
        next: (resData) => {
          console.log(resData);
          this.fetchAllOtdavaniq();
        },
      });
    }
  }
}
