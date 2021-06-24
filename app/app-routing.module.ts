import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { AuthGuard } from './_helpers';
import { QuestionComponent } from './question/question.component'
import { ListQuestionComponent } from './list-question/list-question.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { AnwserComponent } from './anwser/anwser.component'
import { QuizComponent } from './quiz_test/quiz/quiz.component';
import { DetailQuestionComponent } from './detail-question/detail-question.component';
import { DetailQuizComponent } from './detail-quiz/detail-quiz.component';
import { CreatQuizComponent } from './quiz_test/creat-quiz/creat-quiz.component';
import {ListQUComponent} from './list-qu/list-qu.component';
import { DetailQuComponent } from './detail-qu/detail-qu.component';
const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'question/:id', component: QuestionComponent, canActivate: [AuthGuard] },
    { path: 'list-question', component: ListQuestionComponent, canActivate: [AuthGuard] },
    { path: 'update/:id', component: UpdateQuestionComponent },
    { path: 'create', component: CreateQuestionComponent, canActivate: [AuthGuard] },
    { path: 'ans', component: AnwserComponent },
    { path: 'quiz', component: QuizComponent, canActivate: [AuthGuard] },
    { path: 'quiz-detail', component: DetailQuizComponent, canActivate: [AuthGuard] },
    { path: 'create-quiz', component: CreatQuizComponent, canActivate: [AuthGuard] },
    { path: 'list-qu', component: ListQUComponent, canActivate: [AuthGuard] },
    { path: 'detail/:id', component: DetailQuComponent },
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
