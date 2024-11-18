package com.javaex.ex09;

public class StringUtil {
    										// 문자열 이니까 길이 알 수 있음 
    public static String concatString(String[] strArray){
          // 스태틱은 new 하지 않아도 직접 접근 가능 
    	
    	
    	// 방법 1
       String result = "";		// 비워두고
       
       
      for (int i =0; i<strArray.length; ++i) {
    	  	// strArray[i];  // strArray 방에 들어가서 i번째 있는 애한테 너 나와
    	  result += strArray[i];
      }
      
      return result;

        
    }

}
