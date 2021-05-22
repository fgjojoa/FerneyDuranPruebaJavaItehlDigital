import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  baseUrl = 'http://localhost:8080';
  baseModalidad = '/apimodalidad';
  baseCurso = '/apicurso';
  baseDescuento = '/apidescuento';

  urlmodalidades = this.baseUrl + this.baseModalidad +'/modalidades';
  urlcursos = this.baseUrl + this.baseCurso +'/cursos';
  urlcursobymodalidad = this.baseUrl + this.baseCurso +'/modalidad';
  urlcrearcurso = this.baseUrl + this.baseCurso +'/save';
  urldeletecurso = this.baseUrl + this.baseCurso +'/delete';
  urldescuentobycurso = this.baseUrl + this.baseDescuento +'/curso';
  urlcreardescuento = this.baseUrl + this.baseDescuento +'/save';
  urldeletedescuento = this.baseUrl + this.baseDescuento +'/delete';
  
  constructor(private http: HttpClient) {}

  getModalidades() {
     return this.http.get(this.urlmodalidades);
  }

  getAllCursos() {
    return this.http.get(this.urlcursos);
  }

  getCursosByModalidad(modalidad: object) {
    return this.http.post(this.urlcursobymodalidad, modalidad);
  }

  saveCurso(curso:Object) {
    return this.http.post(this.urlcrearcurso, curso);
  }

  deleteCurso(id:string) {
    return this.http.delete(this.urldeletecurso+"/"+id);
  }

  getDescuentosByCurso(curso: object) {
    return this.http.post(this.urldescuentobycurso, curso);
  }

  saveDescuento(descuento:Object) {
    return this.http.post(this.urlcreardescuento, descuento);
  }

  deleteDescuento(id:string) {
    return this.http.delete(this.urldeletedescuento+"/"+id);
  }

}
