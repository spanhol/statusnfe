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

	String nome;
	String disponibilidade;

	public ServicoColetado(String nome, String disponibilidade) {
		this.nome = nome;
		this.disponibilidade = disponibilidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	@Override
	public String toString() {
		return "Servico{" + "nome=" + nome + ", disponibilidade=" + disponibilidade + '}';
	}

}
