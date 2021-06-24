import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../_services/quiz/quiz.service';
import { QuizData } from '@app/_models/quiz-data';
@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.less']
})
export class QuizComponent implements OnInit {
  quizs: QuizData;
  id: number;
  constructor(private quizService: QuizService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(): void {
    this.quizService.getQuiz().subscribe(data => {
      this.quizs = data;      
    });
  }

  getcompanyid(company: any) {
    console.log('Selected Company: ', company);

  }
}
