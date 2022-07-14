package MemberInfo_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/member_db";
			String dbID = "root";
			String dbPassword = "";
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String mId, String mPass) {
		String SQL = "SELECT m_pass FROM member_t WHERE m_id =?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).equals(mPass)) {
					return 1; // 로그인 성공
				}
				else
					return 0; // 비밀번호 불일치 
			}
			return -1;	// 아이디가 없음
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}
}