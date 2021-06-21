import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'angular'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidCredentials = false

  constructor(
    private router: Router, 
    private hardcodedAuthentication: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService
     ) { }

  ngOnInit(): void {
  }

  handleLogin(){
    //console.log(this.username)
    //this.invalidCredentials = !(this.username === 'angular' && this.password === 'password')
    this.invalidCredentials = this.hardcodedAuthentication.authenticate(this.username, this.password)
    if(!this.invalidCredentials){
      this.router.navigate(['welcome',this.username])
    }
    //console.log('invalidCredentials value  '+this.invalidCredentials)
  }

  handleBasicAuthLogin(){
    this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
    .subscribe(
      data => {
        console.log(data)
        this.router.navigate(['welcome', this.username])
        this.invalidCredentials = false
      },
      error => {
        console.log(error)
        this.invalidCredentials = true
      }
    )
    
  }

}
