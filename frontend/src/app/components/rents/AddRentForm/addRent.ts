import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface RentFormModel {
  id: number;
  slujitel_id: number;
  klient_id: number;
  avtomobil_id: number;
  dataZaemane: Date | null;
  dataVrushtane: Date | null;
  broiDni: number;
}

@Component({
  selector: 'add-rent',
  imports: [FormsModule],
  templateUrl: './addRent.html',
})
export class AddRent {
  private http = inject(HttpClient);
  slujitel_id = 0;
  klient_id = 0;
  avtomobil_id = 0;
  dataZaemane = '';
  dataVrushtane= '';
  broiDni = 0;

  onSubmit()
  {
    this.http.post("http://localhost:8081/zaemi", {
    slujitel_id:this.slujitel_id,
    klient_id:this.klient_id,
    avtomobil_id:this.avtomobil_id,
    dataZaemane:new Date(this.dataZaemane),
    dataVrushtane:new Date(this.dataVrushtane),
    broiDni:this.broiDni
    }).subscribe({
      next:(response)=>{
        console.log(response);
      }
    })
  }
}
