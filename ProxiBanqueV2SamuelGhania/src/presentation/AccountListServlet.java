package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.AccountCurrent;
import metier.AccountSaving;
import metier.BankCard;
import metier.Client;
import service.ServiceAccount;
import service.ServiceActor;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountListServlet")
public class AccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("Identifiant");
		long Id = Long.valueOf(id);
		AccountCurrent ca = ServiceAccount.getCurrentAccountById(Id);
		AccountSaving sa = ServiceAccount.getSavingAccountById(Id);

		BankCard cb = ca.getCard();

		HttpSession session = request.getSession(false);

		session.setAttribute("Card", cb);
		session.setAttribute("ca", ca);
		session.setAttribute("sa", sa);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/results/clientAccountList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
