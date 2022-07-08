package MemberInfo_Package;

import java.util.Scanner;

public class VIP extends Member {
	protected boolean mGender=true; //true : 남성 //false : 여성
	protected String tmpmGender=null;
	protected String mAddress=null;
	protected int mAge=0;

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
		while(true) {
			System.out.print("성별을 입력해주세요 \n예 : male/female  : ");
			tmpmGender = input.nextLine();
			if(tmpmGender.equals("male")) {
				mGender=true;
			}else if(tmpmGender.equals("female")) { 
				mGender=false;
			}else {
				System.out.println("male또는 female을 적어주세요");
			}
			break;
		}
		System.out.print("주소를 입력해주세요 : ");
		mAddress = input.nextLine();
		System.out.print("나이를 입력해주세요 : ");
		mAge = input.nextInt();
		input.nextLine();
	}
	
	public void putMemberInfo() {
		System.out.println(mName + " " + mId + " " + mPass + " " + mPhone+" " + tmpmGender +" " + mAddress+" " + mAge);
		
	}


}
