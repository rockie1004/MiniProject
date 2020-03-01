package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListAuthor;
import model.ListBook;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public addBookServlet() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");

		// Last Read Date
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate lastRead;
		try {
			lastRead = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			lastRead = LocalDate.now();
		}

		// author
		String authorEntered = request.getParameter("author");
		System.out.println("title" + title + " authorEntered " + authorEntered);
		ListAuthorHelper arthelper = new ListAuthorHelper();
		List<ListAuthor> matchAuthors = arthelper.searchForAuthorByName(authorEntered);
		if (matchAuthors.isEmpty()) {// if no match, add new author to the database then get that entry from the
										// database so we know the id.
			ListAuthor selectedAuthor = new ListAuthor();
			selectedAuthor.setAuthorName(authorEntered);
			arthelper.insertAuthor(selectedAuthor);
			matchAuthors = arthelper.searchForAuthorByName(authorEntered);
		}
		ListAuthor updatedAuthor = matchAuthors.get(0);
		//
		ListBook li = new ListBook(updatedAuthor, title, lastRead);
		ListBookHelper dao = new ListBookHelper();
		dao.insertBook(li);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
