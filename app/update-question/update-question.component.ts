import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Anwser } from '../_models/anwser';
import { Question } from '../_models/question';
import { QuestionService } from '../_services/question/question.service';

@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.css']
})
export class UpdateQuestionComponent implements OnInit {
  myQuestionObjData: any;
  question: Question = new Question();
  //question:QuestionData[];
  idQ: number;
  id: number;
  submitted = false;
  // ans: Anwser = new Anwser('',this.idQ);
  ans: Anwser[];

  questionForm: FormGroup = this.fb.group({
    text: new FormControl('', []),
    answerList: this.fb.array([]),
  });

  constructor(
    private questionService: QuestionService,
    private fb: FormBuilder,
    private route: ActivatedRoute
  ) { }


  ngOnInit() {
    this.id = this.route.snapshot.params['id'];

    this.questionService.getQuestionAnwserById(this.id).subscribe(
      data => {
        // debugger;
        this.myQuestionObjData = data
        console.log(data);
        this.patchValueObjToForm();

      }, error => console.log(error));
  }

  updateQuestion() {
    this.questionService.updateQuestion(this.id, this.questionForm.value)
      .subscribe(data => {
        console.log(data);
      }, error => console.log(error));
  }
  onSubmit() {
    this.submitted = true;
    this.updateQuestion();
  }
  patchValueObjToForm() {
    // debugger;
    // Cau hoi
    this.questionForm.patchValue({ text: this.myQuestionObjData.text });

    // DS cau tra loi answersDTOList
    const control = <FormArray>this.questionForm.get('answerList');
    this.myQuestionObjData.answerList.forEach(x => {
      control.push(this.patchAnswersDTOListValue(x.textanwser, x.id));
    });
  }

  patchAnswersDTOListValue(textanwser, id) {
    return this.fb.group({
      textanwser: [textanwser],
      id: [id]
    });
  }
}
