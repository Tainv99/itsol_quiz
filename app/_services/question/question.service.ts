import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { QuestionData } from '@app/_models/question-data';
import { Observable } from 'rxjs';
import {QuestionDataModel} from '@app/_models/question-data.model';


@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private baseUrl = 'http://localhost:8080/api/v1/question';
  private Url = 'http://localhost:8080/api/v1/ans';
  
  
  constructor(private http: HttpClient) { }
  // getOrderDetail(): Observable<any> {
  //   return this.http.get(`${this.baseUrl}/1`);
  // }
  getQuestion(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  save(data: QuestionData[]): Observable<QuestionDataModel> {
    return this.http.post<QuestionDataModel>(`${this.baseUrl}/test`, data);
  }
  createQuestion(question: Object,idQuiz:number): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${idQuiz}`, question);
  }
  createAns(ans: Object): Observable<Object> {
    return this.http.post(`${this.Url}`, ans);
  }
  deleteQuestion(id: number): Observable<any> {
    return this.http.delete(`http://localhost:8080/api/v1/question/${id}`, { responseType: 'text' });
  }
  getQuestionAnwserById(id: number): Observable<any> {
    return this.http.get(`http://localhost:8080/api/v1/question/info/${id}`);
  }
  updateQuestion(id:number,value: any): Observable<Object> {
    return this.http.put(`http://localhost:8080/api/v1/question/update/${id}`, value);
  }
  getAllQuestionByQuiz(quizId: number): Observable<QuestionData[]> {
    return this.http.get<QuestionData[]>(`http://localhost:8080/api/v1/quiz/list/` + quizId);
  }
}
