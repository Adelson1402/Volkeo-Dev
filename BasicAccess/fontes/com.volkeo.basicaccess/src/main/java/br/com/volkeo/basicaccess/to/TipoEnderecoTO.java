package br.com.volkeo.basicaccess.to;

import java.io.Serializable;

public class TipoEnderecoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6471200601956695819L;

	private Long id;

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
