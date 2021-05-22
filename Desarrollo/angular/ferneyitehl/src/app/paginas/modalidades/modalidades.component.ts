import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../../servicios/api.service';

@Component({
  selector: 'app-modalidades',
  templateUrl: './modalidades.component.html',
  styleUrls: ['./modalidades.component.scss']
})
export class ModalidadesComponent implements OnInit {

  listado:any = [];

  constructor(private router: Router, private servicio: ApiService) { 
    this.getAllModalidades();
  }
 
  private getAllModalidades() {
    this.servicio.getModalidades()
    .subscribe(
      data => {
        this.listado = data;
      },
      error => {
        console.log(error);
      });
  }

  ngOnInit(): void {

  }

}
