package ehtjrhksfl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 *  // 기본 테이블
 *  
 * -- 멤버 테이블
CREATE TABLE Customers (
    Customers_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(100) UNIQUE,
    birth_date DATE
    name_id VARCHAR(45)
    password VARCHAR(255),
    address VARCHAR(255),
    Customerscol VARCHAR(45)															join_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 도서 정보 테이블
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200),
    author VARCHAR(45),
    type VARCHAR(45),
    publisher VARCHAR(45),
    pub_date DATE,
    rate INT
    stork INT
    location_id INT
	isbn VARCHAR(200)
	category_id INT
	
    FOREIGN KEY (category_id) REFERENCES categories(category_id),
    FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id)
);

-- 카테고리 테이블
CREATE TABLE categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT
    // 카테고리 번호
    name VARCHAR(50)
    // 카테고리 이름
);

-- 출판사 정보 테이블
CREATE TABLE publishers (
    publisher_id INT PRIMARY KEY AUTO_INCREMENT
    // 출판사 아이디.... 번호... 식별코드? 음
    name VARCHAR(100),
    // 출판사 이름
);

-- 저자 정보 테이블
CREATE TABLE authors (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

-- 도서랑 저자 연결 테이블
CREATE TABLE book_authors (
    book_id INT,
    author_id INT,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);


-- 대여 정보 테이블
CREATE TABLE Rental (
    rental_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    customer_id INT,
    return_date DATETIME,
    return_date DATETIME
);
 * 
 * 
 * -----------------------------------------------------------
 * 
 * 
 * 
 * 
 * -- 책 제목과 저자명 조회 join 예
SELECT b.title, a.name
FROM books b
JOIN book_authors ba ON b.book_id = ba.book_id
JOIN authors a ON ba.author_id = a.author_id;
 * 
 * 
 * 
 * -- 카테고리의 책 목록 조회 join 예
SELECT b.title, c.name
FROM books b
JOIN categories c ON b.category_id = c.category_id
WHERE c.name = '소설';
 * 
 * 
 * 
 * -- 특정 고객이 대여한 책 목록 조회 join 예
SELECT b.title, m.name
FROM books b
JOIN Rental re ON b.book_id = re.book_id
JOIN Customers m ON re.member_id = cu.member_id
WHERE cu.member_id = 1;  
-- 회원 ID 1번에 해당하는 회원
 * 
 * 
 * 
 * 
 * 
 * 
 * -- 미반납 도서 목록 조회 join 예
SELECT b.title, m.name, re.rental_date
FROM books b
JOIN Rental re ON b.book_id = re.book_id
JOIN Customers cu ON re.member_id = cu.member_id
WHERE re.actual_return_date IS NULL;
------------------------------------------------------------
 * 
 * -- 도서관 실시산 좌석 정보 
1. 새 테이블 
CREATE TABLE seats (
    seat_id INT PRIMARY KEY AUTO_INCREMENT,
    seat_number VARCHAR(10),
    seat_tf BOOLEAN
    //	TRUE: 누가 사용 중, FALSE: 자리 비어 있음
);


// 조회 쿼리
SELECT * FROM seats WHERE is_occupied = FALSE;
 * 
 * 
 * 
 * 
 * 
 * 
 * */
    
class User {
    String id;
    String password;
    String name;
    String email;
    String address;

    // 생성자, getter, setter 등
}

class Books {
    String title;
    String author;
    // ... 다른 책 정보들
	public void setReserved(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setStock(int i) {
		// TODO Auto-generated method stub
		
	}
	public int getStock() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPublisher() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
}


class Seat {
    private int seatNumber;
    private boolean isOccupied;

    // 생성자, getter/setter 등
}


public class LibrarySystem {
    static ArrayList<User> users = new ArrayList<>(); // 회원 정보 저장
    static ArrayList<Books> books = new ArrayList<>(); // 도서 정보 저장 

    
    
    
	public class Library {

		public static void main(String[] args) {
		}
		
		private static void showMainMenu() {
	        System.out.println("1. 책 검색");
	        System.out.println("2. 책 대여");
	        System.out.println("3. 프로그램 종료");
	    }
		
		
		
// 도서 검색
	public static void searchBooks() {
		Scanner scanner = new Scanner(System.in);
	    System.out.print("검색할 책의 제목, 저자 또는 출판사를 입력하세요: ");
	    String keyword = scanner.nextLine();

	    List<Books> results = new ArrayList<>();
	    for (Books book : books) {
	        if (book.getTitle().contains(keyword) ||
	                book.getAuthor().contains(keyword) ||
	                book.getPublisher().contains(keyword)) {
	            results.add(book);			// contains 문자열에서 특정 문자열이 있는지 확인하는 메서드
	        }
	    }

	    // 검색 결과 출력
	    if (results.isEmpty()) {
	        System.out.println("검색 결과가 없습니다.");
	    } else {
	        System.out.println("검색 결과:");
	        for (Books book : results) {
	            System.out.println("제목: " + book.getTitle() + ", 저자: " + book.getAuthor());
	        }
	       
	    }
	}
		

// 책 서치, 대여 확인, 예약 
	public static void bookRent(String keyword) {
        Books book = findBook(keyword);
        if (book == null) {
            System.out.println("해당 책의 재고가 없습니다.");
            return;
        }

        if (book.getStock() > 0) { // 재고 확인
            System.out.println("재고가 있습니다. 대여하시겠습니까? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
            	book.setStock(0); // 재고 없음으로 변경
                System.out.println("대여가 완료되었습니다. 7일 이내 반납해주세요.");
            } else {
                System.out.println("대여를 취소했습니다.");
            }
        } else {
            System.out.println("이미 대여된 책입니다. 예약하시겠습니까? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                // 예약 처리 로직
                book.setReserved(true);	// 예약되었음요
            } else {
                System.out.println("메인 페이지로 돌아갑니다.");
            }
        }
	}
	
	
// 로그인, 회원가입 	
	public static void loginpass() {
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 로그인\n2. 회원가입\n3. 종료");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    static void login(Scanner scanner) {
        while (true) {
            System.out.println("1. 로그인\n2. 회원가입");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }
        }
    	
     static void login(Scanner scanner) {      
    	System.out.print("아이디를 입력하세요: ");
        String id = scanner.next();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                System.out.println("로그인 성공!");
                // 도서 검색 페이지로 이동 (실제로는 다른 메소드 호출)
                searchBooks(scanner);
                return;
            }
        }
     }

        
        // 회원가입
        static void register(Scanner scanner) {       
        System.out.print("회원가입을 하시겠습니까? (y/n): ");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("y")) {
            registers(scanner);
        }
    }
        
    }

    void registers(Scanner scanner) {
    	System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.nextLine();
        System.out.print("주소를 입력하세요: ");
        String address = scanner.nextLine();
        System.out.print("아이디를 입력하세요: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();
        
        
     // 중복 아이디 확인
        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println("이미 존재하는 아이디입니다.");
                return;
            }
        }

        // 회원 정보 저장
        users.add(new User(id, password, name, email, address));
        System.out.println("회원가입이 완료되었습니다.메인 메뉴로 이동합니다");
    }


