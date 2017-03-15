package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Adviser;
import service.ServiceActor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String login = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		long log = Long.valueOf(login);
		Adviser adv = ServiceActor.getAdviserByIdAdviser(log);

		RequestDispatcher dispatcher = null;
		if (log == adv.getIdAdviser() && pwd.equalsIgnoreCase(adv.getPwdAdviser())) {

			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20 * 60);
			session.setAttribute("adv", adv);
			dispatcher = request.getRequestDispatcher("/WEB-INF/results/loginSuccess.jsp");

		}

		else {
			dispatcher = request.getRequestDispatcher("/loginError.html");
		}
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
