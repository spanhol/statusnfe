package testetecnico.spanhol.statusnfe.modelo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author span
 */
public class Autorizador {

	String nome;
	ArrayList<ServicoColetado> servicos;
	Timestamp data;

	public Autorizador(String nome, Timestamp data) {
		this.nome = nome;
		servicos = new ArrayList<>();
		this.data = data;
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

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Autorizador{" + "nome=" + nome + ", servicos=" + servicos + '}';
	}

}
