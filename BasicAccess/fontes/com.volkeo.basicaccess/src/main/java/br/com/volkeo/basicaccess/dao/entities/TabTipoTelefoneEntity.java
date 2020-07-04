package br.com.volkeo.basicaccess.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import br.com.volkeo.basicaccess.dao.generic.DataDictionary;

@Entity
@Table(name = "tab_tipo_telefone")
public class TabTipoTelefoneEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1817008932100266581L;

	@Id
	@TableGenerator(name = "TAB_TP_TELGENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_TIPO_TELEFONE", allocationSize = 1)
	@GeneratedValue(generator = "TAB_TP_TELGENERATOR")
	@Column(name = "id_tipo_telefone")
	private Long id;

	@Column(name = "ds_tipo", length = 45)
	private String dsTipo;

	@Column(name = "ds_mask", length = 45)
	private String dsMask;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsTipo() {
		return dsTipo;
	}

	public void setDsTipo(String dsTipo) {
		this.dsTipo = dsTipo;
	}

	public String getDsMask() {
		return dsMask;
	}

	public void setDsMask(String dsMask) {
		this.dsMask = dsMask;
	}

}

/*
 * create table if not exists ( bigint(10) not null, ds_tipo varchar(45) not
 * null, ds_mask varchar(45) null, primary key (id_tipo_telefone)) engine =
 * innodb;
 */