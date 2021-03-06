import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { AtualComponent } from './atual/atual.component';
import { EstadoComponent } from './estado/estado.component';
import { PordataComponent } from './pordata/pordata.component';
import { IndisponibilidadeComponent } from './indisponibilidade/indisponibilidade.component';
import { TableModule } from 'primeng/table';
import {ButtonModule} from 'primeng/button';





@NgModule({
	declarations: [
		AppComponent,
		AtualComponent,
		EstadoComponent,
		PordataComponent,
		IndisponibilidadeComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		TableModule,
		ButtonModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
