import { Component } from '@angular/core';
import { first } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

import { User } from '@app/_models';
// import { UserService } from '@app/_services';

@Component({
    templateUrl: 'home.component.html' ,  
    styleUrls: ['home.component.css']})
export class HomeComponent {
    results;
    constructor(private http: HttpClient) { }
    ngOnInit() {
        this.http.get(`http://5ca73f798e58df0014602f37.mockapi.io/products`).subscribe(data => {
            console.log(data);
            this.results = data;
        });
    }
}