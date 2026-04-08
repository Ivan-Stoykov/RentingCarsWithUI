import { Component, inject } from '@angular/core';
import { AdminService } from '../../admin-service';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-users-dashboard-component',
  imports: [ReactiveFormsModule],
  templateUrl: './users-dashboard-component.html',
  styleUrl: './users-dashboard-component.css',
})
export class UsersDashboardComponent {
  private adminService = inject(AdminService);
  users = this.adminService.getUsers;
  ime = new FormControl();

  filter(): void{
    this.adminService.getAllCars(this.ime.value)
    console.log(this.ime.value)
    console.log(this.users())
  }

  deleteUser(id: number): void {
    this.adminService.deleteUser(id);
  }
}
