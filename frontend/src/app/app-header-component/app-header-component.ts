import { Component, computed, inject } from '@angular/core';
import { RouterLink } from "@angular/router";
import { UserService } from '../user/user-service';

@Component({
  selector: 'app-app-header-component',
  imports: [RouterLink],
  templateUrl: './app-header-component.html',
  styleUrl: './app-header-component.css',
})
export class AppHeaderComponent {
  private userService = inject(UserService);
  user = this.userService.getUser();

  LogOut()
  {
    this.userService.LogOut();
  }
}
