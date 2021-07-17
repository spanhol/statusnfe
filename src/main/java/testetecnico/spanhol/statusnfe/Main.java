package testetecnico.spanhol.statusnfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author span
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ColetorDeStatusNFE coletor = new ColetorDeStatusNFE();
		coletor.buscarDados();
//		for (Autorizador autorizador : coletor.getAutorizadores()) {
//			System.out.println(autorizador);
//		}

		SpringApplication.run(Main.class, args);
	}
}
