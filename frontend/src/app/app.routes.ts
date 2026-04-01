import { Routes } from '@angular/router';
import { CarsComponent } from './cars-component/cars-component';
import { HomePage } from './home-page/home-page';
import { LoginComponent } from './user/login-component/login-component';
import { RegisterComponent } from './user/register-component/register-component';

export const routes: Routes = [
  { path: '', component: HomePage },
  { path: 'cars', component: CarsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent}
];
