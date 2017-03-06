package com.leandro.pokedex;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.io.Serializable;

public class Pokemon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long number;
	private String name;
	
	public Pokemon() { }
	
	public Pokemon(Long resultNumber, String name) {
		this.number = resultNumber;
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}
	
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isValid() {
		return number != null && isNotBlank(name);
	}
	
}
