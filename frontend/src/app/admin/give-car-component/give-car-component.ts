import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { OtdavaneService } from '../adminServices/otdavane-service';

@Component({
  selector: 'app-give-car-component',
  imports: [ReactiveFormsModule],
  templateUrl: './give-car-component.html',
  styleUrl: './give-car-component.css',
})
export class GiveCarComponent {
  giveCar: FormGroup;
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private otdavaneService = inject(OtdavaneService);
  constructor(private fb: FormBuilder) {
    this.giveCar = this.fb.group({
      klient: [{value:'', disabled:true}],
      car: [{value:'', disabled:true}],
      dataPredavane: [''],
    });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('otdavaneId');

    if (id) {
      this.otdavaneService.fetchOtdavane(Number(id)).subscribe({
        next: (otdavane) => {
          console.log(otdavane);
          this.giveCar.patchValue({
            klient: otdavane.klient,
            car: otdavane.car.marka_name + " " + otdavane.car.kolamodel + " " + otdavane.car.godina
          });
        },
        error: (err) => {
          console.error('Грешка при зареждане на отдаване:', err);
          this.router.navigate(['/admin/otdavane']);
        },
      });
    }
  }

  onSubmit(): void {
    if (this.giveCar.valid) {
      const updatedData = this.giveCar.controls['dataPredavane'].value;
      const otdavaneId = this.route.snapshot.paramMap.get('otdavaneId');

      this.otdavaneService.otdavane( Number(otdavaneId), new Date(updatedData) );
      console.log('Потребителят е успешно обновен!');
      this.router.navigate(['/admin/otdavane']);
    }
  }
}
