import { Component, inject, OnInit, Signal, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CarService } from './cars-service';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-cars',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './cars-component.html',
  styleUrls: ['./cars-component.css'],
})
export class CarsComponent implements OnInit {
  filterForm: FormGroup;
  private carService = inject(CarService);

  allBrands = this.carService.getBrands();
  allColors = this.carService.getColors();
  allTypes = this.carService.getTypes();
  carModels = this.carService.getModels();
  allModels = this.carModels().map(m => m.model);

  validDates = signal<boolean | null>(null);
  
  cars = this.carService.getCars;
  
  constructor(
    private fb: FormBuilder,
  ) {
    this.filterForm = this.fb.group({
      dataZaemane: [this.carService.getDataZaemane()],
      dataVrushtane:[this.carService.getDataVrushtane()],
      marka_name: [''],
      kolamodel: [{ value: '', disabled: true }],
      cena_za_den: [300],
      vid: [''],
      cvqt: [''],
      godina: [''],
    });
  }
  
  ngOnInit(): void {
    this.setupBrandListener();
    this.setupDateListener();
  }
  
  private setupDateListener(): void {
    this.filterForm.get('dataVrushtane')?.valueChanges.subscribe((date) => {
      const dataZaemane = this.filterForm.get('dataZaemane')?.value;
      if(dataZaemane != ''){
        const zaemane = new Date(dataZaemane);
        const vrushtane = new Date(date);
        if(zaemane.getDate() <= vrushtane.getDate()) this.validDates.set(true)
          else this.validDates.set(false);
      }
    })
  }
  

  private setupBrandListener(): void {
    this.filterForm.get('marka_name')?.valueChanges.subscribe((selectedBrand) => {
      const modelControl = this.filterForm.get('kolamodel');
      this.filterForm.get('kolamodel')?.setValue('');

      if (selectedBrand) {
        modelControl?.enable();
        this.allModels = this.carModels()
          .filter((m) => m.marka === selectedBrand)
          .map((m) => m.model);
      } else {
        modelControl?.disable();
        this.allModels = this.carModels().map((m) => m.model);
      }
    });
  }

  onFind(): void {
    const filters = this.filterForm.getRawValue();
    this.carService.getAllCars(
      filters.marka_name + ' ' + filters.kolamodel,
      filters.vid,
      filters.cvqt,
      filters.cena_za_den,
      filters.godina,
      filters.dataZaemane,
      filters.dataVrushtane
    )
  }
}
