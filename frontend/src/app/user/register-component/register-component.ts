import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../user-service';

@Component({
  selector: 'app-register-component',
  imports: [ReactiveFormsModule],
  templateUrl: './register-component.html',
  styleUrl: './register-component.css',
})
export class RegisterComponent {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService) {
    this.registerForm = this.fb.group({
      ime: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      telefon: ['', Validators.required],
      
      address: this.fb.group({
        street: ['', Validators.required],
        city: ['', Validators.required],
        country: ['', Validators.required]
      })
    });
  }

  onSubmit(): void {

    if (this.registerForm.invalid) {
      return;
    }

    const registerData = this.registerForm.value;
    console.log('Данни за регистрация:', registerData);
    this.userService.registerUser(registerData).subscribe({
      next: (resData)=>{
        console.log(resData);
      }
    });
    this.registerForm.reset();
    
  }
}
