import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnwserService {
  private baseUrl = 'http://localhost:8080/api/v1/ans/';
  constructor(private http: HttpClient) { }
  getAns(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
