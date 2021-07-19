import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { TableModule } from 'primeng/table';

@Component({
	selector: 'app-pordata',
	templateUrl: './pordata.component.html',
	styleUrls: ['./pordata.component.sass']
})
export class PordataComponent implements OnInit {

	servicos = ["Autorizador"];
	autorizadores = [];
	grupos = [];
	destroy$: Subject<boolean> = new Subject<boolean>();
	de;
	ate;
	empty = ["value"];

	constructor(private dataService: DataService, private route: ActivatedRoute) { }

	ngOnInit(): void {
		this.de = "";
		this.ate = "";
		this.route.queryParams.subscribe((params) => {
			this.de = params.de;
			this.ate = params.ate;
		});

		this.dataService.getByData(this.de, this.ate).pipe(takeUntil(this.destroy$)).subscribe((data: any[]) => {
			//coleta serviços e autorizadores
			data.forEach(e => {
				var serv = e.servicoId.nome;
				if (!this.servicos.includes(serv)) {
					this.servicos.push(serv);
				}
				var autori = e.autorizador;
				if (!this.autorizadores.includes(autori)) {
					this.autorizadores.push(autori);
				}
			});
			//cria grupos de autorizadores que vao conter situação de cada servico
			//cada grupo sera uma linha na tabela
			this.autorizadores.forEach(e => {
				var g = { autorizador: e, status: [] }
				this.grupos.push(g);
			});

			//percorre o array coletando as situacaoes 
			this.grupos.forEach(group => {
				data.forEach(e => {
					if (e.autorizador == group.autorizador) {
						if (e.situacao == "VERDE") {
							group.status.push('/assets/imagens/bola_verde.png');
						} else if (e.situacao == "AMARELO") {
							group.status.push('/assets/imagens/bola_amarela.png');
						} else if (e.situacao == "VERMELHO") {
							group.status.push('/assets/imagens/bola_vermelha.png');
						} else if (e.situacao == "") {
							group.status.push('');
						}
						// group.status.push(e.situacao);
					}
				});
			});
		})
	}

	ngOnDestroy() {
		this.destroy$.next(true);
		this.destroy$.unsubscribe();
	}
}
