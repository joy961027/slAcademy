package MemberInfo_Package;

import java.sql.Connection;
import java.sql.SQLException;


public class MemberInfo_Play {


	public static void main(String[] args) throws SQLException{
//		
//		MemberInfo m = new MemberInfo();
//		Connection c = m.ConnectDB();
//		//m.InsertMember(m.ConnectDB());
//		m.SelectMember(c);
//		
		
		
	}// end of main


	public static void cls() { // cmd창에서 cls하기 
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception e) {
			System.out.println("cls에러");
		}
	}

	public static void pause() { // cmd창에서 pause하기
		try {
			new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
		}catch(Exception e) {
			System.out.println("pause에러");
		}


	}


}//end of class



/*
}
	int menu=0;   //사용자에게 입력받는 메뉴 번호
	int tmpIdcode = 0; // 특정 회원을 찾는 list.get(tmipIdcode)부분
	String tmpMid=null; // 사용자에게 입력받는 아이디
	String tmpCheck= null;// 사용자에게 입력받는 초기화 할건지 안할건지 선택하는 부분
	int tmpError = 0; // 파일 입출력 받을때 파일이 없으면 에러코드 부분
	boolean checkvalue= false; // 특정 회원을 찾아서 실행하는 부분
	ArrayList<VIP> listvip = new ArrayList<VIP>(); // 어레이리스트 객체
	VIP vip = new VIP(); // 처음객체
	while(true) {
		cls();
		Scanner input = new Scanner(System.in); //스캐너
		////////////////////////메뉴//////////////////////////////////////
		System.out.println("[1] 회원정보 등록");
		System.out.println("[2] 전체회원정보 불러오기");
		System.out.println("[3] 전체회원정보 출력하기");
		System.out.println("[4] 특정회원정보 출력하기");
		System.out.println("[5] 회원정보 전부 초기화");
		System.out.println("[6] 특정회원정보 제거");
		System.out.println("[7] 종료");
		System.out.print("메뉴 선택 : ");
		menu =input.nextInt(); // 메뉴 입력받기
		input.nextLine(); //flush

		switch(menu) {
		case 1: { //1번메뉴
			cls();
			tmpError = 0; //에러코드 초기화
			try {
				FileInputStream fileinputStream = new FileInputStream("D:\\Convenience_Store\\data\\Member.txt");
				//커스텀 클래스(직접제작한 특수한클래스)를 연결시키는부분 
				BufferedInputStream bufferedinputStream = new BufferedInputStream(fileinputStream);
				//최종적으로 객체의 일기(read)를 위한 부분
				ObjectInputStream objectInputSteam = new ObjectInputStream(bufferedinputStream);
				//어레이리스트를 읽어와서 리스트에 연결해준다.
				listvip = (ArrayList<VIP>) objectInputSteam.readObject();
				//			ArrayList<Product> listproduct =(ArrayList<Product>)  objectInputSteam.readObject();
				objectInputSteam.close();//스트림들을 닫는다

				FileOutputStream fileoutputStream = new FileOutputStream("D:\\Convenience_Store\\data\\Member.txt");
				//객체저장스트림(객체를 파일스트림과 연결한다.)-파이프연결
				BufferedOutputStream bufferedoutputStream = new BufferedOutputStream(fileoutputStream);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedoutputStream);
				//저장할객체들의 내용과 그것들을 컨테이너에 저장해둠(고객들의 이름만 저장해본다) 
				vip.setMemberInfo();
				listvip.add(vip);
				//컨테이너에 저장된것들을 통째로 파일에 저장한다.(객체스트림-->파일스트림-->실제파일에 저장)
				objectOutputStream.writeObject(listvip);
				objectOutputStream.close();//스트림들을 닫는다.
				System.out.println("회원정보가 등록되었습니다.");
				pause();
			}catch (Exception e) { // 에러 
				System.out.println("파일이 존재 하지 않습니다.");
				tmpError = -1;
			}finally {
				if(tmpError==-1) {System.out.println("파일을 생성합니다.");
				FileOutputStream fileoutputStream = new FileOutputStream("D:\\Convenience_Store\\data\\Member.txt");
				//객체저장스트림(객체를 파일스트림과 연결한다.)-파이프연결
				BufferedOutputStream bufferedoutputStream = new BufferedOutputStream(fileoutputStream);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedoutputStream);
				//저장할객체들의 내용과 그것들을 컨테이너에 저장해둠(고객들의 이름만 저장해본다) 
				vip.setMemberInfo();
				listvip.add(vip);
				//컨테이너에 저장된것들을 통째로 파일에 저장한다.(객체스트림-->파일스트림-->실제파일에 저장)
				objectOutputStream.writeObject(listvip);
				objectOutputStream.close();//스트림들을 닫는다.
				System.out.println("회원정보가 등록되었습니다.");
				pause();
				}
			}
		}break;
		case 2:{
			cls();
			try {
				//파일과 연결시키는 부분(파일스틞)
				FileInputStream fileinputStream = new FileInputStream("D:\\Convenience_Store\\data\\Member.txt");
				//커스텀 클래스(직접제작한 특수한클래스)ㄹ,ㄹ 연결시키는부분
				BufferedInputStream bufferedinputStream = new BufferedInputStream(fileinputStream);
				//최종적으로 객체의 일기(read)를 위한 부분
				ObjectInputStream objectInputSteam = new ObjectInputStream(bufferedinputStream);
				//어레이리스트를 읽어와서 리스트에 연결해준다.
				listvip = (ArrayList<VIP>) objectInputSteam.readObject();
				//			ArrayList<Product> listproduct =(ArrayList<Product>)  objectInputSteam.readObject();
				objectInputSteam.close();//스트림들을 닫는다
				System.out.println("전체회원정보를 불러왔습니다.");
				pause();
			}catch (Exception e) {
				System.out.println("파일이 존재하지 않습니다.");
				pause();
			}
		}break;
		case 3 :{
			cls();if(listvip.size()!=0) {
				System.out.println("전체회원정보를 출력합니다.");
				for(int idx=0; idx <listvip.size(); idx++){
					listvip.get(idx).putMemberInfo();
				}
			}else {
				System.out.println("회원정보를 먼저 불러와주세요!");
			}

			pause();

		}break;
		case 4 :{
			cls();
			checkvalue=false;
			System.out.println("특정회원정보를 출력합니다.");
			System.out.print("아이디를 입력해주세요 : ");
			tmpMid = input.nextLine();
			for(int idx=0; idx <listvip.size(); idx++){
				if(listvip.get(idx).getMemberId().equals(tmpMid)) {
					checkvalue= true;
					tmpIdcode = idx;
				}
			}
			if(checkvalue) {
				listvip.get(tmpIdcode).putMemberInfo();
			}else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
			pause();
		}break;
		case 5 :{
			cls();
			System.out.println("회원정보를 전부 초기화 메뉴를 선택했습니다.");
			System.out.print("정말로 초기화 하시겠습니까? yes / no :");
			tmpCheck= input.nextLine();
			switch(tmpCheck) {
			case "yes": {
				System.out.println("회원정보를 전부 초기화 합니다.");
				listvip.clear();
				try {
					FileOutputStream fileoutputStream = new FileOutputStream("D:\\Convenience_Store\\data\\Member.txt");
					//객체저장스트림(객체를 파일스트림과 연결한다.)-파이프연결
					BufferedOutputStream bufferedoutputStream = new BufferedOutputStream(fileoutputStream);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedoutputStream);
					//저장할객체들의 내용과 그것들을 컨테이너에 저장해둠(고객들의 이름만 저장해본다) 
					//컨테이너에 저장된것들을 통째로 파일에 저장한다.(객체스트림-->파일스트림-->실제파일에 저장)
					objectOutputStream.writeObject(listvip);
					objectOutputStream.close();//스트림들을 닫는다.
					System.out.println("회원정보를 전부 초기화 완료했습니다.");
				}catch(Exception e) {
					System.out.println("파일이 존재하지 않습니다.");
					pause();
				}

			}break;
			case "no": {
				System.out.println("메인메뉴로 돌아갑니다");
			}break;
			default : {
				System.out.println("yes 아니면 no를 적어주세요");
			}
			}
			pause();
		}break;
		case 6 :{
			cls();
			checkvalue=false;
			System.out.println("특정회원정보를 제거합니다.");
			System.out.print("아이디를 입력해주세요 : ");
			tmpMid = input.nextLine();
			for(int idx=0; idx <listvip.size(); idx++){
				if(listvip.get(idx).getMemberId().equals(tmpMid)) {
					checkvalue= true;
					tmpIdcode = idx;
				}
			}
			if(checkvalue) {
				System.out.print("비밀번호를 입력해주세요 : ");
				tmpMid = input.nextLine();
				if(listvip.get(tmpIdcode).getMemberPass().equals(tmpMid)) {
					listvip.remove(tmpIdcode);
					FileOutputStream fileoutputStream = new FileOutputStream("D:\\Convenience_Store\\data\\Member.txt");
					//객체저장스트림(객체를 파일스트림과 연결한다.)-파이프연결
					BufferedOutputStream bufferedoutputStream = new BufferedOutputStream(fileoutputStream);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedoutputStream);
					//저장할객체들의 내용과 그것들을 컨테이너에 저장해둠(고객들의 이름만 저장해본다) 
					//컨테이너에 저장된것들을 통째로 파일에 저장한다.(객체스트림-->파일스트림-->실제파일에 저장)
					objectOutputStream.writeObject(listvip);
					objectOutputStream.close();//스트림들을 닫는다.
					System.out.println("제거되었습니다.");
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
			pause();

		}break;
		case 7 :{
			cls();
			System.out.println("종료합니다.");
			pause();
			System.exit(0);

		}break;

		default :{
			cls();
			System.out.println("1~7까지의 숫자를 입력해주세요");
			pause();
		}
		}//end of switch


	}// end of while


*/



















