import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import {Question} from '../_models/question';
import {QuestionService} from '../_services/question/question.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-detail-question',
  templateUrl: './detail-question.component.html',
  styleUrls: ['./detail-question.component.css']
})
export class DetailQuestionComponent implements OnInit {
    results;
    constructor(private http: HttpClient) { }
    ngOnInit() {
        this.http.get("http://localhost:8080/api/v1/question/getQuesInfoById/1").subscribe(data => {
            this.results = data;
            console.log(data);
        });
    }

}
