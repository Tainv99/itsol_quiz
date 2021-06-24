import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '@environments/environment';
import { User } from '@app/_models';
import {observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {
        return this.http.post<any>(`${environment.apiUrl}/login`, { username, password })
            .pipe(map(jwtToken => {
                let us: User = {
                    token: jwtToken.idToken
                   
                };
                localStorage.setItem('username', jwtToken.username);
                // console.log(this.currentUserValue))
                
                this.currentUserSubject.next(us);
                return us;
            }));
    }
    public register(data : any):Observable<any>{
        return this.http.post('http://localhost:8080/api/v1/register', data,
          {observe:"body"})
          .pipe(catchError(err => throwError(err)));
      }
    logout() {
        // remove user from local storage to log user out
        localStorage.clear();
        this.currentUserSubject.next(null);
    }
}