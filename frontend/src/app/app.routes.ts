import { Routes } from '@angular/router';
import { CarsComponent } from './cars-component/cars-component';
import { HomePage } from './home-page/home-page';
import { LoginComponent } from './user/login-component/login-component';
import { RegisterComponent } from './user/register-component/register-component';
import { AddCarComponent } from './admin/add-car-component/add-car-component';
import { AdminDashboardComponent } from './admin/admin-dashboard-component/admin-dashboard-component';
import { UsersDashboardComponent } from './admin/dashboard/users-dashboard-component/users-dashboard-component';
import { CarsDashboardComponent } from './admin/dashboard/cars-dashboard-component/cars-dashboard-component';

export const routes: Routes = [
  { path: '', component: HomePage },
  { path: 'cars', component: CarsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'admin',
    component: AdminDashboardComponent,
    children: [
      { path: '', redirectTo:"cars", pathMatch:'full' },
      { path: 'cars', component:CarsDashboardComponent},
      { path: 'clients', component:UsersDashboardComponent}
    ],
  },
];
