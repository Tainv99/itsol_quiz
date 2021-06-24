import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizData } from '@app/_models/quiz-data';
import { QuizService } from '@app/_services/quiz/quiz.service';
import { QuizUser } from '../_models/QuizUser';
import { QuizUserService } from '../_services/quiz_user/quiz-user.service';
@Component({
  selector: 'app-list-qu',
  templateUrl: './list-qu.component.html',
  styleUrls: ['./list-qu.component.less']
})
export class ListQUComponent implements OnInit {
  qu: QuizUser;
  quizs: QuizData;
  constructor(
    private QUService: QuizUserService,
    private router: Router,
    private quizService: QuizService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(): void {
    this.quizService.getQuiz().subscribe(data => {
      this.quizs = data;
    });
  }
  getDetails(id: number) {
    this.router.navigate(['detail', id]);
  }
}
