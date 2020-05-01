

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
	
	public void init() {
		String url = getServletContext().getInitParameter("url"); 
		String username = getServletContext().getInitParameter("username");
		String password = getServletContext().getInitParameter("password");
		bookDAO = new BookDAO(url,username,password);
		}
	
	
	
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        
	        try {
	        	switch (action) {
	        	case "/new" :
	        		showNewForm(request,response);
	        		break;
	        	case "/insert" :
	        		insertBook(request,response);
	        		break;
	        	case "/delete" :
	        		deleteBook(request,response);
	        		break;
	        	case "/edit" :
	        		showEditForm(request,response);
	        		break;
	        	case "/update" :
	        		updateBook(request,response);
	        		break;
	        	default :
	        		listBook(request,response);
	        		break;
	        	}
	        } catch (SQLException e) {
	        	System.out.println(e);
	        		
	        		
	        	}
	        }
    public void listBook(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException, ServletException {
    	List<Book> listBook = bookDAO.listAllBooks();
    	request.setAttribute("listBook" , listBook);
    	RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
    	rd.forward(request, response);
    }
    public void showNewForm(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException, ServletException {
    	RequestDispatcher rd = request.getRequestDispatcher("BookForm.jsp");
    	rd.forward(request, response);    	
    }
    public void showEditForm(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	Book existingBook = bookDAO.getBook(id);
    	RequestDispatcher rd = request.getRequestDispatcher("BookForm.jsp");
    	request.setAttribute("book", existingBook);
    	rd.forward(request, response);
    }
    public void insertBook(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException{
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
        
        Book newBook = new Book(title ,author , price);
        bookDAO.insertBook(newBook);
        response.sendRedirect("list");
    }
    public void updateBook(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException{
    	int id = Integer.parseInt(request.getParameter("id"));
    	String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
        
        Book book = new Book(id , title ,author , price);
        bookDAO.updateBook(book);
        response.sendRedirect("list");
    }
    public void deleteBook(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException{
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	Book book = new Book(id);
    	bookDAO.deleteBook(book);
    	response.sendRedirect("list");
    }
  }
