import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
// import { fakeBackendProvider } from './_helpers';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { FormsModule } from '@angular/forms';
import { QuestionComponent } from './question/question.component';
import {CreateQuestionComponent} from './create-question/create-question.component';
import {DetailQuestionComponent} from './detail-question/detail-question.component';
import {ListQuestionComponent} from './list-question/list-question.component';
import {UpdateQuestionComponent} from './update-question/update-question.component';
import { QuizComponent } from './quiz_test/quiz/quiz.component';
import { DetailQuizComponent } from './detail-quiz/detail-quiz.component';
import { CreatQuizComponent } from './quiz_test/creat-quiz/creat-quiz.component';
import { ListQUComponent } from './list-qu/list-qu.component';;
import { DetailQuComponent } from './detail-qu/detail-qu.component';

@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule
    ],
    declarations: [
        AppComponent,
        HomeComponent,
        LoginComponent,
        QuestionComponent,
        ListQuestionComponent,
        UpdateQuestionComponent,
        CreateQuestionComponent,
        DetailQuestionComponent,
        QuizComponent,
        DetailQuizComponent ,
        CreatQuizComponent,
        ListQUComponent,
        DetailQuComponent
    ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    ],
    bootstrap: [AppComponent]
})
export class AppModule { }