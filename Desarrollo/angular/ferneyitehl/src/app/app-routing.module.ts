import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'cursos', loadChildren: () => import('./paginas/cursos/cursos.module').then(m => m.CursosModule) }, { path: 'modalidades', loadChildren: () => import('./paginas/modalidades/modalidades.module').then(m => m.ModalidadesModule) }, { path: 'editarcurso', loadChildren: () => import('./paginas/editarcurso/editarcurso.module').then(m => m.EditarcursoModule) }, { path: 'descuentos', loadChildren: () => import('./paginas/descuentos/descuentos.module').then(m => m.DescuentosModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
