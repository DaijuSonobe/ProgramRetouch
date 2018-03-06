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

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		if(password1.equals("") && password2.equals("") && !name.equals("") && !birthDate.equals("")) {

			MyUserDao myUserDao = new MyUserDao();
			myUserDao.updateUserInfo(id, password3, name, birthDate);

			response.sendRedirect("MyUserListServlet");

			return;

		}else if(!password1.equals("") && password2.equals("") && !name.equals("") && !birthDate.equals("")) {

			MyUserDao myUserDao = new MyUserDao();
			myUserDao.updateUserInfo(id, password1, name, birthDate);

			response.sendRedirect("MyUserListServlet");

			return;

		}else if(password1.equals("") && !password2.equals("") && !name.equals("") && !birthDate.equals("")) {

			MyUserDao myUserDao = new MyUserDao();
			myUserDao.updateUserInfo(id, password2, name, birthDate);

			response.sendRedirect("MyUserListServlet");

			return;

		}else if(!password1.equals(password2) || name.equals("") || birthDate.equals("")) {

			request.setAttribute("errMsg", "Update Failed.");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp");
			dispatcher.forward(request, response);

			return;

		}

		MyUserDao myUserDao = new MyUserDao();
		myUserDao.updateUserInfo(id, password1, name, birthDate);

		response.sendRedirect("MyUserListServlet");

	}

}
