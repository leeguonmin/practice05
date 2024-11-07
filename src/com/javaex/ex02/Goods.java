package com.javaex.ex02;

public class Goods {

	private String name;
	private int price;
	
	// 기본 생성자 추가해야 Goods camera = new Goods(); 부분에 오류 안남 
	public Goods() {
		
	}
	
	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
		
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void show() {
		System.out.printf("상품명: "+name+", 가격:"+price);
	}
}




