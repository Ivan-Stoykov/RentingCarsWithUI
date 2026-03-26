import { httpResource } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Rents } from "./components/rents/rentsTable/rentsTable";
import { AddRent } from "./components/rents/AddRentForm/addRent";
import { HomePage } from "./home-page/home-page";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Rents, AddRent, HomePage],
  template: `<app-home-page/>`,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
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
