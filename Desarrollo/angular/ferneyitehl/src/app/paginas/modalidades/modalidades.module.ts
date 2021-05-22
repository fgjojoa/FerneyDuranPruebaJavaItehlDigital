import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ModalidadesRoutingModule } from './modalidades-routing.module';
import { ModalidadesComponent } from './modalidades.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    ModalidadesComponent
  ],
  imports: [
    CommonModule,
    ModalidadesRoutingModule,
    HttpClientModule
  ]
})
export class ModalidadesModule { }
