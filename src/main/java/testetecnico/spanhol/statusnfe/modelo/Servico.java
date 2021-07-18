package testetecnico.spanhol.statusnfe.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author span
 */
@Entity
@Table(name = "servico")
@NamedQueries({
	@NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
	@NamedQuery(name = "Servico.findById", query = "SELECT s FROM Servico s WHERE s.id = :id"),
	@NamedQuery(name = "Servico.findByNome", query = "SELECT s FROM Servico s WHERE s.nome = :nome")})
public class Servico implements Serializable {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoId")
	private Collection<NFEStatus> statusNFECollection;

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "nome")
	private String nome;

	public Servico() {
	}

	public Servico(Integer id) {
		this.id = id;
	}

	public Servico(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Servico(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Servico)) {
			return false;
		}
		Servico other = (Servico) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	public Collection<NFEStatus> getStatusNFECollection() {
		return statusNFECollection;
	}

	public void setStatusNFECollection(Collection<NFEStatus> statusNFECollection) {
		this.statusNFECollection = statusNFECollection;
	}

}
