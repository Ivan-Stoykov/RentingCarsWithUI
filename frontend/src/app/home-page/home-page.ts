import { Component, OnInit, signal } from '@angular/core';
import { Car, CarService } from '../cars-component/cars-service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from "@angular/forms";
import { Router, RouterLink } from '@angular/router';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-home-page',
  imports: [ReactiveFormsModule, RouterLink, CurrencyPipe],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage implements OnInit {
  latestCars = signal<Car[]>([]);
  validDates = signal<boolean | null>(null);
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
    this.setupDateListener();
  }

    private setupDateListener(): void {
    this.form.get('dataVrushtane')?.valueChanges.subscribe((date) => {
      const dataZaemane = this.form.get('dataZaemane')?.value;
      if(dataZaemane != ''){
        const zaemane = new Date(dataZaemane);
        const vrushtane = new Date(date);
        if(zaemane.getDate() > vrushtane.getDate()) this.validDates.set(true)
          else this.validDates.set(false);
      }
    })
  }

  onFind(){
    console.log(this.form)
    this.carService.getAllCars('', '', '', 0, 0, this.form.value.dataZaemane, this.form.value.dataVrushtane);
    this.router.navigate(["/", "cars"]);
  }
}
