import { HttpClient } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';
import { DatePipe } from '@angular/common';

interface Zaem
{
  Id:number,
  klientName:string,
  slujitelName:string,
  dataZaemane:string,
  dataVrushtane:string,
  broiDni:number,
  avtomobil:{
    id:number,
    cvqt:string,
    izminatiKilometri:number,
    specs:{
      spec_ID:number,
      marka:string,
      modelName:string,
      vid:string,
      ekstri:string,
      godina:number,
      cenaZaDen:number
    }
  }
}

@Component({
  selector: 'rentsTable',
  templateUrl: './rentsTable.html',
  imports:[DatePipe]
})
export class Rents {
  private http = inject(HttpClient);
  
  rents = signal<Zaem[] | undefined>(undefined);
  
  private subscribtion = this.http.get<Zaem[]>("http://localhost:8081/zaemi").subscribe({
    next:(resData)=>{
      this.rents.set(resData);
    }
  });

  onDelete(id:number)
  {
     this.http.delete(`http://localhost:8081/zaemi/${id}`).subscribe({
      next:(response)=>{
        console.log(response)
      }
     });
  }

  

  
}