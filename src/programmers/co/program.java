package programmers.co;

import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        

        for (int i = 0; i<a.length(); ++i) {
            if(Character.isLowerCase(a)) {
                System.out.println(Character.toUpperCase(a));
            } else {
                System.out.println(Character.toLowerCase(a));
            } 
        }
        
        
    }
}