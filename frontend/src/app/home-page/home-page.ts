import { Component, OnInit, signal } from '@angular/core';
import { Car, CarService } from '../cars-component/cars-service';

@Component({
  selector: 'app-home-page',
  imports: [],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit {
  latestCars = signal<Car[]>([]);

  constructor(private carService: CarService) {}
  ngOnInit(): void {
    this.carService.getLatestCars().subscribe({
      next: (resData) => this.latestCars.set(resData),
    });
  }
}
