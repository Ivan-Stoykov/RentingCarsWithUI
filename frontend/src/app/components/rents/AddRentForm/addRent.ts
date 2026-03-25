import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface RentFormModel {
  id: number;
  slujitel_id: number;
  klient_id: number;
  avtomobil_id: number;
  zaemane: Date | null;
  vrushtane: Date | null;
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
  zaemane = '';
  vrushtane= '';
  broiDni = 0;

  onSubmit()
  {
    this.http.post("http://localhost:8081/zaemi", {
    slujitel_id:this.slujitel_id,
    klient_id:this.klient_id,
    avtomobil_id:this.avtomobil_id,
    zaemane:new Date(this.zaemane),
    vrushtane:new Date(this.vrushtane),
    broiDni:this.broiDni
    }).subscribe({
      next:(response)=>{
        console.log(response);
      }
    })
  }
}
