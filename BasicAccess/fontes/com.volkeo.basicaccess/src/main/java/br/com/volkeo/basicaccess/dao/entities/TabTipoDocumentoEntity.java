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
@Table(name = "tab_tipo_documento")
public class TabTipoDocumentoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727841777642139774L;

	@Id
	@TableGenerator(name = "TAB_TP_DOCGENERATOR", table = DataDictionary.TABLE_NAME_GENERATOR, pkColumnName = DataDictionary.COLUMN_NAME_GENERATOR, valueColumnName = DataDictionary.COLUMN_VALUE_GENERATOR, pkColumnValue = "TAB_TIPO_DOCUMENTO", allocationSize = 1)
	@GeneratedValue(generator = "TAB_TP_DOCGENERATOR")
	@Column(name = "id_tipo_documento")
	private Long id;

	@Column(name = "cod_tipo_documento")
	private String cdTipoDocumento;

	@Column(name = "descr_tipo_documento")
	private String dsTipoDocumento;

	@Column(name = "fl_pessoa")
	private Character flPessoa;
	// 'a=ambos\nf=física\nj=jurídica'

	@Column(name = "mask_tipo_documento")
	private String maskTipoDocumento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCdTipoDocumento() {
		return cdTipoDocumento;
	}

	public void setCdTipoDocumento(String cdTipoDocumento) {
		this.cdTipoDocumento = cdTipoDocumento;
	}

	public String getDsTipoDocumento() {
		return dsTipoDocumento;
	}

	public void setDsTipoDocumento(String dsTipoDocumento) {
		this.dsTipoDocumento = dsTipoDocumento;
	}

	public Character getFlPessoa() {
		return flPessoa;
	}

	public void setFlPessoa(Character flPessoa) {
		this.flPessoa = flPessoa;
	}

	public String getMaskTipoDocumento() {
		return maskTipoDocumento;
	}

	public void setMaskTipoDocumento(String maskTipoDocumento) {
		this.maskTipoDocumento = maskTipoDocumento;
	}

}
