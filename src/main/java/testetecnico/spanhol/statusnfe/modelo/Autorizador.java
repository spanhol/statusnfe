/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testetecnico.spanhol.statusnfe.modelo;

import java.util.ArrayList;

/**
 *
 * @author span
 */
public class Autorizador {

	String nome;
	ArrayList<ServicoColetado> servicos;

	public Autorizador(String nome) {
		this.nome = nome;
		servicos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<ServicoColetado> getServicos() {
		return servicos;
	}

	@Override
	public String toString() {
		return "Autorizador{" + "nome=" + nome + ", servicos=" + servicos + '}';
	}

}
