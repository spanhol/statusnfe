package testetecnico.spanhol.statusnfe.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import testetecnico.spanhol.statusnfe.modelo.Servico;

/**
 *
 * @author span
 */
@RepositoryRestResource(collectionResourceRel = "servico", path = "servicos")
public interface ServicoRepository extends PagingAndSortingRepository<Servico, Long> {

	List<Servico> findByNome(@Param("nome") String nome);
}
//public interface ServicoRepository extends CrudRepository<Servico, Integer> {
//
//}
