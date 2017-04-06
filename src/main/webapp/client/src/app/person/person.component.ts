import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Http, Headers } from '@angular/http';

@Component({
  selector: 'person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  lastname:any;
  firstname:any;
  email:any;

  persons;

  constructor(private http: Http) {
  }

  ngOnInit() {
      this.getPersons();
  }

  addPerson() {
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      var content = JSON.stringify({
        lastname: this.lastname,
        firstname: this.firstname,
        email: this.email,
      });

      return this.http.put('/rest/person/create', content, {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { console.log(data); },
        err => { console.log(err); }
      );
  }

  getPersonById(){
    this.persons = this.http
                    .get('/rest/person/search/1');
  }

  getPersons(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/person/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.persons = data; console.log(data); },
        err => { console.log(err); }
      );
  }
}
