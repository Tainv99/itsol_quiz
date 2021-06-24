import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizUser } from '@app/_models/QuizUser';
import { QuizUserService } from '@app/_services/quiz_user/quiz-user.service';

@Component({
  selector: 'app-detail-qu',
  templateUrl: './detail-qu.component.html',
  styleUrls: ['./detail-qu.component.less']
})
export class DetailQuComponent implements OnInit {
id:number;
qu:QuizUser;
  constructor(private route: ActivatedRoute,
    private quService: QuizUserService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    
    this.quService.getDetail(this.id)
      .subscribe(data => {
        console.log(data)
        this.qu = data;
      }, error => console.log(error));
  }

}
