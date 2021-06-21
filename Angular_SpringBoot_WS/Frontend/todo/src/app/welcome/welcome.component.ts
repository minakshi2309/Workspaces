import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name= ''
  welcomeMessageFromService:String = ''

  constructor(
    private route: ActivatedRoute,
    private service: WelcomeDataService
    ) { }

  ngOnInit(): void {
    this.name= this.route.snapshot.params['name']
  }

  getWelcomeMessage() {
    //console.log('get welcome message!');
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }
  getWelcomeMessageWithParameter() {
    //console.log('get welcome message!');
    this.service.executeHelloWorldBeanServiceWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  handleSuccessfulResponse(response:any){
    // console.log(response);
    // console.log(response.message);
    this.welcomeMessageFromService=response.message

  }
  
  handleErrorResponse(error: any): void {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
    this.welcomeMessageFromService = error.error.message
  }
}
