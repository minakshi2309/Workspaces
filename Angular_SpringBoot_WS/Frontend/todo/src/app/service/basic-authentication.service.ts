import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { API_URL } from '../app.constants';

export const TOKEN = 'token'
export const AUTHENTICATEDUSER = 'authenticatedUser'

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(
    private http: HttpClient,
  ) { }

  // authenticate(username: string, password: string) {
  //   //return !(username === 'angular' && password === 'password')
  //   //console.log('username & pwd: '+username+' '+password)
  //   if(username === 'angular' && password === 'password'){
  //     //console.log('username & pwd: '+'in if condition')
  //     sessionStorage.setItem('authenticatedUser', username)
  //     return false;
  //   }

  //   return true;
  // }

  executeAuthenticationService(username: string, password: string) {
    let basicAuthHeaderString = 'Basic '+window.btoa(username+':'+password)

    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })

    return this.http.get<AuthenticationBean>(`${API_URL}/basicauth`,
    {headers}).pipe(
      map(
        data=>{
          sessionStorage.setItem(AUTHENTICATEDUSER, username);
          sessionStorage.setItem(TOKEN, basicAuthHeaderString);
          return data;
        }
      )
    )
  }

  getAuthenticatedUSer() {
    return sessionStorage.getItem(AUTHENTICATEDUSER)
  }

  getAuthenticatedToken() {
    if(this.getAuthenticatedUSer())
      return sessionStorage.getItem(TOKEN)

    return null
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATEDUSER)
    return !(user===null)
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATEDUSER)
    sessionStorage.removeItem(TOKEN)
  }
}

export class AuthenticationBean {
  constructor(public message:string) {}
}
