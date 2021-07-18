package testetecnico.spanhol.statusnfe.repository;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import testetecnico.spanhol.statusnfe.modelo.NFEStatus;

/**
 *
 * @author span
 */
public interface NfeRepository extends CrudRepository<NFEStatus, Integer> {

	@Query(value = " SELECT max(n.id) as id, n.autorizador, n.servico_id, n.situacao, s.nome, max(n.dt) as dt\n"
			+ " FROM public.statusnfe n inner join servico s on s.id = n.servico_id\n"
			+ " GROUP BY n.autorizador, n.servico_id, n.situacao, s.nome\n"
			+ " ORDER BY n.autorizador ", nativeQuery = true)
	List<NFEStatus> mostraAtual();

	@Query(value = "SELECT max(n.id) as id, n.autorizador, n.servico_id, n.situacao, s.nome, n.dt\n"
			+ "	FROM public.statusnfe n\n"
			+ "	inner join servico s on s.id = n.servico_id\n"
			+ "	where n.dt between :de and :ate	\n"
			+ "	GROUP BY n.autorizador, n.servico_id, n.situacao, s.nome, n.dt\n"
			+ "	ORDER BY n.autorizador", nativeQuery = true)
	List<NFEStatus> mostraAtualByDate(@Param("de") Timestamp de, @Param("ate") Timestamp ate);

	@Query(value = " SELECT max(n.id) as id, n.autorizador, n.servico_id, n.situacao, s.nome, max(n.dt) as dt\n"
			+ " FROM public.statusnfe n inner join servico s on s.id = n.servico_id\n"
			+ " WHERE autorizador = :autorizador\n"
			+ " GROUP BY s.id, n.autorizador, n.servico_id, n.situacao, s.nome\n"
			+ " ORDER BY s.id ", nativeQuery = true)
	List<NFEStatus> mostraAtualDoEstado(@Param("autorizador") String estado);

	@Query(value = " SELECT autorizador from (\n"
			+ " SELECT count(n.id), n.autorizador, n.situacao\n"
			+ "	FROM public.statusnfe n\n"
			+ "	inner join servico s on s.id = n.servico_id\n"
			+ "	WHERE n.situacao != 'VERDE' and n.situacao != ''\n"
			+ "	GROUP BY n.autorizador, n.situacao\n"
			+ "	limit 1\n"
			+ ") as x", nativeQuery = true)
	String mostraMaiorIndisponibilidade();
}
