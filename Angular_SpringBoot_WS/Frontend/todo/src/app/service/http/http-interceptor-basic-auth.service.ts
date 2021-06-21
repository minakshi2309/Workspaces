import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor {

  constructor(
    private basicAuthService: BasicAuthenticationService
  ) { }
  intercept(request: HttpRequest<any>, next: HttpHandler){
    // let username = 'angular'
    // let password = 'password'
    //let basicAuthHeaderString = 'Basic '+window.btoa(username+':'+password)

    let basicAuthHeaderString = this.basicAuthService.getAuthenticatedToken()
    let username = this.basicAuthService.getAuthenticatedUSer()

    if(basicAuthHeaderString && username) {
      request = request.clone({
        setHeaders : {
          Authorization : basicAuthHeaderString
        }
      })
    }

    return next.handle(request);
  }
}