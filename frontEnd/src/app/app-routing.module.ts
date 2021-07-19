import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AtualComponent } from './atual/atual.component';
import { EstadoComponent } from './estado/estado.component';
import { IndisponibilidadeComponent } from './indisponibilidade/indisponibilidade.component';
import { PordataComponent } from './pordata/pordata.component';


const routes: Routes = [
	{ path: '', redirectTo: 'atual', pathMatch: 'full' },
	{ path: 'atual', component: AtualComponent },
	{ path: 'estado', component: EstadoComponent },
	{ path: 'pordata', component: PordataComponent },
	{ path: 'indisponibilidade', component: IndisponibilidadeComponent },

];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
