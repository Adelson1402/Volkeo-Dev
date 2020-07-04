package br.com.volkeo.basicaccess.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.volkeo.basicaccess.dao.generic.DataDictionary;

@Entity
@Table(name = "tab_documentos")
public class DocumentosEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4785780312354541063L;

	@Id
	@TableGenerator(name = "TAB_DOCUMENTOS_GENERATOR", 
	  table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_DOCUMENTOS", allocationSize = 1)
	@GeneratedValue(generator="TAB_DOCUMENTOS_GENERATOR")
	@Column(name = "id_documentos")
	private Long id;

	@Column(name = "nr_documento")
	private String nrDocumento;

	@Column(name = "ds_complemento")
	private String dsComplemento;

	@Column(name = "ds_obs")
	private String dsObs;

	@OneToOne(optional = false)
	@JoinColumn(name = "id_tp_documento")
	private TabTipoDocumentoEntity idTpDoc;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pessoa")
	private PessoaEntity pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getDsObs() {
		return dsObs;
	}

	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}

	public TabTipoDocumentoEntity getIdTpDoc() {
		return idTpDoc;
	}

	public void setIdTpDoc(TabTipoDocumentoEntity idTpDoc) {
		this.idTpDoc = idTpDoc;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

}
