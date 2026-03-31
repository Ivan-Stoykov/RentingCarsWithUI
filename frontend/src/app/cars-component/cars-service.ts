import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Car {
  avtomobil_id: number;
  marka_name: string;
  kolamodel: string;
  vid: string;
  cvqt: string;
  godina: number;
  cena_za_den: number;
  img_url: string;
}

export interface CarModel {
  model: string;
  marka: string;
}

@Injectable({
  providedIn: 'root',
})
export class CarService {
  constructor(private http: HttpClient) {}

  getAllCars(
    marka: string | null,
    model: string | null,
    vid: string | null,
    cvqt: string | null,
    cena: number,
    godina: number,
  ): Observable<Car[]> {
    console.log(model);
    let url = 'http://localhost:8081/avtomobil?';
    if (marka && marka != null && marka != '') url = url + '&marka=' + marka;
    if (model && model != null && model != '') url = url + '&model=' + model;
    if (vid && vid != null && vid != '') url = url + '&vid=' + vid;
    if (cvqt && cvqt != null && cvqt != '') url = url + '&cvqt=' + cvqt;
    if (cena > 0) url = url + '&cena=' + cena;
    if (godina > 0) url = url + '&godina=' + godina;
    console.log(url);

    return this.http.get<Car[]>(url);
  }

  getBrands(): Observable<string[]> {
    return this.http.get<string[]>('http://localhost:8081/marka/list');
  }

  getColors(): Observable<string[]> {
    return this.http.get<string[]>('http://localhost:8081/cvqt/list');
  }

  getTypes(): Observable<string[]> {
    return this.http.get<string[]>('http://localhost:8081/vid/list');
  }

  getModels(): Observable<CarModel[]> {
    return this.http.get<CarModel[]>('http://localhost:8081/model');
  }

  getLatestCars(): Observable<Car[]> {
    return this.http.get<Car[]>('http://localhost:8081/avtomobil/latest');
  }
}
