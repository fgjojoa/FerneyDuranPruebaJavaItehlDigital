import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Curso } from 'src/app/modelos/curso';
import { ApiService } from '../../servicios/api.service';

@Component({
  selector: 'app-editarcurso',
  templateUrl: './editarcurso.component.html',
  styleUrls: ['./editarcurso.component.scss']
})
export class EditarcursoComponent implements OnInit {
 
  private isPrecio = /^[0-9]+(\.[0-9]{1,2})?$/;   
  private isHora = /^[0-9]\d*$/;

  value: any = null;
  curso: Curso = new Curso();
  cursoForm: FormGroup;
  modalidades:any  = [];
  idmodalidad:string = "";
  titulo:string = "Nuevo Curso";

  errorMessage: string = "";
  showError:boolean = false;

  constructor(private router: Router, private fb: FormBuilder, private servicio: ApiService) { 
    const navigation  = this.router.getCurrentNavigation();
    this.value = navigation?.extras?.state?.value;
    this.initForm();
  }

  ngOnInit(): void { 
    this.curso = new Curso();
    this.modalidades = this.value.modalidades;
    if (this.value.item != null) {
       this.curso.id = this.value.item.id;
       this.curso.nombre = this.value.item.nombre;
       this.curso.descripcion = this.value.item.descripcion;
       this.curso.costo = this.value.item.costo;
       this.curso.horas = this.value.item.horas;
       this.curso.dirigido = this.value.item.dirigido;
       this.curso.modalidad = this.value.item.modalidad.id;  
       this.titulo = "Editar Curso id:" + this.curso.id;
    } else {
      this.curso.id = null;
      this.curso.modalidad = this.modalidades[0].id; 
    }
    this.cursoForm.patchValue(this.curso);
  }

  onGotBack(): void {
    this.router.navigate(['cursos']);
  }

  onSave(): boolean {
    this.showError = false;
    if (this.cursoForm.valid) {
        let cursoEdit:any = {id: this.cursoForm.value.id
                            ,nombre: this.cursoForm.value.nombre
                            ,descripcion: this.cursoForm.value.descripcion
                            ,horas: this.cursoForm.value.horas
                            ,dirigido: this.cursoForm.value.dirigido      
                            ,costo: this.cursoForm.value.costo                      
                            ,modalidad: null};
        for(let i=0; i < this.modalidades.length; i++) {
            if(this.cursoForm.value.modalidad == this.modalidades[i].id) {
              cursoEdit.modalidad = this.modalidades[i];
              break;
            }
        }  
        this.servicio.saveCurso(cursoEdit)
        .subscribe(data => {
          console.log(data) 
          this.onGotBack();
        }, error => console.log(error));        
    } else {
        console.log("Invalido",this.cursoForm.value);
        if(this.getControl.nombre.invalid) {
          this.sendError("El nombre es requerido");
        } else if(this.getControl.descripcion.invalid) {
          this.sendError("La descripción es requerida");
        } else if(this.getControl.horas.invalid && this.getControl.horas.errors.required) {
          this.sendError("La hora es requerida");
        } else if(this.getControl.horas.invalid && this.getControl.horas.errors.pattern) {
          this.sendError("La hora no es un número");
        } else if(this.getControl.dirigido.invalid) {
          this.sendError("Dirigido es requerido");
        } else if(this.getControl.costo.invalid && this.getControl.costo.errors.required) {
          this.sendError("El costo es requerida");
        } else if(this.getControl.costo.invalid && this.getControl.costo.errors.pattern) {
          this.sendError("El costo no es un número");
        }
    }
    return true;
  }

  private sendError(mensage: string): void {
    this.showError = true;
    this.errorMessage = mensage;
  }

  get getControl(){
    return this.cursoForm.controls;
  }


  private initForm(): void {
    this.cursoForm = this.fb.group({
      id: [''],
      nombre: ['',Validators.required],
      descripcion: ['',Validators.required],
      horas: ['',[Validators.required,Validators.pattern(this.isHora)]],
      dirigido: ['',Validators.required],
      costo: ['',[Validators.required ,Validators.pattern(this.isPrecio)]],
      modalidad: ['',Validators.required]
    });
  }

  isValidField(field: string): string {
    const validatedField = this.cursoForm.get(field);
    return (!validatedField.valid && validatedField.touched)
      ? 'is-invalid' : validatedField.touched ? 'is-valid' : '';
  }

}
