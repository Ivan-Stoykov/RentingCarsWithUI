import { Component, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from "@angular/router";
import { UserService } from '../../adminServices/user-service';

@Component({
  selector: 'app-users-dashboard-component',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './users-dashboard-component.html',
  styleUrl: './users-dashboard-component.css',
})
export class UsersDashboardComponent {
  private userService = inject(UserService);
  users = this.userService.getUsers;
  ime = new FormControl('');

  filter(): void{
    this.userService.getAllUsers(this.ime.value!)
    console.log(this.ime.value)
    console.log(this.users())
  }

  deleteUser(id: number): void {
    this.userService.deleteUser(id);
  }
}
