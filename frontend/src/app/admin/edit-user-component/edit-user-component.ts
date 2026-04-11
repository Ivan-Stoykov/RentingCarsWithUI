import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../adminServices/user-service';

@Component({
  selector: 'app-edit-user-component',
  imports: [ReactiveFormsModule],
  templateUrl: './edit-user-component.html',
  styleUrl: './edit-user-component.css',
})
export class EditUserComponent {
  editUser: FormGroup;
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private userService = inject(UserService);
  constructor(private fb: FormBuilder) {
    this.editUser = this.fb.group({
      ime: [''],
      telefon: [''],
      email: [''],
      rolq: [''],
      address: this.fb.group({ street: [''], city: [''], country: [''] }),
    });
  }

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('userId');

    if (userId) {
      this.userService.fetchUser(Number(userId)).subscribe({
        next: (userData) => {
          console.log(userData);
          this.editUser.patchValue({
            ime: userData.ime,
            telefon: userData.telefon,
            email: userData.email,
            rolq: userData.rolq,
            address: {
              street: userData.address.street,
              city: userData.address.city,
              country: userData.address.country,
            },
          });
        },
        error: (err) => {
          console.error('Грешка при зареждане на потребителя:', err);
          this.router.navigate(['/admin/clients']);
        },
      });
    }
  }

  onSubmit(): void {
    if (this.editUser.valid) {
      const updatedData = this.editUser.value;
      const userId = this.route.snapshot.paramMap.get('userId');

      this.userService.updateUser({ ...updatedData, klient_ID: Number(userId) });
      console.log('Потребителят е успешно обновен!');
      this.router.navigate(['/admin/clients']);
    }
  }
}
