package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();
		MyUser user = (MyUser)session.getAttribute("userInfo");

		if(user == null) {

			response.sendRedirect("MyLoginServlet");

			return;
		}


		String id = request.getParameter("id");

		System.out.println(id);

		MyUserDao myUserDao = new MyUserDao();
		MyUser myUser = myUserDao.findByLoginInfo(id);

		request.setAttribute("user", myUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String updateDate = request.getParameter("updateDate");

		MyUserDao myUserDao = new MyUserDao();
		myUserDao.updateUserInfo(id, password, name, birthDate, updateDate);

		response.sendRedirect("MyUserListServlet");

	}

}
