import { Component, inject, signal } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RentsService } from '../../adminServices/rents-service';
import { CarsService } from '../../adminServices/cars-service';
import { UserService } from '../../adminServices/user-service';
import { debounceTime, startWith } from 'rxjs';
import { User } from '../../user/user-service';
import { Car } from '../../cars-component/cars-service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-edit-rent-component',
  imports: [ReactiveFormsModule],
  templateUrl: './edit-rent-component.html',
  styleUrl: './edit-rent-component.css',
})
export class EditRentComponent {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private carsService = inject(CarsService);
  private rentsService = inject(RentsService);
  private userService = inject(UserService);
  router = inject(Router);

  editRentalForm: FormGroup;

  allClients = this.userService.getUsers;
  allCars = this.carsService.getCars;

  isClientDropdownOpen = signal<boolean>(false);
  isCarDropdownOpen = signal<boolean>(false);

  filteredClients = signal<User[]>([]);
  filteredCars = signal<Car[]>([]);

  constructor() {
    this.editRentalForm = this.fb.group({
      clientSearch: [''],
      klient_ID: ['', Validators.required],
      carSearch: [''],
      avtomobil_id: ['', Validators.required],
      dataZaemane: ['', Validators.required],
      dataVrushtane: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.loadInitialData();

    this.setupSearchListeners();

    this.filteredClients.set([]);
    this.filteredCars.set([]);

    const rentId = this.route.snapshot.paramMap.get('rentId');
    if (rentId) {
      this.rentsService.fetchRent(Number(rentId)).subscribe({
        next: (rentData) => {
          console.log('Данни за наема:', rentData);
          this.editRentalForm.patchValue(
            {
              dataZaemane: formatDate(rentData.dataZaemane, 'yyyy-MM-dd', 'en-US'),
              dataVrushtane: formatDate(rentData.dataVrushtane, 'yyyy-MM-dd', 'en-US'),
              klient_ID: rentData.klient_ID,
              avtomobil_id: rentData.car.avtomobil_id,
            },
            { emitEvent: false },
          );

          const client = this.allClients().find((c) => c.klient_ID === rentData.klient_ID);
          const car = this.allCars().find((c) => c.avtomobil_id === rentData.car.avtomobil_id);

          if (client) {
            this.editRentalForm.patchValue({ clientSearch: client.email }, { emitEvent: false });
          }
          if (car) {
            this.editRentalForm.patchValue(
              { carSearch: `${car.marka_name} ${car.kolamodel}` },
              { emitEvent: false },
            );
          }
        },
        error: (err) => {
          console.error('Грешка при зареждане на наема:', err);
          this.router.navigate(['/admin/rents']);
        },
      });
    }
  }

  private loadInitialData() {
    this.userService.getAllUsers('');
    this.carsService.getAllCars('');
  }

  private setupSearchListeners() {
    this.editRentalForm
      .get('clientSearch')
      ?.valueChanges.pipe(startWith(''), debounceTime(200))
      .subscribe((value) => {
        const filterValue = value?.toLowerCase() || '';
        const results = this.allClients().filter((c) =>
          c.email.toLowerCase().includes(filterValue),
        );
        this.filteredClients.set(results);
      });

    this.editRentalForm
      .get('carSearch')
      ?.valueChanges.pipe(startWith(''), debounceTime(200))
      .subscribe((value) => {
        const filterValue = value?.toLowerCase() || '';
        const results = this.allCars().filter((c) =>
          (c.marka_name + ' ' + c.kolamodel).toLowerCase().includes(filterValue),
        );
        this.filteredCars.set(results);
      });
  }

 selectClient(client: any) {
    this.editRentalForm.patchValue({
      clientSearch: client.email,
      clientId: client.id
    }, { emitEvent: false }); 

    this.isClientDropdownOpen.set(false);
  }

  selectCar(car: any) {
    this.editRentalForm.patchValue({
      carSearch: `${car.marka_name} ${car.kolamodel}`,
      carId: car.avtomobil_id
    }, { emitEvent: false });

    this.isCarDropdownOpen.set(false);
  }

  hideClientDropdown() {
    setTimeout(() => this.isClientDropdownOpen.set(false), 200);
  }

  hideCarDropdown() {
    setTimeout(() => this.isCarDropdownOpen.set(false), 200);
  }

  onSubmit() {
    if (this.editRentalForm.valid) {
      console.log('Обновяване на наем:', this.editRentalForm.value);
      this.rentsService.updateRent({
        Id: Number(this.route.snapshot.paramMap.get('rentId')),
        avtomobil_id: this.editRentalForm.value.avtomobil_id,
        klient_ID: this.editRentalForm.value.klient_ID,
        dataZaemane: this.editRentalForm.value.dataZaemane,
        dataVrushtane: this.editRentalForm.value.dataVrushtane,
        broiDni: Math.ceil(
          (new Date(this.editRentalForm.value.dataVrushtane).getTime() -
            new Date(this.editRentalForm.value.dataZaemane).getTime()) /
            (1000 * 3600 * 24) + 1,
        ),
      });

      this.router.navigate(['/admin/rents']);
    }
  }
}
