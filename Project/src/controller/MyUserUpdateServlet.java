package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyUserDao;
import model.MyUser;

/**
 * Servlet implementation class MyUserUpdateServlet
 */
@WebServlet("/MyUserUpdateServlet")
public class MyUserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyUserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id");

		System.out.println(id);

		MyUserDao myUserDao = new MyUserDao();
		MyUser user = myUserDao.findByLoginInfo(id);

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		System.out.println(id);

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Date birthDate = request.getParameter("birthDate");
		String createDate = request.getParameter("updateDate");

//		MyUserDao myUserDao = new MyUserDao();
//		MyUser user = myUserDao.findByLoginInfo(loginId, password);
//
//		if(user == null) {
//
//			request.setAttribute("errMsg", "Failed Login attempt.");
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//			dispatcher.forward(request, response);
//
//			return;
//		}

		response.sendRedirect("MyUserListServlet");

	}

}
