package br.com.volkeo.basicaccess.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.volkeo.basicaccess.dao.generic.DataDictionary;

@Entity
@Table(name="tab_emails")
public class EmailsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9011324522751553446L;

	@Id
	@TableGenerator(name = "TAB_EMAILS_GENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_EMAILS", allocationSize = 1)
	@GeneratedValue(generator = "TAB_EMAILS_GENERATOR")
	@Column(name = "id_emails")
	private Long id;
	
	@Column(name="ds_email")
	private String dsEmail;
	
	@Column(name="fl_principal")
	private Character flPrincipal;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_pessoa")
	private PessoaEntity idPessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public Character getFlPrincipal() {
		return flPrincipal;
	}

	public void setFlPrincipal(Character flPrincipal) {
		this.flPrincipal = flPrincipal;
	}

	public PessoaEntity getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(PessoaEntity idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	
	
}

