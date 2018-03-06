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
 * Servlet implementation class MyUserRegisterServlet
 */
@WebServlet("/MyUserRegisterServlet")
public class MyUserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyUserRegisterServlet() {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("userNm");
		String birthDate = request.getParameter("birthDate");

		MyUserDao myUserDao = new MyUserDao();

		boolean x = myUserDao.findByLoginIdInfo(loginId);

		if(x == true) {

			request.setAttribute("errMsg", "Registration Failed.");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
			dispatcher.forward(request, response);

			return;

		}else if(!password1.equals(password2) || password1.equals("") || password2.equals("") || name.equals("") || birthDate.equals("")) {

			request.setAttribute("errMsg", "Registration Failed.");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
			dispatcher.forward(request, response);

			return;

		}


		myUserDao.registerUser(loginId, name, birthDate, password1);

		response.sendRedirect("MyUserListServlet");

	}

}
