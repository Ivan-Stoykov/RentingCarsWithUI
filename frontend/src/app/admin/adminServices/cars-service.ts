import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Car } from '../../cars-component/cars-service';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';


export interface PostCar {
  marka: string;
  model: string;
  vid: string;
  img_url: string;
  godina: number;
  cvqt: string;
  ekstri: string;
  cenaZaDen: number;
  izminatiKilometri: number;
}

@Injectable({
  providedIn: 'root',
})
export class CarsService {
  constructor() {
    this.getAllCars('');
  }

  private http = inject(HttpClient);
  private cars = signal<Car[]>([]);

  getAllCars(avtomobil: string) {
      console.log(avtomobil);
      let url = `http://${environment.apiUrl}/avtomobil?`;
      if (avtomobil != '') url = url + '&avtomobil=' + avtomobil;
      console.log(url);
  
      this.http.get<Car[]>(url).subscribe({
        next: (cars) => {
          this.cars.set(cars);
        },
      });
    }
  
    get getCars() {
      return this.cars.asReadonly();
    }

      addCar(car: PostCar) {
    console.log(car);
    this.http.post(`http://${environment.apiUrl}/avtomobil`, car).subscribe({
      next: (resData) => {
        console.log(resData);
      },
    });
    this.getAllCars('');
  }
  
    deleteCar(id: number) {
      this.http.delete(`http://${environment.apiUrl}/avtomobil/${id}`).subscribe({
        next: (resData) => {
          console.log(resData);
          this.getAllCars('');
        },
      });
    }

    fetchCar(id: number): Observable<Car> {
        return this.http.get<Car>(`http://${environment.apiUrl}/avtomobil/${id}`);
      }
    
      updateCar(carData: Car)
      {
        this.http.put(`http://${environment.apiUrl}/avtomobil/${carData.avtomobil_id}`, carData).subscribe({
          next: (resData) => {
            console.log(resData);
            this.getAllCars('');
          }
        });
    
      }
}
