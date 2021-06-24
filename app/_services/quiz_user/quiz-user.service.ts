import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizUserService {
  private baseUrl = 'http://localhost:8080/api/v1/qt';

  constructor(private http: HttpClient) { }
  getQuizUser(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  };
  getDetail(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getmark/${id}`);
  }
}
