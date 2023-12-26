import { Component } from '@angular/core';
import { AxiosService } from "../axios.service";

@Component({
  selector: 'app-auth-content',
  templateUrl: './auth-content.component.html',
  styleUrls: ['./auth-content.component.css']
})
export class AuthContentComponent {
  data: string[] = [];

  constructor(private axiosService: AxiosService) { }

  ngOnInit(): void {
    this.axiosService.request('get', '/messages', null)
      .then(data => {
        this.data = data;
        console.log('My Data:', this.data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }
}
