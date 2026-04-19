import { Component, inject, OnInit } from '@angular/core';
import { RentsService } from '../../adminServices/rents-service';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { CurrencyPipe, DatePipe } from '@angular/common';

@Component({
  selector: 'app-rents-dashboard-component',
  imports: [RouterLink, DatePipe, CurrencyPipe, ReactiveFormsModule],
  templateUrl: './rents-dashboard-component.html',
  styleUrl: './rents-dashboard-component.css',
})
export class RentsDashboardComponent implements OnInit {
  private rentService = inject(RentsService);
  rents = this.rentService.getRents;
  klient = new FormControl('');

  ngOnInit(): void {
    this.rentService.getAllRents('');
  }

  filter(): void{
    this.rentService.getAllRents(this.klient.value!);
  }

   deleteRent(id: number): void {
     this.rentService.deleteRent(id);
   }
}
