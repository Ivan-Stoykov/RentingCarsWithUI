import { Component, inject, signal } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Car, CarService } from '../../cars-component/cars-service';
import { CurrencyPipe } from '@angular/common';
import { debounceTime, filter, switchMap, tap } from 'rxjs';
import { of } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { User, UserService } from '../../user/user-service';

@Component({
  selector: 'app-car-details-component',
  imports: [ReactiveFormsModule, CurrencyPipe],
  templateUrl: './car-details-component.html',
  styleUrl: './car-details-component.css',
})
export class CarDetailsComponent {
  private route = inject(ActivatedRoute);
  private fb = inject(FormBuilder);
  private carService = inject(CarService);
  private userService = inject(UserService);
  user = this.userService.getUser();
  message = signal<{type: string; text: string}>({type: '', text: ''});

  car = signal<Car | null>(null);
  rentalForm: FormGroup;

  totalPrice = signal<number>(0);
  isAvailable = signal<boolean>(false);
  isChecking = signal<boolean>(false);

  constructor() {
    this.rentalForm = this.fb.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('carId');
    this.carService.fetchCar(Number(id)).subscribe({
      next: (carData) => this.car.set(carData),
      error: (err) => console.error('Грешка при зареждане на колата:', err),
    });

    this.setupDateListener();
  }

  private setupDateListener(): void {
    this.rentalForm.valueChanges
      .pipe(
        debounceTime(500),
        filter((form) => !!form.startDate && !!form.endDate),
        tap((form) => this.calculatePrice(form.startDate, form.endDate)),
        tap(() => this.isChecking.set(true)),
        switchMap((form) => {
          const carId = this.car()?.avtomobil_id;
          if (!carId) return of(false);

          console.log(
            'Проверка на наличност за кола',
            carId,
            'от',
            form.startDate,
            'до',
            form.endDate,
          );
          return this.carService.checkAvailability(carId, form.startDate, form.endDate);
        }),
      )
      .subscribe({
        next: (available: boolean) => {
          this.isAvailable.set(available);
          this.isChecking.set(false);
        },
        error: (err) => {
          console.error('Грешка при проверка:', err);
          this.isAvailable.set(false);
          this.isChecking.set(false);
        },
      });
  }

  private calculatePrice(start: string, end: string): void {
    const startDate = new Date(start);
    const endDate = new Date(end);

    const diffTime = endDate.getTime() - startDate.getTime();
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)) + 1;

    if (diffDays > 0) {
      const dailyPrice = this.car()?.cena_za_den || 0;
      this.totalPrice.set(diffDays * dailyPrice);
    } else {
      this.totalPrice.set(0);
    }
  }

  onRent(): void {
    if (this.rentalForm.valid && this.isAvailable() === true) {
      console.log('Изпращане на резервация...');

      this.carService.rentCar(
        this.car()!.avtomobil_id,
        this.user().klient_ID,
        this.rentalForm.value.startDate,
        this.rentalForm.value.endDate,
        Math.ceil(
          (new Date(this.rentalForm.value.endDate).getTime() -
            new Date(this.rentalForm.value.startDate).getTime()) /
            (1000 * 60 * 60 * 24),
        ) + 1,
        this.totalPrice()
      ).subscribe({
        next: (res) => {
          console.log('Резервацията е успешна:', res);
          this.message.set({type: 'success', text: 'Успешно наехте колата!'});
        },
        error: (err) => {
          console.error('Грешка при резервация:', err);
          this.message.set({type: 'error', text: 'Възникна грешка при наемането. Моля, опитайте отново.'});
        },
      });
    }
  }
}
