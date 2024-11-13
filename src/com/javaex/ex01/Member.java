package com.javaex.ex01;

public class Member {

	private String name;
	private String Id;
	private int point;
	
	public Member(String name, String Id, int point) {
		this.name=name;
		this.Id=Id;
		this.point=point;
	}
	
	
	
	public String getname() {
		return name;
	}
	
	public String getId() {
		return Id;
	}
	
	public int getpoint() {
		return point;
	}
	
	public void show() {
		System.out.println("회원 정보: "+name+"("+Id+"), "+point+"점");
	}
	
	
	
}
