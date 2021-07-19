import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
	selector: 'app-indisponibilidade',
	templateUrl: './indisponibilidade.component.html',
	styleUrls: ['./indisponibilidade.component.sass']
})
export class IndisponibilidadeComponent implements OnInit {

	servicos = ["Autorizador"];
	autorizadores = [];
	grupos = [];
	destroy$: Subject<boolean> = new Subject<boolean>();

	constructor(private dataService: DataService) { }

	ngOnInit(): void {
		this.dataService.getIndisponibilidade().pipe(takeUntil(this.destroy$)).subscribe((data: any[]) => {
			//coleta serviços e autorizadores
			if (!data || data == null) {
				this.servicos = ["Sem dados."];
				// this.autorizadores = ["Sem dados"];
				// this.grupos = ["Sem dados"];
				return;
			}
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
