package testetecnico.spanhol.statusnfe;

import testetecnico.spanhol.statusnfe.modelo.Autorizador;
import testetecnico.spanhol.statusnfe.servico.ColetorDeStatusNFE;

/**
 *
 * @author span
 */
public class Main {

	public static void main(String[] args) {
		ColetorDeStatusNFE coletor = new ColetorDeStatusNFE();
		coletor.buscarDados();
		for (Autorizador autorizador : coletor.getAutorizadores()) {
			System.out.println(autorizador);
		}
	}
}
