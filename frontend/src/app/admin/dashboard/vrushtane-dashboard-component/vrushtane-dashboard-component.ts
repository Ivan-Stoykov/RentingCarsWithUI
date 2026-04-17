import { Component, inject, OnInit } from '@angular/core';
import { OtdavaneService } from '../../adminServices/otdavane-service';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-vrushtane-dashboard-component',
  imports: [RouterLink, ReactiveFormsModule, DatePipe],
  templateUrl: './vrushtane-dashboard-component.html',
  styleUrl: './vrushtane-dashboard-component.css',
})
export class VrushtaneDashboardComponent implements OnInit {
    private otdavaneService = inject(OtdavaneService);
  otdavaniq = this.otdavaneService.getOtdadeni;
  klient = new FormControl('');

  ngOnInit(): void {
    this.otdavaneService.fetchOtdadeni();
  }

  filter(): void{
    //this.carService.getAllCars(this.klient.value!)
    //console.log(this.marka.value)
  }

  deleteOtdavane(id: number): void {
    this.otdavaneService.deleteOtdavane(id);
  }
}
