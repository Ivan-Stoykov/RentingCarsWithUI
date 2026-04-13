import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CarsService } from '../../adminServices/cars-service';

@Component({
  selector: 'app-add-car-component',
  imports: [ReactiveFormsModule],
  templateUrl: './add-car-component.html',
  styleUrl: './add-car-component.css',
})
export class AddCarComponent {
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
  }
}
