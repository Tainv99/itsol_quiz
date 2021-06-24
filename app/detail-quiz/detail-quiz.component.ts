import { Component, OnInit } from '@angular/core';
import { QuestionData } from '@app/_models/question-data';
import { QuestionService } from '@app/_services/question/question.service';
import { QuizService } from '@app/_services/quiz/quiz.service';
import { QuizData } from '../_models/quiz-data';
@Component({
  selector: 'app-detail-quiz',
  templateUrl: './detail-quiz.component.html',
  styleUrls: ['./detail-quiz.component.less']
})
export class DetailQuizComponent implements OnInit {
  quizz: QuizData;
  total?: number;
  isCheck?: boolean;
  totalCorrect?: number;
  time = 30;

  constructor(private quizService: QuizService,private questionService: QuestionService) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(): void {
    this.quizService.getDetailQuiz().subscribe(data => {
      this.quizz = data;
      this.total=this.quizz.questionDTO.length;
      console.log(this.total);
      
      // this.total = this.questions.length;
      // this.countdown();
    });
  }
}
