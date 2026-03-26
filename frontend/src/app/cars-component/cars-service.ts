import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface Car {
  avtomobil_id: number;
  marka_name: string;
  kolamodel: string;
  vid: string;
  cvqt: string;
  godina: number;
  cena_za_den: number;
  imageUrl: string;
}

export interface CarModel{
    model: string,
    marka : string
}

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  getAllCars(): Observable<Car[]> {
    return this.http.get<Car[]>("http://localhost:8081/avtomobil");
  }

  getBrands() : Observable<string[]>{
    return this.http.get<string[]>("http://localhost:8081/marka/list")
  }

  getColors() : Observable<string[]>{
    return this.http.get<string[]>("http://localhost:8081/cvqt/list")
  }

  getTypes() : Observable<string[]>{
    return this.http.get<string[]>("http://localhost:8081/vid/list")
  }

  getModels(): Observable<CarModel[]> {
  return this.http.get<CarModel[]>("http://localhost:8081/model");
}
}