import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { DescuentosRoutingModule } from './descuentos-routing.module';
import { DescuentosComponent } from './descuentos.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    DescuentosComponent
  ],
  imports: [
    CommonModule,
    DescuentosRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ]
})
export class DescuentosModule { }
