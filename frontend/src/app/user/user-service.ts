import { HttpClient } from '@angular/common/http';
import { inject, Injectable, Signal, signal } from '@angular/core';
import { Router } from '@angular/router';

export interface User {
  id: number;
  ime: string;
  email: string;
  telefon: string;
  address: {
    street: string;
    city: string;
    country: string;
  };
}

export interface registerUser {
  ime: string;
  email: string;
  password: string;
  telefon: string;
  address: {
    street: string;
    city: string;
    country: string;
  };
}

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private http = inject(HttpClient);
  private router = inject(Router);

  private startUser = {
    id: 0,
    ime: '',
    email: '',
    telefon: '',
    address: {
      street: '',
      city: '',
      country: '',
    },
  };

  private user = signal<User>(this.startUser);

  public loginUser(email: string, password: string) {
    this.http.post<User>('http://localhost:8081/klient/login', { email, password }).subscribe({
      next: (resData) => {
        console.log(resData);
        localStorage.setItem('User', JSON.stringify(resData));
        this.user.set(resData);
        this.router.navigate(['/', 'cars']);
      },
    });
  }

  public registerUser(user: registerUser) {
    this.http.post<User>('http://localhost:8081/klient/register', { user }).subscribe({
      next: (resData) => {
        console.log(resData);
        localStorage.setItem('User', JSON.stringify(resData));
        this.user.set(resData);
        this.router.navigate(['/', 'cars']);
      },
    });
  }

  public getUser(): Signal<User> {
    if (localStorage.getItem('User')) {
      this.user.set(JSON.parse(localStorage.getItem('User')!));
    }
    return this.user.asReadonly();
  }

  public LogOut() {
    localStorage.removeItem('User');
    this.user.set(this.startUser);
    this.router.navigate(['/', 'login']);
  }
}
