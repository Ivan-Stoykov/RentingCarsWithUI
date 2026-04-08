import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Car } from '../cars-component/cars-service';
import { User } from '../user/user-service';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  constructor() {
    this.getAllCars('');
    this.getAllUsers('');
  }
  private http = inject(HttpClient);
  private cars = signal<Car[]>([]);
  private users = signal<User[]>([]);
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

  getAllUsers(ime: string) {
    console.log(ime);
    let url = 'http://localhost:8081/klient?';
    if (ime != '') url = url + '&model=' + ime;
    console.log(url);

    this.http.get<User[]>(url).subscribe({
      next: (users) => {
        this.users.set(users);
      },
    });
  }

  get getUsers() {
    return this.users.asReadonly();
  }

}
