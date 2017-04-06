import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Http, Headers } from '@angular/http';

@Component({
  selector: 'heater',
  templateUrl: './heater.component.html',
  styleUrls: ['./heater.component.css']
})
export class HeaterComponent implements OnInit {

  power:any;
  consomation:any;

  heaters;

  constructor(private http: Http) { }

  ngOnInit() {
      this.getHeaters();
  }

  addHeater() {
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      var content = JSON.stringify({
        power: this.power,
        consomation: this.consomation,
      });

      return this.http.put('/rest/heater/create', content, {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { console.log(data); },
        err => { console.log(err); }
      );
  }

  getHeaterById(){
    this.heaters = this.http.get('/rest/heater/search/1');
  }

  getHeaters(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/heater/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.heaters = data; console.log(data); },
        err => { console.log(err); }
      );
  }
}
