import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private baseUrl = 'http://localhost:8080/api/v1/quiz';
  constructor(private http: HttpClient) { }
  getQuiz(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  };
  getDetailQuiz():Observable<any>{
    return this.http.get(`http://localhost:8080/api/v1/quiz/1`);
  }
  createQuiz(quiz: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, quiz);
  }
}
