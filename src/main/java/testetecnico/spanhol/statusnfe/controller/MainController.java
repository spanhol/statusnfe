package testetecnico.spanhol.statusnfe.controller;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import testetecnico.spanhol.statusnfe.modelo.NFEStatus;
import testetecnico.spanhol.statusnfe.modelo.Servico;
import testetecnico.spanhol.statusnfe.repository.NfeRepository;
import testetecnico.spanhol.statusnfe.repository.ServicoRepository;

/**
 *
 * @author span
 */
@Controller
@RequestMapping(path = "/")
public class MainController {

	@Autowired
	private NfeRepository nfeRepository;
	@Autowired
	private ServicoRepository servicoRepository;

	public void saveServico(Servico servico) throws Exception {
		//se servico ja existe, não faz nada
		if (servico.getId() != null) {
			return;
		}
		for (Servico existente : servicoRepository.findAll()) {
			if (existente.getNome().compareTo(servico.getNome()) == 0) {
				return;
			}
		}
		servico = servicoRepository.save(servico);
		System.out.println(ResponseEntity.ok(servico).toString());
	}

	public Iterable<Servico> getServicos() {
		return servicoRepository.findAll();
	}

	public void saveStatus(NFEStatus status) throws Exception {
		System.out.print("saveStatus");
		status = nfeRepository.save(status);
		System.out.println(ResponseEntity.ok(status).toString());
	}

	@GetMapping(path = "/atual")
	public @ResponseBody
	Iterable<NFEStatus> getStatusAtual() {
		return nfeRepository.mostraAtual();
	}

	@GetMapping(path = "/{autorizador}")
	public @ResponseBody
	Iterable<NFEStatus> getDoEstado(@PathVariable(value = "autorizador") String autorizador) {
		return nfeRepository.mostraAtualDoEstado(autorizador);
	}

	@GetMapping(path = "/indisponibilidade")
	public @ResponseBody
	String mostraMaiorIndisponibilidade() {
		return nfeRepository.mostraMaiorIndisponibilidade();
	}

	@GetMapping(path = "/atual/{de}/{ate}")
	public @ResponseBody
	List<NFEStatus> mostraMaiorIndisponibilidade(@PathVariable(value = "de") Timestamp de, @PathVariable(value = "ate") Timestamp ate) {
		return nfeRepository.mostraAtualByDate(de, ate);
	}
}
