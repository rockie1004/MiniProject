package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;

/**
 * Servlet implementation class bookNavigationServlet
 */
@WebServlet("/bookNavigationServlet")
public class bookNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookNavigationServlet() {
        super();
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

		String act = request.getParameter("doThisToItem");
		// after all changes, we should redirect to the viewAllBooks servlet
		//	The only time we don't is if they select to add a new item or edit
		String path = "/viewAllBooksServlet";
		boolean test = true;
				
		if(act.equals("delete")) {
			try {
				if(test) {System.out.println("start delete");}
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListBook bookToDelete = dao.searchForBookById(tempId);
					dao.deleteBook(bookToDelete);
		} catch(NumberFormatException e) {
			System.out.println("Forgot to select a book");
		}
			
			}
		else if	(act.equals("edit")) {
			try {
				if(test) {System.out.println("start edit");}

			Integer tempID = Integer.parseInt(request.getParameter("id"));
			ListBook bookToEdit = dao.searchForBookById(tempID);
			request.setAttribute("bookToEdit", bookToEdit);
			path = "/edit-book.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a book");
			}
			
			
		}
		else if (act.equals("add")) {
			if(test) {System.out.println("start add");}
		path = "/index.html";
		}
		if(test) {System.out.println("path = " + path);}

		getServletContext().getRequestDispatcher(path).forward(request, response);
		}
	}
