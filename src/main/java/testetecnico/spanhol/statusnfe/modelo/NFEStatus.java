package testetecnico.spanhol.statusnfe.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author span
 */
@Entity
@Table(name = "statusnfe")
public class NFEStatus implements Serializable {

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
	@Column(name = "dt")
	private Timestamp data;
	@JoinColumn(name = "servico_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Servico servicoId;

	public NFEStatus() {
	}

	public NFEStatus(Integer id) {
		this.id = id;
	}

	public NFEStatus(String autorizador, String situacao, Timestamp data, Servico servicoId) {
		this.autorizador = autorizador;
		this.situacao = situacao;
		this.data = data;
		this.servicoId = servicoId;
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

	public Servico getServicoId() {
		return servicoId;
	}

	public void setServicoId(Servico servicoId) {
		this.servicoId = servicoId;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
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
		if (!(object instanceof NFEStatus)) {
			return false;
		}
		NFEStatus other = (NFEStatus) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "NFEStatus{" + "id=" + id + ", autorizador=" + autorizador + ", situacao=" + situacao + ", servicoId=" + servicoId + '}';
	}

}