// 책 추가
    static void addBook(Scanner scanner) {
        System.out.print("도서 제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("저자를 입력하세요: ");
        String author = scanner.nextLine();
        System.out.print   
    ("ISBN을 입력하세요: ");
        String isbn = scanner.nextLine();
        System.out.print("출판 연도를 입력하세요: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 중복 확인 (ISBN 기준)
        for (Books book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println("이미 존재하는 도서입니다.");
                return;
            }
        }

        // 도서 목록에 추가
        books.add(new Books(title, author, isbn, publicationYear));
        System.out.println("도서가 추가되었습니다.");
    }
    
    
 // 좌석 확인
    public class SeatReservation {
    	Scanner scanner = new Scanner(System.in);
        int[] seats = new int[10]; // 총 10개 좌석 (0: 비어있음, 1: 예약됨)

        while (true) {
            System.out.println("1. 좌석 확인\n2. 좌석 예약\n3. 좌석 반납\n4. 프로그램 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("확인할 좌석 번호를 입력하세요: ");
                    int seatNumber = scanner.nextInt();
                    if (seatNumber >= 1 && seatNumber <= 10) {
                        if (seats[seatNumber - 1] == 0) {
                            System.out.println("좌석 " + seatNumber + "은 사용 가능합니다.");
                        } else {
                            System.out.println("좌석 " + seatNumber + "은 이미 예약되었습니다.");
                        }
                    } else {
                        System.out.println("잘못된 좌석 번호입니다.");
                    }
                    break;
                case 2:
                    System.out.print("예약할 좌석 번호를 입력하세요: ");
                    seatNumber = scanner.nextInt();
                    if (seatNumber >= 1 && seatNumber <= 10) {
                        if (seats[seatNumber - 1] == 0) {
                            seats[seatNumber - 1] = 1;
                            System.out.println("좌석 " + seatNumber + " 예약 완료");
                        } else {
                            System.out.println("이미 예약된 좌석입니다.");
                        }
                    } else {
                        System.out.println("잘못된 좌석 번호입니다.");
                    }
                    break;
                case 3:
                    // 좌석 반납 로직은 비슷하게 구현
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
            }
        }
	

	}
	}
}
