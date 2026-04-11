import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../cars-component/cars-service';

export interface Rent {
  Id: number;
  klient: string;
  dataZaemane: string;
  broiDni: number;
  dataVrushtane: string;
  car:Car;
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
      let url = 'http://localhost:8081/zaemi';
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
      this.http.delete(`http://localhost:8081/zaemi/${id}`).subscribe({
        next: (resData) => {
          console.log(resData);
          this.getAllRents();
        },
      });
    }

    fetchRent(id: number): Observable<Rent> {
        return this.http.get<Rent>(`http://localhost:8081/zaemi/${id}`);
      }
    
      updateRent(rentData: Rent)
      {
        this.http.put(`http://localhost:8081/zaemi/${rentData.Id}`, rentData).subscribe({
          next: (resData) => {
            console.log(resData);
            this.getAllRents();
          }
        });
    
      }
}
