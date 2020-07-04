package br.com.volkeo.basicaccess.to;

import java.io.Serializable;

public class TipoDocumentoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3497365734109959331L;

	private Long id;

	private String cdTipoDocumento;

	private String dsTipoDocumento;

	private Character flPessoa;
	// 'a=ambos\nf=física\nj=jurídica'

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
