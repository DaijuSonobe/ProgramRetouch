package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class MyUserListServlet
 */
@WebServlet("/MyUserListServlet")
public class MyUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyUserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		MyUser user = (MyUser)session.getAttribute("userInfo");

		if(user == null) {

			response.sendRedirect("MyLoginServlet");

			return;
		}

		MyUserDao myUserDao = new MyUserDao();
		List<MyUser> userList = myUserDao.findAll();;

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDate1 = request.getParameter("date1");
		String birthDate2 = request.getParameter("date2");

		MyUserDao myUserDao = new MyUserDao();
		List<MyUser> userList = myUserDao.findSearch(loginId, name, birthDate1, birthDate2);

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);

	}

}