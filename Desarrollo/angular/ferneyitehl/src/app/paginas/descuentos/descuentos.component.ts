import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../../servicios/api.service';
import { Descuento } from 'src/app/modelos/descuento';

@Component({
  selector: 'app-descuentos',
  templateUrl: './descuentos.component.html',
  styleUrls: ['./descuentos.component.scss']
})
export class DescuentosComponent implements OnInit {

  curso = null;
  editar:boolean = false;
  descuentoForm: FormGroup;
  descuentos: any = [];
  descuento: Descuento;
  titulo:string = "Nuevo Descuento";

  errorMessage: string = "";
  showError:boolean = false;

  private isDate = /^([0-2][0-9]|(3)[0-1])(\/)(((0)[0-9])|((1)[0-2]))(\/)\d{4}$/;

  constructor(private router: Router, private fb: FormBuilder, private servicio: ApiService) { 
    const navigation  = this.router.getCurrentNavigation();
    this.curso = navigation?.extras?.state?.value?.item;
    this.getDescuentosByCurso();
    this.initForm();
  }

  ngOnInit(): void {
  }

  get getControl(){
    return this.descuentoForm.controls;
  }

  onNuevo(): void {
    this.descuento = new Descuento();
    this.descuento.curso = this.curso
    this.descuento.modalidad = this.curso.modalidad;
    this.descuento.precio = this.curso.costo;
    let vDes: number = this.descuento.precio * this.curso.modalidad.descuento / 100;
    this.descuento.descuento = Math.round(vDes * 100) / 100;
    this.descuento.precioFinal =  Math.round((this.descuento.precio - this.descuento.descuento) * 100) / 100;
    this.descuentoForm.reset();
    this.descuentoForm.patchValue(this.descuento);
    this.titulo = "Nuevo Descuento";    
    this.editar = true;
  } 

  onDelete(item: any): void {
    this.servicio.deleteDescuento(item.id)
      .subscribe(
        response => {
          console.log(response);
          this.getDescuentosByCurso();
        },
        error => {
          console.log(error);
        });
  }

  onEdit(item: any): void {
    this.descuento = item;
    this.descuentoForm.reset();
    this.descuentoForm.patchValue(this.descuento);
    console.log(this.descuentoForm.value);
    this.titulo = "Editar Descuento ID: " + item.id;    
    this.editar = true;
  }

  private sendError(mensage: string): void {
    this.showError = true;
    this.errorMessage = mensage;
  }


  onSave(): void {
    console.log(this.descuentoForm.value.fechaFinal);
    if (this.descuentoForm.valid) {      
        this.descuento.nombre = this.descuentoForm.value.nombre;
        this.descuento.pais = this.descuentoForm.value.pais;
        this.descuento.fechaFinal = this.descuentoForm.value.fechaFinal;
        console.log(this.descuento);
        this.servicio.saveDescuento(this.descuento)
        .subscribe(data => {
          this.getDescuentosByCurso();
          this.editar = false;
        }, error => console.log(error));        
    } else {
        console.log("Invalido",this.descuentoForm.value);
        if(this.getControl.nombre.invalid) {
          this.sendError("El nombre es requerido");
        } else if(this.getControl.pais.invalid) {
          this.sendError("El país es requerido");
        } else if(this.getControl.fechaFinal.invalid && this.getControl.fechaFinal.errors.required) {
          this.sendError("La fecha final es requerida");
        } else if(this.getControl.fechaFinal.invalid && this.getControl.fechaFinal.errors.pattern) {
          this.sendError("La fecha final no es un valida");
        }
    }
  }


  onCancelar(): void {
    this.editar = false;
  } 

  onGotBack(): void {
    this.router.navigate(['cursos']);
  }

  private getDescuentosByCurso() {
    this.descuentos = [];
    this.servicio.getDescuentosByCurso(this.curso).subscribe(
      data => {
        this.descuentos = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });    
  }

  isValidField(field: string): string {
    const validatedField = this.descuentoForm.get(field);
    return (!validatedField.valid && validatedField.touched)
      ? 'is-invalid' : validatedField.touched ? 'is-valid' : '';
  }

  private initForm(): void {
    this.descuentoForm = this.fb.group({
      id: [''],
      nombre: ['',Validators.required],
      modalidad: [null],
      pais: ['',Validators.required],
      precio: ['',Validators.required],
      descuento: ['',Validators.required],
      precioFinal: ['',Validators.required],
      curso: [null],
      fechaFinal: ['',[Validators.required,Validators.pattern(this.isDate)]]
    });
  }  

}
