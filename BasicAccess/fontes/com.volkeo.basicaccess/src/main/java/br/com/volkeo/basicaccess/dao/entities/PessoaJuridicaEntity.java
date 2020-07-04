package br.com.volkeo.basicaccess.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class PessoaJuridicaEntity extends PessoaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3622908803042850020L;

	@Column(name = "razao_social", length = 100)
	private String razaoSocial;

	@Column(name = "nm_fantasia", length = 100)
	private String nmFantasia;

	@Column(name = "dh_fundacao")
	private Date dhFundacao;

	@OneToOne(optional = false)
	@JoinColumn(name = "id_ramo_atividade")
	private RamoAtividadeEntity ramoAtividade;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNmFantasia() {
		return nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	public Date getDhFundacao() {
		return dhFundacao;
	}

	public void setDhFundacao(Date dhFundacao) {
		this.dhFundacao = dhFundacao;
	}

	public RamoAtividadeEntity getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(RamoAtividadeEntity ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

}
