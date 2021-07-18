package testetecnico.spanhol.statusnfe.modelo;

/**
 *
 * @author span
 */
public class ServicoColetado {

	public static final String VERDE = "VERDE";
	public static final String AMARELO = "AMARELO";
	public static final String VERMELHOR = "VERMELHOR";
	public static final String BLANK = "";

	String disponibilidade;
	Servico servico;

//	public ServicoColetado(String nome, String disponibilidade) {
//		this.nome = nome;
//		this.disponibilidade = disponibilidade;
//	}
	public ServicoColetado(String disponibilidade, Servico servico) {
		this.disponibilidade = disponibilidade;
		this.servico = servico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	@Override
	public String toString() {
		return "ServicoColetado{" + "disponibilidade=" + disponibilidade + ", servico=" + servico + '}';
	}

}