/*
////프로그램 코드 동작테스트(Play)
////-Member 클래스로 객체생성
//Member m = new Member();
////-생성된 객체이 회원정보저장
//m.setMemberInfo();
////-저장된 정보들을 각각확인함. (get 계열의 메소드들을 이용해서 정보들을 반환받은후 출력)
////*********************나와의 차이점 리턴받은값을 임시저장해놓기
//String tmpName= m.getMemberName();
//String tmpId= m.getMemberId();
//String tmpPass= m.getMemberPass();
//String tmpPhone= m.getMemberPhone();
//System.out.println(tmpName +" "+ tmpId + " "+ tmpPass+ " "+ tmpPhone);
////-저장된 정보들을 출력함
//m.putMemberInfo();
//*/
//
////=============================================================================
////객체 배열 
////2명의 회원정보 객체를 생성한후 그것들을 객체배열에 저장해준다.(array)
////객체배열(컨테이너)에 저장된것등릉 접근해서 정보저장/반환/출력해준다.
////즉 2명의 회원정보가 처리되어야함.(반복문사용안함)
////Member m1 = new Member();
////Member m2 = new Member();
////Member m3 = new Member();
////Member[] m_box = new Member[3];
//
///*
//m_box[0]=m1;
//m_box[0].setMemberInfo();
//String tmpName1= m_box[0].getMemberName();
//System.out.println("첫번째 멤버 : " + tmpName1);
//m_box[0].putMemberInfo();
//
////-저장된 정보들을 출력함
//
//m_box[1]=m2;
//m_box[1].setMemberInfo();
//String tmpName2= m_box[1].getMemberName();
//System.out.println("두번째 멤버 : " + tmpName2);
//m_box[1].putMemberInfo();
//
//*/
//
////반복문 사용===============================================
///*
//String tmpName = null;
//m_box[0]=m1;
//m_box[1]=m2;
//m_box[2]=m3;
//for(int idx=0; idx<m_box.length; idx++) {
//	m_box[idx].setMemberInfo();
//	tmpName= m_box[idx].getMemberName();
//	System.out.println("너의이름은 : " + tmpName);
//	m_box[idx].putMemberInfo();
//}
//*/
//
////===================================================
////ArrayList
//
///*
//ArrayList pitches = new ArrayList();
//pitches.add("138");//[0]
//pitches.add("129");//[1]
//pitches.add("142");//[2]
//
//System.out.println(pitches.get(0));
//System.out.println(pitches.remove(0));
//System.out.println(pitches.get(0));
//System.out.println(pitches.size());
//if(pitches.contains("142")) {
//	System.out.println("ok");
//};
//pitches.clear();
//System.out.println(pitches.size());
//*/
//
//
////============================================
////우리가 만든 회원정보객체를 arrayList에 저장할수 있도록 코드를 작성해본다.
//ArrayList<Member> m = new ArrayList<Member>();
//Member m1 = new Member();
//Member m2 = new Member();
//m.add(m1);
//m.add(m2);	
//m.get(0).setMemberInfo(); //첫번째 회원의 정보를 셋팅한다.
//m.get(0).putMemberInfo(); //회원정보 출력
//m.get(1).setMemberInfo(); //첫번째 회원의 정보를 셋팅한다.
//m.get(1).putMemberInfo(); //회원정보 출력
//
//System.out.print(m.contains(m1));


















/*
내가한것

public class Play {

	public static void main(String[] args) {
		//프로그램 코드 동작테스트(Play)
//		-Member 클래스로 객체생성
		Member m = new Member();
//		-생성된 객체이 회원정보저장
		m.setMemberInfo();
//		-저장된 정보들을 각각확인함. (get 계열의 메소드들을 이용해서 정보들을 반환받은후 출력)
		System.out.println("회원 이름 : " + m.getMemberName());
		System.out.println("회원 아이디 : " + m.getMemberId());
		System.out.println("회원 비밀번호 : " + m.getMemberPass());
		System.out.println("회운핸드폰번호 : " + m.getMemberPhone());
//		-저장된 정보들을 출력함
		m.putMemberInfo();

	}

}
 */