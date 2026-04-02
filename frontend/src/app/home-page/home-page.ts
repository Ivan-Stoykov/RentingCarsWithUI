import { Component, OnInit, signal } from '@angular/core';
import { Car, CarService } from '../cars-component/cars-service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  imports: [ReactiveFormsModule],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit {
  latestCars = signal<Car[]>([]);
  form: FormGroup;

  constructor(private carService: CarService, private fb:FormBuilder, private router: Router) {
    this.form = this.fb.group({
      dataZaemane: [''],
      dataVrushtane:['']
    })
  }
  ngOnInit(): void {
    this.carService.getLatestCars().subscribe({
      next: (resData) => this.latestCars.set(resData),
    });
  }

  onFind(){
    console.log(this.form)
    this.carService.getAllCars('', '', '', '', 0, 0, this.form.value.dataZaemane, this.form.value.dataVrushtane);
    this.router.navigate(["/", "cars"]);
  }
}
