import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Anwser } from '../_models/anwser';
import { Question } from '../_models/question';
import { QuestionService } from '../_services/question/question.service';
import {
  Validators,
  FormControl
} from '@angular/forms';
import { QuizData } from '@app/_models/quiz-data';
import { QuizService } from '@app/_services/quiz/quiz.service';
@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {
  quizs: QuizData;
  questionForm: FormGroup;
  myQuestionObjData: any;
  question: Question = new Question();
  idQ: string;
  numberValue:number;
  submitted = false;
  // ans: Anwser = new Anwser('',this.idQ);
  ans:Anwser[];
  constructor(private questionService: QuestionService,private fb: FormBuilder,private quizService: QuizService) { }
  ngOnInit() {
    this.myQuestionObjData = {
      text: '',
      answerList: [
        {
          textanwser: '',
          trueOrFalse:''
        },
        {
          textnwser: '',
          trueOrFalse:''
        },
        {
          textnwser: '',
          trueOrFalse:''
        },
        {
          textnwser: '',
          trueOrFalse:''
        }
      ]
    };

    this.questionForm = this.fb.group({
      text: new FormControl('', []),
      answerList: this.fb.array([]),
    });

    this.patchValueObjToForm();
    this.quizService.getQuiz().subscribe(data => {
      this.quizs = data;
    });
  }
  getcompanyid(company: any) {
    console.log('Selected Company: ', company);
    localStorage.setItem("idquiz",company);
  }
  save() {
    this.idQ=localStorage.getItem("idquiz");
    this.numberValue = Number(this.idQ);
    this.questionService
      .createQuestion(this.questionForm.value,this.numberValue).subscribe(data => { 
      });
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  patchValueObjToForm() {
    // Cau hoi
    this.questionForm.patchValue({ text: this.myQuestionObjData.text });

    // DS cau tra loi answersDTOList
    const control = <FormArray>this.questionForm.get('answerList');
    this.myQuestionObjData.answerList.forEach(x => {
      control.push(this.patchAnswersDTOListValue(x.textanwser,x.trueOrFalse));
    });
  }

  patchAnswersDTOListValue(textanwser, trueOrFalse) {
    return this.fb.group({
      textanwser: [textanwser],
      trueOrFalse: [trueOrFalse]

    });
  }
}
