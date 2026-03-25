import { HttpClient } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';
import { DatePipe } from '@angular/common';

interface Zaem
{
  zaem_id:number,
  klient:string,
  slujitel:string,
  datazaemane:string,
  datavrushtane:string,
  broidni:number,
  marka_name:string,
  cena_za_den:number,
  cvqt:string,
  godina:number,
  ime_extra:string,
  kolamodel:string,
  vid:string
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