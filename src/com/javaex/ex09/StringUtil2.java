package com.javaex.ex09;

public class StringUtil2 {
    										// 문자열 이니까 길이 알 수 있음 
    public static String concatString(String[] strArray){
          // 스태틱은 new 하지 않아도 직접 접근 가능 
    	
    	
       // 방법 2 : 향상된 for문 루프
    	String result = "";
    	
    	// for ( 타입, 변수 : 컬렉션) {}
    	for (String item: strArray) {
    		result += item;
    	}
        
    	return result;
    }

}
