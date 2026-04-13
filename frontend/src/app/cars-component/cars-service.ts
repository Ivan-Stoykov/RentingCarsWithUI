import { HttpClient } from '@angular/common/http';
import { Injectable, signal } from '@angular/core';
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
  ime_extra: string;
  izminatikilometri: number;
}


export interface CarModel {
  model: string;
  marka: string;
}

@Injectable({
  providedIn: 'root',
})
export class CarService {
  constructor(private http: HttpClient) {
    this.getAllCars('', '', '', 0, 0, '', '');
  }

  private cars = signal<Car[]>([]);
  private allBrands = signal<string[]>([]);
  private allColors = signal<string[]>([]);
  private allTypes = signal<string[]>([]);
  private allModels = signal<CarModel[]>([]);
  private dataZaemane = signal<string>('');
  private dataVrushtane = signal<string>('');

  getAllCars(
    avtomobil: string,
    vid: string,
    cvqt: string,
    cena: number,
    godina: number,
    dataZaemane: string,
    dataVrushtane: string,
  ) {
    console.log(avtomobil);
    let url = 'http://localhost:8081/avtomobil?';
    if (avtomobil != '') url = url + '&avtomobil=' + avtomobil;
    if (vid != '') url = url + '&vid=' + vid;
    if (cvqt != '') url = url + '&cvqt=' + cvqt;
    if (cena > 0) url = url + '&cena=' + cena;
    if (godina > 0) url = url + '&godina=' + godina;
    if (dataZaemane != '') url = url + '&dataZaemane=' + dataZaemane;
    if (dataVrushtane != '') url = url + '&dataVrushtane=' + dataVrushtane;
    console.log(url);

    this.http.get<Car[]>(url).subscribe({
      next: (cars) => {
        this.cars.set(cars);
        this.dataZaemane.set(dataZaemane);
        this.dataVrushtane.set(dataVrushtane);
      },
    });
  }

  get getCars() {
    return this.cars.asReadonly();
  }

  get getDataVrushtane() {
    return this.dataVrushtane.asReadonly();
  }
  get getDataZaemane() {
    return this.dataZaemane.asReadonly();
  }

  getBrands() {
    this.http.get<string[]>('http://localhost:8081/marka/list').subscribe({
      next: (brands) => {
        this.allBrands.set(brands);
      },
    });
    return this.allBrands.asReadonly();
  }

  getColors() {
    this.http.get<string[]>('http://localhost:8081/cvqt/list').subscribe({
      next: (colors) => {
        this.allColors.set(colors);
      },
    });
    return this.allColors.asReadonly();
  }

  getTypes() {
    this.http.get<string[]>('http://localhost:8081/vid/list').subscribe({
      next: (types) => {
        this.allTypes.set(types);
      },
    });
    return this.allTypes.asReadonly();
  }

  getModels() {
    this.http.get<CarModel[]>('http://localhost:8081/model').subscribe({
      next: (models) => {
        this.allModels.set(models);
      },
    });
    return this.allModels.asReadonly();
  }

  getLatestCars(): Observable<Car[]> {
    return this.http.get<Car[]>('http://localhost:8081/avtomobil/latest');
  }

  fetchCar(id: number): Observable<Car> {
        return this.http.get<Car>(`http://localhost:8081/avtomobil/${id}`);
      }

  checkAvailability(carId: number, start: string, end: string): Observable<boolean> {
    // Връща true (свободен) или false (зает)
    return this.http.get<boolean>(`http://localhost:8081/avtomobil/${carId}/availability?start=${start}&end=${end}`);
  }

  rentCar(avtomobil_id: number, klient_id: number, zaemane: string, vrushtane: string, broiDni: number): Observable<any> {
    // Праща заявка за наемане
    return this.http.post(`http://localhost:8081/zaemi`, { avtomobil_id, klient_id, zaemane, vrushtane, broiDni });
  }
}
