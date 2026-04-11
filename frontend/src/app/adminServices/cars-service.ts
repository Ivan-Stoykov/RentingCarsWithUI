import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Car } from '../cars-component/cars-service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CarsService {
  constructor() {
    this.getAllCars('');
  }

  private http = inject(HttpClient);
  private cars = signal<Car[]>([]);

  getAllCars(model: string) {
      console.log(model);
      let url = 'http://localhost:8081/avtomobil?';
      if (model != '') url = url + '&model=' + model;
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
  
    deleteCar(id: number) {
      this.http.delete(`http://localhost:8081/avtomobil/${id}`).subscribe({
        next: (resData) => {
          console.log(resData);
          this.getAllCars('');
        },
      });
    }

    fetchCar(id: number): Observable<Car> {
        return this.http.get<Car>(`http://localhost:8081/avtomobil/${id}`);
      }
    
      updateCar(carData: Car)
      {
        this.http.put(`http://localhost:8081/avtomobil/${carData.avtomobil_id}`, carData).subscribe({
          next: (resData) => {
            console.log(resData);
            this.getAllCars('');
          }
        });
    
      }
}
