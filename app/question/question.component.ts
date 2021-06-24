import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Question} from '../_models/question';
import { Observable } from 'rxjs';
import {QuestionService} from '../_services/question/question.service';
import { ActivatedRoute, Router } from '@angular/router';
import {QuestionData} from '../_models/question-data';
// import {UserService} from '../_services/user/user.service';
@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  
  questions?: QuestionData[];
  total?: number;
  isCheck?: boolean;
  totalCorrect?: number;
  quizId?: number;


  constructor(private questionService: QuestionService, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.quizId = params.id;
      console.log(this.quizId);
      
    });
    this.reloadData();
  }

  //
  reloadData(): void {
    this.questionService.getAllQuestionByQuiz(this.quizId).subscribe(data => {
      this.questions = data;
      this.total = this.questions.length;
      // this.countdown();
    });
  }
  checkAnswer(questionId: number, answerId: number, checked: any): void {
    this.questions.forEach(question => {
      if (question.id === questionId) {
        question.answerList.forEach(answer => {
          if (answer.id === answerId && checked) {
            answer.checked = true;
          } else {
            answer.checked = false;
          }
        });
      }
    });
    let total = 0;
    this.questions.forEach(question => {
      question.answerList.forEach(answer => {
        if (answer.checked) {
          total++;
        }
      });
    });
    if ( total === this.total) {
         this.isCheck = true;
       }
    else {
      this.isCheck = false;
    }
  }

  save(): void {
    this.questionService.save(this.questions).subscribe(data => {
      this.questions = data.questions;
      this.totalCorrect = data.total;
    });
    
  }
}
