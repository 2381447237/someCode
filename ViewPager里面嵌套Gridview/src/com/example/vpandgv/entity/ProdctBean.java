package com.example.vpandgv.entity;

public class ProdctBean {

	private String name;
	private int url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUrl() {
		return url;
	}

	public void setUrl(int url) {
		this.url = url;
	}

	public ProdctBean(String name, int url) {
		super();
		this.name = name;
		this.url = url;
	}
	
}
