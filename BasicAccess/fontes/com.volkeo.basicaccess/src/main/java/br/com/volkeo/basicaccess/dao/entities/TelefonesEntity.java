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
@Table(name = "tb_telefones")
public class TelefonesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4785780312354541063L;

	@Id
	@TableGenerator(name = "TAB_TELEFONES_GENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_TELEFONES", allocationSize = 1)
	@GeneratedValue(generator = "TAB_TELEFONES_GENERATOR")
	@Column(name = "id_telefones")
	private Long id;

	@Column(name = "descr_numero")
	private String nrNumero;

	@Column(name = "fl_principal")
	private Character flPrincipal;

	@Column(name = "ds_ddi")
	private String dsDdi;

	@OneToOne(optional = false)
	@JoinColumn(name = "id_tipo_telefone")
	private TabTipoTelefoneEntity idTpTel;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pessoa")
	private PessoaEntity pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNrNumero() {
		return nrNumero;
	}

	public void setNrNumero(String nrNumero) {
		this.nrNumero = nrNumero;
	}

	public Character getFlPrincipal() {
		return flPrincipal;
	}

	public void setFlPrincipal(Character flPrincipal) {
		this.flPrincipal = flPrincipal;
	}

	public String getDsDdi() {
		return dsDdi;
	}

	public void setDsDdi(String dsDdi) {
		this.dsDdi = dsDdi;
	}

	public TabTipoTelefoneEntity getIdTpTel() {
		return idTpTel;
	}

	public void setIdTpTel(TabTipoTelefoneEntity idTpTel) {
		this.idTpTel = idTpTel;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

}
