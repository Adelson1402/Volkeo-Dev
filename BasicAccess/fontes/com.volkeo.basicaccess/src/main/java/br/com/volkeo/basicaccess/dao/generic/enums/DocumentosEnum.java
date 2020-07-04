package br.com.volkeo.basicaccess.dao.generic.enums;

public enum DocumentosEnum {

	CPF("Cpf"), TITULO_ELEITOR("Titulo de Eleitor");

	private String codDocumento;

	DocumentosEnum(String codDoc) {
		this.codDocumento = codDoc;
	}

	public String getCodDocumento() {
		return codDocumento;
	}

	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}

}
