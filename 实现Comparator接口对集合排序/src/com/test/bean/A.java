package com.test.bean;

public class A {

	private int level;

	public A(int level) {
		super();
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "A [level=" + level + "]";
	}
	
	
	
}
