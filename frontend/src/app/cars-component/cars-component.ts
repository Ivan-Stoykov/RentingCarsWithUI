import { Component, inject, OnInit, Signal, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CarService } from './cars-service';

@Component({
  selector: 'app-cars',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
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
      filters.marka_name,
      filters.kolamodel,
      filters.vid,
      filters.cvqt,
      filters.cena_za_den,
      filters.godina,
      filters.dataZaemane,
      filters.dataVrushtane
    )
  }
}
