package testetecnico.spanhol.statusnfe.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author span
 */
@Entity
@Table(name = "statusNFE")
@NamedQueries({
	@NamedQuery(name = "StatusNFE.findAll", query = "SELECT s FROM StatusNFE s"),
	@NamedQuery(name = "StatusNFE.findById", query = "SELECT s FROM StatusNFE s WHERE s.id = :id"),
	@NamedQuery(name = "StatusNFE.findByAutorizador", query = "SELECT s FROM StatusNFE s WHERE s.autorizador = :autorizador"),
	@NamedQuery(name = "StatusNFE.findBySituacao", query = "SELECT s FROM StatusNFE s WHERE s.situacao = :situacao"),
	@NamedQuery(name = "StatusNFE.findByDataAtualizacao", query = "SELECT s FROM StatusNFE s WHERE s.dataAtualizacao = :dataAtualizacao")})
public class StatusNFE implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "autorizador")
	private String autorizador;
	@Basic(optional = false)
	@Column(name = "situacao")
	private String situacao;
	@Basic(optional = false)
	@Column(name = "data_atualizacao")
	@Temporal(TemporalType.DATE)
	private Date dataAtualizacao;
	@JoinColumn(name = "servico_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Servico servicoId;

	public StatusNFE() {
	}

	public StatusNFE(Integer id) {
		this.id = id;
	}

	public StatusNFE(Integer id, String autorizador, String situacao, Date dataAtualizacao) {
		this.id = id;
		this.autorizador = autorizador;
		this.situacao = situacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(String autorizador) {
		this.autorizador = autorizador;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Servico getServicoId() {
		return servicoId;
	}

	public void setServicoId(Servico servicoId) {
		this.servicoId = servicoId;
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
		if (!(object instanceof StatusNFE)) {
			return false;
		}
		StatusNFE other = (StatusNFE) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "testetecnico.spanhol.statusnfe.model.StatusNFE[ id=" + id + " ]";
	}

}
