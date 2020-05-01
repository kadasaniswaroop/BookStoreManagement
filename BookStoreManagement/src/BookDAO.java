import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private String url = "jdbc:mysql://localhost:3306/demo";
	private String username = "root";
	private String password = "0000";
	    
	
	public BookDAO(String url2, String username2, String password2) {
		
	}
	public boolean insertBook(Book book) throws SQLException {
		String sql = "Insert into book (title,author,price) Values (?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, book.getTitle());
		st.setString(2, book.getAuthor());
		st.setFloat(3, book.getPrice());
		
		boolean rowInserted =st.executeUpdate() > 0;
		st.close();
		con.close();
		return rowInserted;
	}
	public List<Book> listAllBooks() throws SQLException {
		List<Book> listBook = new ArrayList<>();
		String sql = "Select * from book";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("book_id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			float price = rs.getFloat("price");
			
			Book book = new Book (id,title,author,price);
			listBook.add(book);
			
		}
		rs.close();
		st.close();
		con.close();
		return listBook;
		}
	public boolean deleteBook(Book book) throws SQLException {
		String sql = "Delete from book where book_id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, book.getId());
		boolean rowDeleted = st.executeUpdate()>0;
		st.close();
		con.close();
		return rowDeleted;
	}
	public boolean updateBook(Book book) throws SQLException {
		String sql = "update book set title = ?, author = ?, price = ?";
		sql = sql+"Where book_id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, book.getTitle());
		st.setString(2, book.getAuthor());
		st.setFloat(3, book.getPrice());
		st.setInt(4, book.getId());
        boolean rowUpdated = st.executeUpdate() >0;
        st.close();
        con.close();
        return rowUpdated;
        }
	public Book getBook(int id) throws SQLException {
		Book book = null;
		String Sql = "select * from book where book_id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement st = con.prepareStatement(Sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			String title = rs.getString("title");
			String author = rs.getString("author");
			float price = rs.getFloat("price");
		}
		rs.close();
		st.close();
		return book;
		
	}
		
		
	}
	
	
	

