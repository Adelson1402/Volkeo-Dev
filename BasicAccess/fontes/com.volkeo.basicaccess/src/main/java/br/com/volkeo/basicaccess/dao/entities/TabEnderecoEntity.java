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
@Table(name = "tab_endereco")
public class TabEnderecoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3018595238292663404L;

	@Id
	@TableGenerator(name = "TAB_ENDERECO_GENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_ENDERECO", allocationSize = 1)
	@GeneratedValue(generator = "TAB_ENDERECO_GENERATOR")
	@Column(name = "id_endereco")
	private Long id;

	@Column(name = "ds_logradouro")
	private String dsEndereco;

	@Column(name = "ds_numero")
	private String dsNumero;

	@Column(name = "ds_complemento")
	private String dsComplemento;

	@Column(name = "ds_bairro")
	private String dsBairro;

	@Column(name = "ds_cidade")
	private String dsCidade;

	@Column(name = "ds_cep")
	private String dsCep;

	@Column(name = "ds_uf")
	private String dsUf;

	@OneToOne(optional = false)
	@JoinColumn(name = "id_tp_endereco")
	private TabTipoEnderecoEntity tipoEndereco;

	@Column(name = "fl_principal")
	private Character flPrincipal;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pessoa")
	private PessoaEntity pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsEndereco() {
		return dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsNumero() {
		return dsNumero;
	}

	public void setDsNumero(String dsNumero) {
		this.dsNumero = dsNumero;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getDsBairro() {
		return dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCidade() {
		return dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public String getDsCep() {
		return dsCep;
	}

	public void setDsCep(String dsCep) {
		this.dsCep = dsCep;
	}

	public String getDsUf() {
		return dsUf;
	}

	public void setDsUf(String dsUf) {
		this.dsUf = dsUf;
	}

	public TabTipoEnderecoEntity getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TabTipoEnderecoEntity tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Character getFlPrincipal() {
		return flPrincipal;
	}

	public void setFlPrincipal(Character flPrincipal) {
		this.flPrincipal = flPrincipal;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

}
