package Park_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParkDAO {
	Connection conn;

	public void ConnectDB() throws SQLException {
		//jdbc 드라이버를 로딩하고 접속하는 과정이 필요함.
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/park_db","root","");

	}
	public void InsertMember(Park park) throws SQLException {
	
		Park p= park;
		String sql = "INSERT INTO park_t (park_number,park_time) VALUES( ? , ? )"; //INSERT문
		//        String sql = "DELETE FROM table_sample"; //DELETE문 
		//        String sql = "SELECT * FROM table_sample"; //SELECT 문
		//        
		PreparedStatement p_stmt;
		p_stmt = conn.prepareStatement(sql); //insert문 사용
		//        Statement p_stmt;
		//        p_stmt = conn.createStatement(); // select문사용


		p_stmt.setString(1, p.getpNumber()); //insert문 사용
		p_stmt.setInt(2, p.getpTime());//insert문 사용

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
	public ArrayList<Park> SelectAll() throws SQLException{
		ArrayList<Park> list = new ArrayList<>();
		String parkNumber;
		int parkTime;
		
		String sql = "SELECT * FROM park_t"; //SELECT 문
		PreparedStatement p_stmt;
		p_stmt = conn.prepareStatement(sql); // select문사용
		ResultSet rs = p_stmt.executeQuery();
		//서버로 sql명령어를 전송한다
		while(rs.next()) {// select문사용
			Park park = new Park();
			//jdbc 사용시 발생할수있는 exception 추가요망
			parkNumber =rs.getString("park_number");// select문사용
			parkTime =rs.getInt("park_time");// select문사용
			park.setpNumber(parkNumber);
			park.setpTime(parkTime);
			list.add(park);
		}
		
	
	

		return list;



	}
	
	public void DeletePark (Park park) throws SQLException{
		Park dpark = park;
		String sql = "DELETE FROM park_t where park_number = ?;"; //SELECT 문
		PreparedStatement p_stmt;
		p_stmt = conn.prepareStatement(sql); // select문사용
		p_stmt.setString(1, dpark.getpNumber()); 
		p_stmt.execute();
		//서버로 sql명령어를 전송한다
		
		conn.close();

	}

}

