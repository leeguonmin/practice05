package com.javaex.ex07;

import java.util.Scanner;

public class FriendApp {

    public static void main(String[] args) {

        Friend[] friendArray = new Friend[3];
        Scanner sc = new Scanner(System.in);

        System.out.println("친구를 3명 등록해 주세요");

        
        
        //for문 시작
        //친구정보 3명 입력 로직 --> 반복문 사용
        for (int i=0; i<friendArray.length; ++i) {	// 3번 돌린다고
        	// 이제 입력 받아야 해 
        	String name, hp, school; 	
        	
        	System.out.println("이름: ");
//        	name = scanner.next();
        	name = sc.next();	// name으로 입력 받아야함 (이거 이젠 알아야한다고, 모르면 안된다고하시는데 진짜 모르겠다)
        	System.out.println("핸드폰: ");
        	hp=sc.next();		// hp로 받아야함 
        	System.out.println("학교:");
        	school=sc.next();	// school로 받아야함
        	
        	
            Friend f = new Friend(name, hp, school);  // 초기화 시키는거지 이거?
            friendArray[i] = f;		
            
            System.out.println("---------------------");
        	
        //for문 끝
        }			
        
        
        
  //-----------------------------출력---------//       
        // 친구정보 출력
        for (int i = 0; i < friendArray.length; i++) {
            //친구정보 출력 메소드 호출
        	Friend f = friendArray[i];
        	f.showInfo();  
        	
        }

        sc.close();
    }

}
