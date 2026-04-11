import { Component, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { CarsService } from '../../../adminServices/cars-service';

@Component({
  selector: 'app-cars-dashboard-component',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './cars-dashboard-component.html',
  styleUrl: './cars-dashboard-component.css',
})
export class CarsDashboardComponent {
  private carService = inject(CarsService);
  cars = this.carService.getCars;
  marka = new FormControl();


  filter(): void{
    this.carService.getAllCars(this.marka.value)
    console.log(this.marka.value)
  }

  deleteCar(id: number): void {
    this.carService.deleteCar(id);
  }
}
