import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { EditarcursoRoutingModule } from './editarcurso-routing.module';
import { EditarcursoComponent } from './editarcurso.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    EditarcursoComponent
  ],
  imports: [
    CommonModule,
    EditarcursoRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ]
})
export class EditarcursoModule { }
