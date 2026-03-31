import { Routes } from '@angular/router';
import { CarsComponent } from './cars-component/cars-component';
import { HomePage } from './home-page/home-page';

export const routes: Routes = [{path:"", component:HomePage},{ path: 'cars', component: CarsComponent }];
