package com.kfqjs;

import java.util.Scanner;

public class CalcApp {

	// command 패턴과 유사한
	    public static void main(String[] args) {
	        // 스캐너에서 한줄 입력
	        // 공백 구반자로 분할
	        // 첫번째 토큰은 -> 숫자1
	        // 두번재 토큰은 -> 연산자
	        // 세번째 토큰은 -> 숫자2
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	while(true)  {
	    		// 한줄 입력
	    		System.out.println(">> ");
	    		String line = scanner.nextLine();
	    		
	    		if (line.equals("/q")) {
	    			System.out.println("종료합니다.");
	    			break;
	    		}
	    		
	    		String tokens[] = line.split(" ");
	    		int leftnum = Integer.valueOf(tokens[0]);
	    		int rightnum = Integer.valueOf(tokens[2]);
	    		String operator = tokens[1];
	    		
//	    		System.out.println("num:" + leftnum);
//	    		System.out.println("연산자:" +operator);
//	    		System.out.println("num2:" + rightnum);				-- 확인용으로 했던거라, 식 다 짠 지금은 삭제해도 됨요
	    		
	    		switch (operator) {
	    		case "+" : 
	    			Add add = new Add();
	    			add.setValue(leftnum, rightnum);
	    			System.out.println(">> "+add.calculate());
	    			break;
	    			
	    		case "-" : 
	    			Sub sub = new Sub();
	    			sub.setValue(leftnum, rightnum);
	    			System.out.println(">> "+sub.calculate());
	    			break;	
	    			
	    			
	    		case "*" : 
	    			Mul mul = new Mul();
	    			mul.setValue(leftnum, rightnum);
	    			System.out.println(">> "+mul.calculate());
	    			break;	
	    			
	    			
	    		case "/" : 
	    			Div div = new Div();
	    			div.setValue(leftnum, rightnum);
	    			System.out.println(">> "+div.calculate());
	    			break;	
	    			
	    		default :
	    			System.out.println("알 수 없는 연산입니다.");
	    			break;

	    		}
	
	    	}
	    		
		    scanner.close();
	    }
	  
	    
	}
