package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListAuthor;

/**
 * Servlet implementation class editAuthorServlet
 */
@WebServlet("/editAuthorServlet")
public class editAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editAuthorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ListAuthorHelper dao = new ListAuthorHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListAuthor authorToUpdate = dao.searchForAuthorById(tempId);
		String authorEntered = request.getParameter("authorName");
		// set fields to newly entered strings
		authorToUpdate.setAuthorName(authorEntered);
		// update the entry with matching ID to match this object
		dao.updateAuthor(authorToUpdate);

		getServletContext().getRequestDispatcher("/viewAllAuthorsServlet").forward(request, response);

	}

}
