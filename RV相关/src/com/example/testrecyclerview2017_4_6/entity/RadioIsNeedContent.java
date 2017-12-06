package com.example.testrecyclerview2017_4_6.entity;

public class RadioIsNeedContent {

	private String tv;

	private boolean isSelected;

	public RadioIsNeedContent(String tv, boolean isSelected) {
		super();
		this.tv = tv;
		this.isSelected = isSelected;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
}
