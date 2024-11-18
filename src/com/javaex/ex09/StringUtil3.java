package com.javaex.ex09;

public class StringUtil3 {
    										// 문자열 이니까 길이 알 수 있음 
    public static String concatString(String[] strArray){
          // 스태틱은 new 하지 않아도 직접 접근 가능 
    	
    	
       // 방법 3. 문자열 돌리는 기능 사용
    	String result = "";
    	
    	result = String.join("", strArray);

        
    	return result;
    }

}
