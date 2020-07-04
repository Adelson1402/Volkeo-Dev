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
@Table(name = "tab_ramo_atividade")
public class RamoAtividadeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5896503574864657780L;

	@Id
	@TableGenerator(name = "TAB_TP_RAMOGENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_RAMOS_ATIVIDADE", allocationSize = 1)
	@GeneratedValue(generator = "TAB_TP_RAMOGENERATOR")
	@Column(name = "id_ramo_atividade")
	private Long id;

	@Column(name = "cd_cnae")
	private String cdCnae;

	@Column(name = "ds_ramo")
	private String dsRamo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCdCnae() {
		return cdCnae;
	}

	public void setCdCnae(String cdCnae) {
		this.cdCnae = cdCnae;
	}

	public String getDsRamo() {
		return dsRamo;
	}

	public void setDsRamo(String dsRamo) {
		this.dsRamo = dsRamo;
	}

}

/*
 * reate table if not exists ( bigint(15) not null, varchar(20) not null,
 * varchar(100) not null, primary key (id_ramo_atividade)) engine = innodb;
 */
