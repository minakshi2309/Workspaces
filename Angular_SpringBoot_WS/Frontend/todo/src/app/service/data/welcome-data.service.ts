import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Injectable } from '@angular/core';

export class HelloWorldBean {
  constructor(public message:String) { }
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http:HttpClient
  ) { }

  

  executeHelloWorldBeanService() {
    //console.log('Execute Hwelo World Bean Service')
    return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean');
  }
  //http://localhost:8080/hello-world-bean/path-variable/minakshi
  executeHelloWorldBeanServiceWithPathVariable(name: any) {
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();

    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString
    // })

    //console.log('Execute Hwelo World Bean Service')
    return this.http.get<HelloWorldBean>(`http://localhost:8080/hello-world-bean/path-variable/${name}`,
    //{headers}
    );
  }

  // createBasicAuthenticationHttpHeader() {
  //   let username = 'angular'
  //   let password = 'password'
  //   let basicAuthHeaderString = 'Basic '+window.btoa(username+':'+password)
  //   return basicAuthHeaderString;
  // }
}
