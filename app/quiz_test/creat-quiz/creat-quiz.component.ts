import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Quiz} from '../../_models/quiz';
import {QuizService} from '../../_services/quiz/quiz.service';
@Component({
  selector: 'app-creat-quiz',
  templateUrl: './creat-quiz.component.html',
  styleUrls: ['./creat-quiz.component.less']
})
export class CreatQuizComponent implements OnInit {


  quiz: Quiz = new Quiz();
  submitted = false;

  constructor(private quizService: QuizService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.quiz = new Quiz();
  }

  save() {
    this.quizService
    .createQuiz(this.quiz).subscribe(data => {
      console.log(data)
      this.quiz = new Quiz();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }
}
