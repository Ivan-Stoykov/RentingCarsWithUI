import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  template: `{{cars()}}`,
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  cars:any = signal([]);

  async fetchCars():Promise<any>{
    const response = await fetch("http://localhost:8081/zaemi");
      const resData = await response.json();
      this.cars.set(resData)
  }
}
