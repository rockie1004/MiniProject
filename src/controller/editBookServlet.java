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
 * Servlet implementation class editBookServlet
 */
@WebServlet("/editBookServlet")
public class editBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ListBookHelper dao = new ListBookHelper();
		String updatedTitle = request.getParameter("title"); 
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate updatedDate;
		try {
			updatedDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			updatedDate = LocalDate.now();
		}
		ListBook bookToUpdate = dao.searchForBookById(tempId);

		ListAuthorHelper arthelper = new ListAuthorHelper();
		String authorEntered = request.getParameter("author");  
		List<ListAuthor> matchAuthors = arthelper.searchForAuthorByName(authorEntered);
		if(matchAuthors.isEmpty()) {//if no match, add new author to the database then get that entry from the database so we know the id.
			ListAuthor selectedAuthor= new ListAuthor();
			selectedAuthor.setAuthorName(authorEntered);
			arthelper.insertAuthor(selectedAuthor);
			matchAuthors = arthelper.searchForAuthorByName(authorEntered);
		}
		ListAuthor updatedAuthor = matchAuthors.get(0);
		bookToUpdate.setTitle(updatedTitle);
		bookToUpdate.setAuthor(updatedAuthor);
		bookToUpdate.setLastRead(updatedDate);
		
		dao.updateBook(bookToUpdate);
		
		
		getServletContext().getRequestDispatcher("/viewAllBooksServlet").forward(request, response);
		
	}

}
