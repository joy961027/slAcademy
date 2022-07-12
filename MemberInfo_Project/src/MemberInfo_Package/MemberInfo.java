package MemberInfo_Package;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MemberInfo implements Serializable {
	//	로그인 기능을 클래스로 구현해보자.
	//

	//	@회원정보클래스(Member)의 구조
	//	데이터
	//	*회원이름(String), 아이디(String), 암호(String), 핸드폰번호(String);
	protected String mName;
	protected String mPhone ="";
	protected String mId;
	protected String mPass;


	//	*회원정보를 모두 입력받아서 저장할수 있는 기능(setMemberInfo)
	public void setMemberInfo() 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		mName= input.nextLine();
		System.out.print("핸드폰번호를 입력해주세요 : ");
		mPhone = input.nextLine();
		System.out.print("아이디를 입력해주세요 : ");
		mId = input.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		mPass = input.nextLine();
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


	// 데이터베이스에 접속하고 SQL을 처리하는 메소드를 가지고있음.
	public Connection ConnectDB() throws SQLException {
		//jdbc 드라이버를 로딩하고 접속하는 과정이 필요함.
		Connection conn;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member_db","root","");

		return conn;


	}
	public void InsertMember(Connection c) throws SQLException {
		Connection conn=c;
		String sql = "INSERT INTO member_t (m_name,m_phone,m_id,m_pass) VALUES(? , ? , ? , ? )"; //INSERT문
		//        String sql = "DELETE FROM table_sample"; //DELETE문 
		//        String sql = "SELECT * FROM table_sample"; //SELECT 문
		//        
		PreparedStatement p_stmt;
		p_stmt = conn.prepareStatement(sql); //insert문 사용
		//        Statement p_stmt;
		//        p_stmt = conn.createStatement(); // select문사용



		setMemberInfo();
		p_stmt.setString(1, mName); //insert문 사용
		p_stmt.setString(2, mPhone);//insert문 사용
		p_stmt.setString(3, mId); //insert문 사용
		p_stmt.setString(4, mPass);//insert문 사용

		p_stmt.execute();//insert문 사용
		//		ResultSet rs = p_stmt.executeQuery(sql);// select문사용
		//
		//서버로 sql명령어를 전송한다
		//		while(rs.next()) {// select문사용
		//
		//			//jdbc 사용시 발생할수있는 exception 추가요망
		//			String name =rs.getString("m_name");// select문사용
		//			String phone = rs.getString("m_phone");// select문사용
		//			System.out.println(name + " " +phone);// select문사용
		conn.close();


	}
	public void SelectMember (Connection c) throws SQLException{
		Connection conn = c;
		String tmpId;
		String sql = "SELECT * FROM member_t where m_name = ?;"; //SELECT 문
		PreparedStatement p_stmt;
		p_stmt = conn.prepareStatement(sql); // select문사용
		Scanner input = new Scanner(System.in);
		System.out.print("검색할 이름을 입력해주세요: ");
		tmpId= input.nextLine();
		p_stmt.setString(1, tmpId); 
		ResultSet rs = p_stmt.executeQuery();
		//서버로 sql명령어를 전송한다
		int row=0;
		while(rs.next()) {// select문사용

			row =rs.getRow();
			//jdbc 사용시 발생할수있는 exception 추가요망
			String name =rs.getString("m_name");// select문사용
			String phone = rs.getString("m_phone");// select문사용
			String id = rs.getString("m_id");// select문사용
			String pass = rs.getString("m_pass");// select문사용
			System.out.println(name + " " +phone + " " +id + " " +pass );// select문사용
		}
		
		if(row==0) {
			System.out.println("검색한 이름이 존재하지 않습니다.");
		}
		conn.close();




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



