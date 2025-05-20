package com.javaex.ex;

public class PhoneList {
	// 필드
	private String name;
	private String phoneNum;
	private String cpNum;

	// 생성자
	public PhoneList() {}

	public PhoneList(String name, String phoneNum, String cpNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.cpNum = cpNum;
	}

	// 메소드 gs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getCpNum() {
		return cpNum;
	}

	public void setCpNum(String cpNum) {
		this.cpNum = cpNum;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "List [name=" + name + ", phoneNum=" + phoneNum + ", cpNum=" + cpNum + "]";
	}
	
	public void showInfo() {
		System.out.println(name + "   " + phoneNum +  "   " + cpNum );
	}

}
