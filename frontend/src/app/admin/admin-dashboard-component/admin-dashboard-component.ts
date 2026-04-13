import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { UserService } from '../../user/user-service';


@Component({
  selector: 'app-admin-dashboard-component',
  imports: [RouterModule],
  templateUrl: './admin-dashboard-component.html',
  styleUrl: './admin-dashboard-component.css',
})
export class AdminDashboardComponent implements OnInit {

  private userService = inject(UserService);
  private router = inject(Router);

  ngOnInit(): void {
    const user = this.userService.getUser();
    if ( user().rolq !== 'admin') {
      this.router.navigate(['/']);
    }
  }
}
