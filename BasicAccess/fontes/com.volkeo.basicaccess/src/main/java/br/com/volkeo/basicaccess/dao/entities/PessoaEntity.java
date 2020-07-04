package br.com.volkeo.basicaccess.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.volkeo.basicaccess.dao.generic.DataDictionary;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tab_pessoa")
public abstract class PessoaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3119934565073489062L;

	@Id
	@TableGenerator(name = "TAB_PESSOA_GENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_PESSOA", allocationSize = 1)
	@GeneratedValue(generator = "TAB_PESSOA_GENERATOR")
	@Column(name = "id_pessoa")
	private Long id;

	@Column(name = "dh_criacao")
	private Date dhCriacao;

	@OneToMany(mappedBy = "pessoa", targetEntity = DocumentosEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DocumentosEntity> lstDocumentos;

	@OneToMany(mappedBy = "pessoa", targetEntity = TelefonesEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TelefonesEntity> lstTelefones;

	@OneToMany(mappedBy = "idPessoa", targetEntity = EmailsEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmailsEntity> lstEmails;

	@OneToMany(mappedBy = "pessoa", targetEntity = TabEnderecoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TabEnderecoEntity> lstEnderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDhCriacao() {
		return dhCriacao;
	}

	public void setDhCriacao(Date dhCriacao) {
		this.dhCriacao = dhCriacao;
	}

	public List<DocumentosEntity> getLstDocumentos() {
		return lstDocumentos;
	}

	public void setLstDocumentos(List<DocumentosEntity> lstDocumentos) {
		this.lstDocumentos = lstDocumentos;
	}

	public List<TelefonesEntity> getLstTelefones() {
		return lstTelefones;
	}

	public void setLstTelefones(List<TelefonesEntity> lstTelefones) {
		this.lstTelefones = lstTelefones;
	}

	public List<EmailsEntity> getLstEmails() {
		return lstEmails;
	}

	public void setLstEmails(List<EmailsEntity> lstEmails) {
		this.lstEmails = lstEmails;
	}

	public List<TabEnderecoEntity> getLstEnderecos() {
		return lstEnderecos;
	}

	public void setLstEnderecos(List<TabEnderecoEntity> lstEnderecos) {
		this.lstEnderecos = lstEnderecos;
	}

}
