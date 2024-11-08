package com.javaex.ex07;

// 쪼개서 순서로 나열해보면
// 친구 객제를 3개 만들어야함. 프렌드[] <배열을 써야지
// 3번 돌아야하니까. 프렌트[3] / 총 방이 3개니까 길이는 3-1
// 각각 네임, 나이, 학교 를 입력받아야함
// 프렌드 객체를 생성 
// 배열의 반복, 추가 (이걸 총 3번 돌면 됨)
// 루프 돌기 
// 프렌드 객체 추출하기(뽑아내기)
// 출력코드 부르기
public class Friend {
	// 필드가 필요하지
    private String name;
    private String hp;
    private String school;
    
    // 기본 생성자 만들기 
    public Friend(String name, String hp, String school) {
    	this.name=name;
    	this.hp=hp;
    	this.school=school;
    }
   
    // getter/setter 작성
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name=name;
    }
    
    public String getHp() {
    	return hp;
    }
    
    public void setHp(String hp) {
    	this.hp =hp;
    }
    
    public String getSchool() {
    	return school;
    }
    
    public void setSchool(String school) {
    	this.school =school;
    }
    
    // 일반 메서드
    public void showInfo(){
        System.out.println("이름:"+name+", 핸드폰:"+hp+", 학교:"+school);
    }

}
