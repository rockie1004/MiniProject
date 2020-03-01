package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListAuthor;

/**
 * Servlet implementation class authorNavigationServlet
 */
@WebServlet("/authorNavigationServlet")
public class authorNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorNavigationServlet() {
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
		
		ListAuthorHelper dao = new ListAuthorHelper();

		String act = request.getParameter("doThisToItem");
		// after all changes, we should redirect to the viewAllAuthors servlet
		//	The only time we don't is if they select to add a new item or edit
		String path = "/viewAllAuthorsServlet";
		boolean test = false;
				
		if(act.equals("delete")) {
			try {
				if(test) {System.out.println("start delete");}
				Integer tempAuthorId = Integer.parseInt(request.getParameter("id"));
				ListAuthor authorToDelete = dao.searchForAuthorById(tempAuthorId);
					dao.deleteAuthor(authorToDelete);
					
		} catch(NumberFormatException e) {
			System.out.println("Forgot to select an author");
		}
			
			
			}
		else if	(act.equals("edit")) {
			try {
				if(test) {System.out.println("start edit");}

			Integer tempID = Integer.parseInt(request.getParameter("id"));
			ListAuthor authorToEdit = dao.searchForAuthorById(tempID);
			request.setAttribute("authorToEdit", authorToEdit);
			path = "/edit-author.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a author");
			}
			
			
		}
		

		getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	}
