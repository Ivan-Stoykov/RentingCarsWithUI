import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../../cars-component/cars-service';
import { environment } from '../../../environments/environment';

export interface Rent {
  Id: number;
  klient_ID: number;
  klient: string;
  email: string;
  dataZaemane: string;
  broiDni: number;
  dataVrushtane: string;
  car: Car;
}

@Injectable({
  providedIn: 'root',
})
export class RentsService {
  constructor() {
    this.getAllRents();
  }

  private http = inject(HttpClient);
  private rents = signal<Rent[]>([]);

  getAllRents() {
    let url = `http://${environment.apiUrl}/zaemi`;
    console.log(url);

    this.http.get<Rent[]>(url).subscribe({
      next: (rents) => {
        this.rents.set(rents);
        console.log(rents);
      },
    });
  }

  get getRents() {
    return this.rents.asReadonly();
  }

  deleteRent(id: number) {
    this.http.delete(`http://${environment.apiUrl}/zaemi/${id}`).subscribe({
      next: (resData) => {
        console.log(resData);
        this.getAllRents();
      },
    });
  }

  fetchRent(id: number): Observable<Rent> {
    return this.http.get<Rent>(`http://${environment.apiUrl}/zaemi/${id}`);
  }

  updateRent(rentData: {
    Id: number;
    avtomobil_id: number;
    klient_ID: number;
    dataZaemane: string;
    dataVrushtane: string;
    broiDni: number;
  }) {
    {
      console.log('Изпращане на данни за обновяване:', rentData);
      this.http.put(`http://${environment.apiUrl}/zaemi/${rentData.Id}`, rentData).subscribe({
        next: (resData) => {
          console.log(resData);
          this.getAllRents();
        },
      });
    }
  }
}
