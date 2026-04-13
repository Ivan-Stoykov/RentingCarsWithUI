import { Component, inject, signal } from '@angular/core';
import { User, UserService } from '../../user/user-service';
import { CommonModule } from '@angular/common';
import { Rent } from '../../adminServices/rents-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile-component',
  imports: [CommonModule],
  templateUrl: './user-profile-component.html',
  styleUrl: './user-profile-component.css',
})
export class UserProfileComponent {
  private userService = inject(UserService);
  private router = inject(Router);

  user = this.userService.getUser();;
  rentals = signal<Rent[]>([]);

  ngOnInit(): void {
    if (this.user().klient_ID === 0) {
      this.router.navigate(['/login']);
      return;
    }
    this.loadRentalHistory();
  }

  private loadRentalHistory() {

    this.userService.fetchRents(this.user().klient_ID).subscribe({
      next: (resData) => {
        console.log('История на наеми:', resData);
        this.rentals.set(resData);
      },
      error: (err) => console.error('Грешка при зареждане на историята на наеми:', err),
    });
  }
}