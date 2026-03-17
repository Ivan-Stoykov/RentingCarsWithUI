import { httpResource } from '@angular/common/http';
import { Component, signal } from '@angular/core';
//import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  //imports: [RouterOutlet],
  template: `{{cars}}`,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  cars:any = httpResource(()=>({
    url: `http://localhost:8081/zaemi/`,
    headers:{
      'Accept':'application/json'
    }
  }));

  
}
