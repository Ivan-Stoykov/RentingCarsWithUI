import { Routes } from '@angular/router';
import { CarsComponent } from './cars-component/cars-component';
import { HomePage } from './home-page/home-page';
import { LoginComponent } from './user/login-component/login-component';
import { RegisterComponent } from './user/register-component/register-component';
import { AddCarComponent } from './admin/add-car-component/add-car-component';
import { AdminDashboardComponent } from './admin/admin-dashboard-component/admin-dashboard-component';
import { UsersDashboardComponent } from './admin/dashboard/users-dashboard-component/users-dashboard-component';
import { CarsDashboardComponent } from './admin/dashboard/cars-dashboard-component/cars-dashboard-component';
import { EditUserComponent } from './admin/edit-user-component/edit-user-component';
import { EditCarComponent } from './admin/edit-car-component/edit-car-component';
import { RentsDashboardComponent } from './admin/dashboard/rents-dashboard-component/rents-dashboard-component';
import { CarDetailsComponent } from './pages/car-details-component/car-details-component';
import { UserProfileComponent } from './pages/user-profile-component/user-profile-component';
import { EditRentComponent } from './admin/edit-rent-component/edit-rent-component';
import { OtdavaneDashboardComponent } from './admin/dashboard/otdavane-dashboard-component/otdavane-dashboard-component';

export const routes: Routes = [
  { path: '', component: HomePage },
  { path: 'cars', component: CarsComponent },
  { path: 'cars/:carId', component: CarDetailsComponent },
  { path: 'user', component: UserProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'admin',
    component: AdminDashboardComponent,
    children: [
      { path: '', redirectTo:"cars", pathMatch:'full' },
      { path: 'cars', component:CarsDashboardComponent},
      { path: 'cars/add', component:AddCarComponent},
      { path: 'cars/:carId', component:EditCarComponent},
      { path: 'clients', component:UsersDashboardComponent},
      { path: 'clients/:userId', component:EditUserComponent},
      { path: 'rents', component:RentsDashboardComponent},
      { path: 'rents/:rentId', component:EditRentComponent},
      { path: 'otdavane', component:OtdavaneDashboardComponent},
    ],
  },
];
