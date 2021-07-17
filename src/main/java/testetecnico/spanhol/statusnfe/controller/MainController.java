package testetecnico.spanhol.statusnfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import testetecnico.spanhol.statusnfe.modelo.StatusNFE;
import testetecnico.spanhol.statusnfe.repository.NfeRepository;

/**
 *
 * @author span
 */
@Controller
@RequestMapping(path = "/")
public class MainController {

	@Autowired
	private NfeRepository nfeRepository;

	@GetMapping(path = "/status")
	public @ResponseBody
	Iterable<StatusNFE> getAllStatus() {
		// This returns a JSON or XML with the users
		return nfeRepository.findAll();
	}

}
