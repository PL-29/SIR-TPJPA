import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Http } from '@angular/http';

@Component({
  selector: 'electronicdevice',
  templateUrl: './electronicdevice.component.html',
  styleUrls: ['./electronicdevice.component.css']
})
export class ElectronicdeviceComponent implements OnInit {

  consommation:any;

  electronicdevices;

  constructor(private http: Http) {
  }

  ngOnInit() {
      this.getElectronicDevices();
  }

  addElectronicDevice() {
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      var content = JSON.stringify({
        consommation: this.consommation,
      });

      return this.http.put('/rest/electronicdevice/create', content, {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { console.log(data); },
        err => { console.log(err); }
      );
  }

  getElectronicDeviceById(){
    this.electronicdevices = this.http.get('/rest/electronicdevice/search/1');
  }

  getElectronicDevices(){
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');

      return this.http.get('/rest/electronicdevice/', {
        headers: headers
      }).map(res => res.json()).subscribe(
        data => { this.electronicdevices = data; console.log(data); },
        err => { console.log(err); }
      );
  }
}
