import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface User{
  id: number,
  ime:string,
  email:string,
  telefon:string,
  address: {
    street: string,
    city: string,
    country: string
  }
}

export interface registerUser{
  ime:string,
  email:string,
  password:string,
  telefon:string,
  address: {
    street: string,
    city: string,
    country: string
  }
}

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private http = inject(HttpClient);

  public getUser(email:string, password:string):Observable<User>
  {
    return this.http.post<User>('http://localhost:8081/klient/login', {email, password});
  }

  public registerUser(user: registerUser) : Observable<User>
  {
    return this.http.post<User>('http://localhost:8081/klient/register', {user});
  }
}
