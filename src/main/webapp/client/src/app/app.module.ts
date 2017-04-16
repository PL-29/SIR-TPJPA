import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AlertModule } from 'ng2-bootstrap';
import { CollapseDirective } from 'ng2-bootstrap'
import { ModalModule } from 'ng2-bootstrap';
import { FilterPerson } from './filterPerson';
import { FilterHome } from './filterHome';
import { FilterHeater } from './filterHeater';
import { FilterElectronicdevice } from './filterElectronicdevice';

import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routes';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { PersonComponent } from './person/person.component';
import { HeaterComponent } from './heater/heater.component';
import { ElectronicdeviceComponent } from './electronicdevice/electronicdevice.component';
import { HttpModule, JsonpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    PersonComponent,
    HeaterComponent,
    ElectronicdeviceComponent,
    CollapseDirective,
    FilterPerson,
    FilterHome,
    FilterHeater,
    FilterElectronicdevice,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
	  AlertModule.forRoot(),
    RouterModule.forRoot(ROUTES),
    ModalModule.forRoot(),
    HttpModule,
    JsonpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


