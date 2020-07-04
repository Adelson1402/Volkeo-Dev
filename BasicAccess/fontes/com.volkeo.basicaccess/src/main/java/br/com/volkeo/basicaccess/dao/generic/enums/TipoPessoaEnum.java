package br.com.volkeo.basicaccess.dao.generic.enums;

public enum TipoPessoaEnum {

	FISICA('F'), JURIDICA('J');

	private char id;
	

	private TipoPessoaEnum(char id) {
		this.id = id;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	
}
