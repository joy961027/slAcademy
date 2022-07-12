package jdbc_package;

import java.sql.*;


public class jdbc_play {

	    public static void main(String[] args) throws SQLException{
	    	//jdbc 드라이버를 로딩하고 접속하는 과정이 필요함.
	        Connection conn;
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");
	        System.out.println("접속완료");
	        //////////////////////////////////
	        //jdbc를 이용해서 어던작업(저장/검색/삭제/수정)을 실행하는 부분
	        //jdbc는 프리페어드라는 기능을 사용할수있음.(password)
	        //이기능은 sql명령어에서 특정한부분(데이터가 들어가는)을 변수처리한다음,
	        //나중에 채워넣는 방식임
	        
	        
//	        String sql = "INSERT INTO table_sample (m_name,m_phone) VALUES(? , ? )"; //INSERT문
//	        String sql = "DELETE FROM table_sample"; //DELETE문 
	        String sql = "SELECT * FROM table_sample"; //SELECT 문
	        
	       // PreparedStatement p_stmt;
	        Statement p_stmt;
	        p_stmt = conn.createStatement(); // select문사용
//	        p_stmt = conn.prepareStatement(sql); //insert문 사용
	        

//	        p_stmt.setString(1, "park"); //insert문 사용
//	        p_stmt.setString(2, "01063980476");//insert문 사용
//	        p_stmt.execute();//insert문 사용
	        ResultSet rs = p_stmt.executeQuery(sql);// select문사용
	        
//	        서버로 sql명령어를 전송한다
	        while(rs.next()) {// select문사용
	    
	        //jdbc 사용시 발생할수있는 exception 추가요망
	        String name =rs.getString("m_name");// select문사용
	        String phone = rs.getString("m_phone");// select문사용
	        System.out.println(name + " " +phone);// select문사용

	        }
	    }
	}
