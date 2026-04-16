import { Component, inject } from '@angular/core';
import { OtdavaneService } from '../../adminServices/otdavane-service';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-otdavane-dashboard-component',
  imports: [RouterLink, ReactiveFormsModule],
  templateUrl: './otdavane-dashboard-component.html',
  styleUrl: './otdavane-dashboard-component.css',
})
export class OtdavaneDashboardComponent {
  private otdavaneService = inject(OtdavaneService);
  otdavaniq = this.otdavaneService.getOtdavaniq;
  klient = new FormControl('');


  filter(): void{
    //this.carService.getAllCars(this.klient.value!)
    //console.log(this.marka.value)
  }

  deleteOtdavane(id: number): void {
    this.otdavaneService.deleteOtdavane(id);
  }
}
