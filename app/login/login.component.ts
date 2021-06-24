import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthenticationService } from '@app/_services';
import {Register} from '../_models/register';

@Component({
    templateUrl: 'login.component.html', 
    styleUrls: ['./login.componet.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    error = '';
    registerForm:Register;
    returnUrl: string;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        
    ) { 
        // login thành công
        this.registerForm = new Register();
        if (this.authenticationService.currentUserValue) { 
            this.router.navigate(['/quiz']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/quiz';
    }
    public register() : void{
        this.authenticationService.register(this.registerForm).subscribe(
          data => {
              console.log(data);
              
            alert("Đăng Ký Thành Công")
          },
          error => console.log(error));
        
      }
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe({
                next: () => {
                    // debugger;
                    const returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/quiz';
                    this.router.navigate([returnUrl]);
                },
                error: error => {
                    // debugger;
                    this.error = error;
                    this.loading = false;
                }
            });
            
    }
}
