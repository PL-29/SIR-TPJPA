import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Http } from '@angular/http';

@Component({
  selector: 'electronicdevice',
  templateUrl: './electronicdevice.component.html',
  styleUrls: ['./electronicdevice.component.css']
})
export class ElectronicdeviceComponent implements OnInit {

  lastname:any;
  firstname:any;
  email:any;

  constructor(private http: Http) {
  }

  ngOnInit() {
  }

  addEd() {
    ///http.put('http://localhost:8080/person/create')
      //.map(response => response.json());

      console.log(this.lastname);
  }
}
