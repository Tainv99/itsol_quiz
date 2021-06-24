import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {Anwser} from '../_models/anwser';
import {AnwserService} from '../_services/ans/anwser.service';
@Component({
  selector: 'app-anwser',
  templateUrl: './anwser.component.html',
  styleUrls: ['./anwser.component.css']
})
export class AnwserComponent implements OnInit {
  ans: Observable<Anwser[]>;

  constructor(private ansService: AnwserService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.ans = this.ansService.getAns();
  }

}
