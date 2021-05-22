import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Modalidad } from 'src/app/modelos/modalidad';
import { ApiService } from '../../servicios/api.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']
})
export class CursosComponent implements OnInit {

  navigationExtras : NavigationExtras = {
    state: {
      value: null
    }
  }

  modalidades:any  = [];
  cursos: any = [];
  idmodalidad: string = "";

  constructor(private router: Router, private servicio: ApiService) { 
    this.getAllModalidades();
    this.getAllCursos();
  }

  ngOnInit(): void {
  }

  onEdit(item: any): void {
    this.navigationExtras.state.value = {modalidades: this.modalidades, item: item};
    this.router.navigate(['editarcurso'], this.navigationExtras);
  }

  onDescuentos(item: any): void {
    this.navigationExtras.state.value = {modalidades: this.modalidades, item: item};
    this.router.navigate(['descuentos'], this.navigationExtras);
  }

  onChange() {
    let vModalidad:Modalidad = null;
    if(this.idmodalidad == "") {
       this.getAllCursos();
    } else {
      this.cursos = [];
      for(let i=0; i < this.modalidades.length; i++) {
        if(this.idmodalidad == this.modalidades[i].id) {
          this.servicio.getCursosByModalidad(this.modalidades[i]).subscribe(
            data => {
              this.cursos = data;
              console.log(data);
            },
            error => {
              console.log(error);
              this.getAllCursos();
            });
          break;
        }
      }       
    }
  }

  private getAllCursos() {
    this.servicio.getAllCursos()
    .subscribe(
      data => {
        this.cursos = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

  private getAllModalidades() {
    this.servicio.getModalidades()
    .subscribe(
      data => {
        this.modalidades = data;
      },
      error => {
        console.log(error);
      });
  }  


  onDelete(item: any): void {
    this.servicio.deleteCurso(item.id)
      .subscribe(
        response => {
          console.log(response);
          this.getAllCursos();
        },
        error => {
          console.log(error);
        });

  }

  onNuevo(): void {
    this.navigationExtras.state.value = {modalidades: this.modalidades, item: null};
    this.router.navigate(['editarcurso'], this.navigationExtras);
  }
}
