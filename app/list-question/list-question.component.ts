import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuestionData } from '../_models/question-data';
import { QuestionService } from '../_services/question/question.service';

@Component({
  selector: 'app-list-question',
  templateUrl: './list-question.component.html',
  styleUrls: ['./list-question.component.css']
})
export class ListQuestionComponent implements OnInit {
  questions?: QuestionData[];

  constructor(private questionService: QuestionService,private router: Router) { }

  ngOnInit(): void {
    this.reloadData();

  }
  reloadData(): void {
    this.questionService.getQuestion().subscribe(data => {
      this.questions = data;
      // this.countdown();
  });
  }
  deleteQuestion(id: number) {
    this.questionService.deleteQuestion(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  updateQuestion(id: number){
    this.router.navigate(['update', id]);
    console.log(id);
    
  }
}
