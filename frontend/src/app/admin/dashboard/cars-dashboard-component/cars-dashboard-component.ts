import { Component, inject, OnInit } from '@angular/core';
import { AdminService } from '../../admin-service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-cars-dashboard-component',
  imports: [ReactiveFormsModule],
  templateUrl: './cars-dashboard-component.html',
  styleUrl: './cars-dashboard-component.css',
})
export class CarsDashboardComponent implements OnInit {
  private adminService = inject(AdminService);
  cars = this.adminService.getCars;
  marka = new FormControl();

  ngOnInit(): void {
  }

  filter(): void{
    this.adminService.getAllCars(this.marka.value)
    console.log(this.marka.value)
  }
}
