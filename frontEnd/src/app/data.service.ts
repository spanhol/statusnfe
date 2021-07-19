import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse, HttpParams } from "@angular/common/http";
import { throwError } from "rxjs";
import { retry, catchError } from "rxjs/operators";

@Injectable({
	providedIn: "root"
})
export class DataService {

	private REST_ATUAL = "http://localhost:8080/atual";
	private REST_ESTADO = "http://localhost:8080/";
	private REST_DATA = "http://localhost:8080/atual/";
	private REST_INDISPONIBILIDADE = "http://localhost:8080/indisponibilidade";

	constructor(private httpClient: HttpClient) { }

	handleError(error: HttpErrorResponse) {
		let errorMessage = "Erro desconhecido";
		if (error.error instanceof ErrorEvent) {
			errorMessage = "Erro: ${error.error.message}";
		} else {
			errorMessage = "Erro Codigo: ${error.status}\nMenssagem: ${error.message}";
		}
		window.alert(errorMessage);
		return throwError(errorMessage);
	}

	public getAtual() {
		return this.httpClient.get(this.REST_ATUAL).pipe(retry(3), catchError(this.handleError));
	}

	public getByEstado(estado) {
		return this.httpClient.get(this.REST_ESTADO + estado).pipe(retry(3), catchError(this.handleError));
	}

	public getByData(de, ate) {
		return this.httpClient.get(this.REST_DATA + de + "/" + ate).pipe(retry(3), catchError(this.handleError));
	}

	public getIndisponibilidade() {
		return this.httpClient.get(this.REST_INDISPONIBILIDADE).pipe(retry(3), catchError(this.handleError));
	}

	/*
  public sendGetRequest(){
	// Add safe, URL encoded_page parameter 
	const options = { params: new HttpParams({fromString: "_page=1&_limit=20"}) };
	return this.httpClient.get(this.REST_API_SERVER, options).pipe(retry(3), catchError(this.handleError));
		}
	*/
}