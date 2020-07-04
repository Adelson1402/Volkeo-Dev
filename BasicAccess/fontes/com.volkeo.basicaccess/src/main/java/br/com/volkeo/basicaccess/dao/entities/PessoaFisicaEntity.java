package br.com.volkeo.basicaccess.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tab_pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class PessoaFisicaEntity extends PessoaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4146771833136228610L;

	@Column(name = "nm_nome")
	private String nmNome;

	@Column(name = "nm_sobrenome")
	private String nmSobreNome;

	@Column(name = "cd_sexo")
	private Character cdSexo;

	@Column(name = "dh_nascimento")
	private Date dhNascimento;

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getNmSobreNome() {
		return nmSobreNome;
	}

	public void setNmSobreNome(String nmSobreNome) {
		this.nmSobreNome = nmSobreNome;
	}

	public Character getCdSexo() {
		return cdSexo;
	}

	public void setCdSexo(Character cdSexo) {
		this.cdSexo = cdSexo;
	}

	public Date getDhNascimento() {
		return dhNascimento;
	}

	public void setDhNascimento(Date dhNascimento) {
		this.dhNascimento = dhNascimento;
	}

}
