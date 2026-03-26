import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Car, CarModel, CarService } from './cars-service';
import { forkJoin } from 'rxjs';



@Component({
  selector: 'app-cars',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './cars-component.html',
  styleUrls: ['./cars-component.css']
})
export class CarsComponent implements OnInit {
  filterForm: FormGroup;

  allCars: Car[] = [];
  allBrands: string[] = [];
  allColors: string[] = [];
  allTypes: string[] = [];
  allModels: string[] = [];
  carModels: CarModel[] = [];

  filteredCars = signal<Car[] | undefined>(undefined);

  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private carService: CarService) {
    this.filterForm = this.fb.group({
      marka_name: [''],
      kolamodel: [{value: '', disabled:true}],
      cena_za_den: [300],
      vid: [''],
      cvqt: [''],
      godina: ['']
    });
  }

  ngOnInit(): void {
    this.loadInitialData();
    this.setupBrandListener();
  }

  private loadInitialData(): void {
    this.isLoading = true;

    forkJoin({
      cars: this.carService.getAllCars(),
      brands: this.carService.getBrands(),
      colors: this.carService.getColors(),
      types: this.carService.getTypes(),
      models: this.carService.getModels()
    }).subscribe({
      next: (result) => {
        this.allCars = result.cars;
        this.filteredCars.set([...this.allCars]);
        console.log(this.filteredCars())
        
        this.allBrands = result.brands;
        this.allColors = result.colors;
        this.allTypes = result.types;
        this.carModels = result.models
        this.allModels = this.carModels.map(m => m.model);
        
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Грешка при зареждане на данните:', error);
        this.errorMessage = 'Възникна грешка при връзката със сървъра.';
        this.isLoading = false;
      }
    });
  }

  private setupBrandListener(): void {
    this.filterForm.get('marka_name')?.valueChanges.subscribe(selectedBrand => {
      const modelControl = this.filterForm.get('kolamodel');
      this.filterForm.get('kolamodel')?.setValue('');

      if (selectedBrand) {
        modelControl?.enable();
        this.allModels = this.carModels
          .filter(m => m.marka === selectedBrand)
          .map(m => m.model);
      } else {
        modelControl?.disable();
        this.allModels = this.carModels.map(m => m.model);
      }
    });
  }

  onFind(): void {
    const filters = this.filterForm.getRawValue();

    this.filteredCars .set(this.allCars.filter(car => {
      const matchBrand = filters.marka_name ? car.marka_name === filters.marka_name : true;
      const matchModel = filters.kolamodel ? car.kolamodel === filters.kolamodel : true;
      const matchPrice = car.cena_za_den <= filters.cena_za_den;
      const matchType = filters.vid ? car.vid === filters.vid : true;
      const matchColor = filters.cvqt ? car.cvqt === filters.cvqt : true;
      const matchYear = filters.godina ? car.godina >= filters.godina : true;

      return matchBrand && matchModel && matchPrice && matchType && matchColor && matchYear;
    }));
  }
}