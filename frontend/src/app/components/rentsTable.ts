import { httpResource } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'rentsTable',
  template: `<table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Klient</th>
            <th>Kola</th>
            <th>Slujitel</th>
            <th>DataZaemane</th>
            <th>DataVrushtane</th>
            <th>broidni</th>
            <th colSpan=2>Operations</th>
          </tr>
        </thead>
        <tbody>
          @for (rent of rents.value(); track rent){
           <tr>
            <td>{{rent.Id}}</td>
            <td>{{rent.klientName}}</td>
            <td>{{rent.avtomobil.specs.marka + " " + rent.avtomobil.specs.modelName + " " + rent.avtomobil.specs.godina}}</td>
            <td>{{rent.slujitelName}}</td>
            <td>{{dateFormatter(rent.dataZaemane)}}</td>
            <td>{{dateFormatter(rent.dataVrushtane)}}</td>
            <td>{{rent.broiDni}}</td>
            <td>Edit</td>
            <td>Delete</td>
            </tr>}
          
        </tbody>
      </table>`,
})
export class Rents {
  rents:any = httpResource(()=>({
    url: `http://localhost:8081/zaemi`,
    method:"GET",
    headers:{
      'Accept':'application/json'
    }
  }));
  dateFormatter(date:string):string{
    return new Date(date).toDateString();
  }

  
}