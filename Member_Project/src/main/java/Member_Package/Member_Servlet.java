package Member_Package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Member_Servlet
 */
@WebServlet("/Member_Servlet")
public class Member_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Member_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {

		System.out.println("init 작동됨");

	}

	//자원소멸을 담당하는 destroy()

	//사용자가 전달한 데이터를 받아서 처리하는 doGet()

	public void doGet(HttpServletRequest req, HttpServletResponse resp)

	{

		System.out.println("doGet 작동");

	}

	//또다른 방식으로 받아서 처리하는 doPost()

}