package testetecnico.spanhol.statusnfe;

import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import testetecnico.spanhol.statusnfe.controller.MainController;
import testetecnico.spanhol.statusnfe.modelo.Autorizador;
import testetecnico.spanhol.statusnfe.modelo.NFEStatus;
import testetecnico.spanhol.statusnfe.modelo.Servico;
import testetecnico.spanhol.statusnfe.modelo.ServicoColetado;

/**
 *
 * @author span
 */
@Component
public class Agendador {

	@Autowired
	MainController controller;

	@Scheduled(fixedRate = 300000)
	public void coletaDados() {
		//coleta
		ColetorDeStatusNFE coletor = new ColetorDeStatusNFE(controller.getServicos());
		coletor.buscarDados();
		//salva no banco
		for (Servico coletado : coletor.getServicosColetados()) {
			try {
				controller.saveServico(coletado);
			} catch (Exception ex) {
				java.util.logging.Logger.getLogger(Agendador.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		//atualiza ids de servico coletado
		Iterable<Servico> servicos = controller.getServicos();
		for (Servico coletado : coletor.getServicosColetados()) {
			if (coletado.getId() == null) {
				for (Servico servico : servicos) {
					if (coletado.getNome().compareTo(servico.getNome()) == 0) {
						coletado.setId(servico.getId());
					}
				}
			}
		}
		//expande e salva status dos servicos
		for (Autorizador autorizador : coletor.getAutorizadores()) {
			for (ServicoColetado coletado : autorizador.getServicos()) {
				NFEStatus status = new NFEStatus(autorizador.getNome(), coletado.getDisponibilidade(), autorizador.getData(), coletado.getServico());
				try {
					controller.saveStatus(status);
				} catch (Exception ex) {
					java.util.logging.Logger.getLogger(Agendador.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}
