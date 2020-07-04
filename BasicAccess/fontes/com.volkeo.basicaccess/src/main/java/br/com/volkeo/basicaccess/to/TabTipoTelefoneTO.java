package br.com.volkeo.basicaccess.to;

import java.io.Serializable;

public class TabTipoTelefoneTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964944507806281915L;

	private Long id;

	private String dsTipo;

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
