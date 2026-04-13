import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { User } from '../user/user-service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor() {
    this.getAllUsers('');
  }
  private http = inject(HttpClient);
  private users = signal<User[]>([]);
  

  getAllUsers(ime: string) {
    console.log(ime);
    let url = 'http://localhost:8081/klient?';
    if (ime != '') url = url + '&name=' + ime;
    console.log(url);

    this.http.get<User[]>(url).subscribe({
      next: (users) => {
        this.users.set(users);
      },
    });
  }

  get getUsers() {
    return this.users.asReadonly();
  }


  fetchUser(id: number): Observable<User> {
    return this.http.get<User>(`http://localhost:8081/klient/${id}`);
  }

  
  updateUser(userData: User)
  {
    this.http.put(`http://localhost:8081/klient/${userData.klient_ID}`, userData).subscribe({
      next: (resData) => {
        console.log(resData);
        this.getAllUsers('');
      }
    });

  }

  deleteUser(id: number) {
    this.http.delete(`http://localhost:8081/klient/${id}`).subscribe({
      next: (resData) => {
        console.log(resData);
        this.getAllUsers('');
      },
    });
  }
}
