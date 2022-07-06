package java_project1_pack;
//스캐너 임포트
import java.util.Scanner;

public class first_class_07_04 {

	public static void main(String[] args) {
		
		//자료형 연습
		/*
		//변수 선언
		int data1 = 0;
		int data2 = 0;
		
		// 입력받기
		Scanner input = new Scanner(System.in);
		System.out.print("정수를 하나 입력해주세요 : "); 
		data1 = input.nextInt();
		System.out.print("정수를 하나 입력해주세요 : "); 
		data2 = input.nextInt();
		
		//자료형 변환
		float result = (float)data1/(float)data2;
		System.out.println(result); //3,5
		//반올림 함수 Math.round()
		float result2 = Math.round(result);
		System.out.println("result2 is "+ result2);
		*/
		
//------------------------------------------------------------------------------------		
		
		//if문 연습
		/*
		String userID;
		String userPW;
		Scanner input = new Scanner(System.in);
		
		//아이디를 입력받아서 저장함 (String 타입)
		System.out.print("Id를 입력해주세요 : "); 
		userID = input.nextLine();
		
		//암호를 입력받아서 저장함 (String 타입)
		System.out.print("암호를 입력해주세요 : "); 
		userPW = input.nextLine();
		
		//입력받은 아이디가 "admin"이면 "관리자"라고 출력함.
		if(userID.equals("admin")) {System.out.println("관리자");}
		
		//입력받은 암호가 "123##" 이면 "ok"라고 출력함
		if(userPW.equals("123##")) {System.out.println("ok");	}
		
		//위에 2가지 조건이 둘다 맞는다면, "로그인되었습니다."라고 출력함. (and)
		if(userID.equals("admin") && userPW.equals("123##")) 
			{System.out.println("로그인되었습니다");}
		else {System.out.println("다시 로그인 해주시기 바랍니다.");}

		
		if(userID.equals("admin")) { //아이디가 "admin"과 같은가?
			if(userPW.equals("123##")) { //암호가 "123##"과 같은가?
				System.out.println("관리자로 로그인되었습니다");}
			else{
				System.out.println("비밀번호가 틀렸습니다.");}} //암호가 틀리면 이게 실행됨
		else if(userPW.equals("123##")){
			System.out.println("아이디가 틀렸습니다.");} //아이디만 틀리면 이게실행됨
		else {System.out.println("아이디와 비밀번호가 틀렸습니다.");} // 둘다 틀리면 이게 실행됨
		
		*/
		
//------------------------------------------------------------------------------------	
		
		//반복문 연습
		/* 내가 한것
		for(int i=1; i<=2; i++)
		{
			System.out.println("www.naver.com");
		}
		
		String userPW;
		Scanner input = new Scanner(System.in);	
		//암호를 입력받아서 저장함 (String 타입)
		System.out.print("암호를 입력해주세요 : "); 
		userPW = input.nextLine();
		
		for(int i=1; i<=3; i++) 
		{
			if(userPW.equals("123##")) { //암호가 "123##"과 같은가?
				System.out.println("비밀번호가 일치합니다."); 
				break;} //일치하면 for문 탈출
			else if(i==3) { //3번물어보면 로그인 불가
				System.out.println("비밀번호를 " + i +"번 틀려 더이상 로그인 할 수 없습니다.");}
			else{
				System.out.println("비밀번호를 " + i +"번 틀렸습니다.");
				System.out.print("암호를 다시 입력해주세요 : "); //암호 다시입력
				userPW = input.nextLine();}
		
		}
		*/
		
		//강사님 샘플
		String userPW;
		Scanner input = new Scanner(System.in);	
		//암호를 입력받아서 저장함 (String 타입)
		
		for(int i=1; i<=3; i++) 
		{
			System.out.print("암호를 입력해주세요 : "); 
			userPW = input.nextLine();
			
			if(userPW.equals("123##")) {System.out.println("비밀번호가 일치합니다."); 
			break;} 
			else { 
				if(i<3) {continue;}
			}

		}
	}//end of main()
}//end of class
