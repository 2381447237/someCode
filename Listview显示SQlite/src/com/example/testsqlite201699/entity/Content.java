package com.example.testsqlite201699.entity;

public class Content {

	public String number;
	public String name;
	public String phone;
	public String time;
	public Content(String number, String name, String phone, String time) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.time = time;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
