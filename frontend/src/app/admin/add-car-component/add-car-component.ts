import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CarsService } from '../adminServices/cars-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-car-component',
  imports: [ReactiveFormsModule],
  templateUrl: './add-car-component.html',
  styleUrl: './add-car-component.css',
})
export class AddCarComponent {
  private router = inject(Router);
  private carService = inject(CarsService);
  addCar: FormGroup;
  constructor(private fb: FormBuilder) {
    this.addCar = this.fb.group({
      marka: [''],
      model: [''],
      vid: [''],
      img_url: [''],
      godina: [0],
      cvqt: [''],
      ekstri: [''],
      cenaZaDen: [0],
      izminatiKilometri: [0],
    });
  }

  onSubmit() {
    this.carService.addCar(this.addCar.value);
    this.router.navigate(['/admin/cars']);
  }
}
