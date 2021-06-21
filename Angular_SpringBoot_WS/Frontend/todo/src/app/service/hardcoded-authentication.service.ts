import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(username: string, password: string) {
    //return !(username === 'angular' && password === 'password')
    //console.log('username & pwd: '+username+' '+password)
    if(username === 'angular' && password === 'password'){
      //console.log('username & pwd: '+'in if condition')
      sessionStorage.setItem('authenticatedUser', username)
      return false;
    }

    return true;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user===null)
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser')
  }
}
