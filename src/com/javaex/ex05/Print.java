package com.javaex.ex05;

public class Print {
	
	
	// 매소드 세개
	private int x;
	
	public void print (int x) {	// void를 추가해서 초기화시킨다는걸 알려줘야하ㅣㅁ? 보이드 뭐야
		// 초기화
		this.x = x;
	}
	

	
    public void printer(int val){
        System.out.println(val);
    }
    
    public void printer(boolean val) {
    	System.out.println(val);
    }
    
    public void printer(double val) {
    	System.out.println(val);
    }
    
    public void printer(String val) {
    	System.out.println(val);
    };

    
}









//public class Print {
//
//    // 멤버 변수 선언
//    private int i;
//    private String t;
//    private double o;
//    private String name;
//    private int x;
//    private int y;
//
//    // 생성자 정의
//    public Print(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    // 오버로딩된 printer 메서드들
//    public void printer(int val) {
//        System.out.println(val);
//    }
//
//    public void printer(boolean val) {
//        System.out.println(val);
//    }
//
//    public void printer(double val) {
//        System.out.println(val);
//    }
//
//    public void printer(String val) {
//        System.out.println(val);
//    }
//}