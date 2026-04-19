import { Component, inject, OnInit } from '@angular/core';
import { OtdavaneService } from '../../adminServices/otdavane-service';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-otdavane-dashboard-component',
  imports: [RouterLink, ReactiveFormsModule, DatePipe],
  templateUrl: './otdavane-dashboard-component.html',
  styleUrl: './otdavane-dashboard-component.css',
})
export class OtdavaneDashboardComponent implements OnInit {
  private otdavaneService = inject(OtdavaneService);
  otdavaniq = this.otdavaneService.getZaOtdavane;
  klient = new FormControl('');

  ngOnInit(): void {
    this.otdavaneService.fetchZaOtdavane('');
  }

  filter(): void{
    this.otdavaneService.fetchZaOtdavane(this.klient.value!);
  }

  deleteOtdavane(id: number): void {
    this.otdavaneService.deleteOtdavane(id);
  }
}
