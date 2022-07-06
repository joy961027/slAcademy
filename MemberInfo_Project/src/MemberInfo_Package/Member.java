package MemberInfo_Package;

import java.util.Scanner;

public class Member {
//	로그인 기능을 클래스로 구현해보자.
//

//	@회원정보클래스(Member)의 구조
//	데이터
//	*회원이름(String), 아이디(String), 암호(String), 핸드폰번호(String);
	String mName, mId, mPass, mPhone ="";

//	*회원정보를 모두 입력받아서 저장할수 있는 기능(setMemberInfo)
	public void setMemberInfo() {
		Scanner input = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		mName= input.nextLine();
		System.out.print("아이디를 입력해주세요 : ");
		mId = input.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		mPass = input.nextLine();
		System.out.print("핸드폰번호를 입력해주세요 : ");
		mPhone = input.nextLine();

	}
//	*모든 회워정보를 출력하는 기능(putMemberInfo).
	public void putMemberInfo() {
		System.out.println(mName + " " + mId + " " + mPass + " " + mPhone);
		
	}
//	*회원정보를 각각 반환(return)하는 기능(정보의 갯수만큼 필요함)
	public String getMemberName() {
		return (mName);
	}
	
	public String getMemberId() {
		return (mId);
	}
	
	public String getMemberPass() {
		return (mPass);
	}
	
	public String getMemberPhone() {
		return (mPhone);
	}


}



/*
내가한것

package MemberInfo_Package;

import java.util.Scanner;

public class Member {
//	로그인 기능을 클래스로 구현해보자.
//

//	@회원정보클래스(Member)의 구조
//	데이터
//	*회원이름(String), 아이디(String), 암호(String), 핸드폰번호(String);
	String MemberName, MemberId, MemberPass, MemberPhone;

//	*회원정보를 모두 입력받아서 저장할수 있는 기능(setMemberInfo)
	public void setMemberInfo() {
		Scanner input = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		MemberName= input.nextLine();
		System.out.print("아이디를 입력해주세요 : ");
		MemberId = input.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		MemberPass = input.nextLine();
		System.out.print("핸드폰번호를 입력해주세요 : ");
		MemberPhone = input.nextLine();

	}
//	*모든 회워정보를 출력하는 기능(putMemberInfo).
	public void putMemberInfo() {
		System.out.println("회원 이름: "+ MemberName);
		System.out.println("회원 아이디: "+ MemberId);
		System.out.println("회원 비밀번호: "+ MemberPass);
		System.out.println("회원 핸드폰번호: "+ MemberPhone);
	}
//	*회원정보를 각각 반환(return)하는 기능(정보의 갯수만큼 필요함)
	public String getMemberName() {
		return MemberName;
	}
	
	public String getMemberId() {
		return MemberId;
	}
	
	public String getMemberPass() {
		return MemberPass;
	}
	
	public String getMemberPhone() {
		return MemberPhone;
	}


}

*/



