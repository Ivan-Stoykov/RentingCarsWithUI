import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CarsService } from '../../adminServices/cars-service';

@Component({
  selector: 'app-edit-car-component',
  imports: [ReactiveFormsModule],
  templateUrl: './edit-car-component.html',
  styleUrl: './edit-car-component.css',
})
export class EditCarComponent {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private carService = inject(CarsService);
  editCar: FormGroup;
  constructor(private fb: FormBuilder) {
    this.editCar = this.fb.group({
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

  ngOnInit(): void {
    const carId = this.route.snapshot.paramMap.get('carId');

    if (carId) {
      this.carService.fetchCar(Number(carId)).subscribe({
        next: (carData) => {
          console.log(carData);
          this.editCar.patchValue({
            marka: carData.marka_name,
            model: carData.kolamodel,
            vid: carData.vid,
            img_url: carData.img_url,
            godina: carData.godina,
            cvqt: carData.cvqt,
            ekstri: carData.ime_extra,
            cenaZaDen: carData.cena_za_den,
            izminatiKilometri: carData.izminatikilometri
          });
        },
        error: (err) => {
          console.error('Грешка при зареждане на автомобила:', err);
          this.router.navigate(['/admin/cars']);
        },
      });
    }
  }

  onSubmit(): void {
    if (this.editCar.valid) {
      const updatedData = this.editCar.value;
      const carId = this.route.snapshot.paramMap.get('carId');

       this.carService.updateCar({ ...updatedData, avtomobil_id: Number(carId) });
       console.log('Автомобилът е успешно обновен!');
       this.router.navigate(['/admin/cars']);
    }
  }
}
