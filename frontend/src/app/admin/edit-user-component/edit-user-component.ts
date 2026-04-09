import { Component, inject, input, OnInit } from '@angular/core';
import { AdminService } from '../admin-service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-user-component',
  imports: [ReactiveFormsModule],
  templateUrl: './edit-user-component.html',
  styleUrl: './edit-user-component.css',
})
export class EditUserComponent {
  id = input.required<number>();
  private adminService = inject(AdminService);
  editUser: FormGroup;
  constructor(private fb: FormBuilder) {
    
    this.editUser = this.fb.group({
      ime: [''],
      telefon: [''],
      email: [''],
      rolq: [''],
      ulica: [''],
      grad: [''],
      durjava: [''],
    });
  }

  

  

  onSubmit() {
  }
}
