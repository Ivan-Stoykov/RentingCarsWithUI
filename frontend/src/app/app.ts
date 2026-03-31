import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AppHeaderComponent } from './app-header-component/app-header-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterOutlet, AppHeaderComponent],
  templateUrl: "./app.html",
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');

  
}
