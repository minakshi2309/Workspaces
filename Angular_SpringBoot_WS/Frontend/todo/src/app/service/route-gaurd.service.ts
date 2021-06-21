import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGaurdService implements CanActivate{

  constructor(private router: Router,
    private hardcodedAuthentication: HardcodedAuthenticationService ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.hardcodedAuthentication.isUserLoggedIn())
      return true;
    
    this.router.navigate(['login'])  
    return false;
  }
}
