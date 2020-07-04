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
@Table(name = "tab_tp_endereco")
public class TabTipoEnderecoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7713867614309769678L;

	@Id
	@TableGenerator(name = "TAB_TP_ENDER_GENERATOR", 
	                table = DataDictionary.TABLE_NAME_GENERATOR, 
	                pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, 
	                valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, 
	                pkColumnValue = "TAB_TIPO_ENDERECO", allocationSize = 1)
	@GeneratedValue(generator = "TAB_TP_ENDER_GENERATOR")
	@Column(name = "id_tp_endereco")
	private Long id;

	@Column(name = "ds_tp_endereco" ,length=30,nullable=false,unique=true )
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
