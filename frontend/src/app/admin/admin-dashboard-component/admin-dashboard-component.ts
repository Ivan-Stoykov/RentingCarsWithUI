import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CarsDashboardComponent } from "../dashboard/cars-dashboard-component/cars-dashboard-component";

@Component({
  selector: 'app-admin-dashboard-component',
  imports: [RouterModule, CarsDashboardComponent],
  templateUrl: './admin-dashboard-component.html',
  styleUrl: './admin-dashboard-component.css',
})
export class AdminDashboardComponent {
}
