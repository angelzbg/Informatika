import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	static Connection conn = null;
	
	public static Connection getConnected() {
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test2", "sa", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
		
	}//end method
	
	private static void CloseConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ModelOrders1 getAllModelOrders1() {
		
		conn = getConnected();
		String sql = "SELECT ORDER_NUMBER, NAMES, O.CLIENT_NUMBER, TITLE, ISBN, QUANTITY, ORDER_DATE, SUM(QUANTITY*PRICE), ADDRESS, DONE " + 
				"FROM ORDERS O JOIN CLIENTS C ON O.CLIENT_NUMBER = C.CLIENT_NUMBER " + 
				"JOIN " + 
				"BOOKS B ON O.BOOK_NUMBER = B.BOOK_NUMBER GROUP BY ORDER_NUMBER ORDER BY ORDER_NUMBER DESC;";
		ResultSet result = null;
		ModelOrders1 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelOrders1(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelOrders1
	
	public static ModelOrders1 getAllModelOrders1ByOrderNumber(int number) {
		
		conn = getConnected();
		String sql = "SELECT ORDER_NUMBER, NAMES, O.CLIENT_NUMBER, TITLE, ISBN, QUANTITY, ORDER_DATE, SUM(QUANTITY*PRICE), ADDRESS, DONE " + 
				"FROM ORDERS O JOIN CLIENTS C ON O.CLIENT_NUMBER = C.CLIENT_NUMBER " + 
				"JOIN " + 
				"BOOKS B ON O.BOOK_NUMBER = B.BOOK_NUMBER WHERE ORDER_NUMBER="+number+";";
		ResultSet result = null;
		ModelOrders1 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelOrders1(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelOrders1ByOrderNumber
	
	public static ModelOrders1 getAllModelOrders1ByClientNumber(int number) {
		
		conn = getConnected();
		String sql = "SELECT ORDER_NUMBER, NAMES, O.CLIENT_NUMBER, TITLE, ISBN, QUANTITY, ORDER_DATE, SUM(QUANTITY*PRICE), ADDRESS, DONE " + 
				"FROM ORDERS O JOIN CLIENTS C ON O.CLIENT_NUMBER = C.CLIENT_NUMBER " + 
				"JOIN " + 
				"BOOKS B ON O.BOOK_NUMBER = B.BOOK_NUMBER WHERE O.CLIENT_NUMBER="+number+";";
		ResultSet result = null;
		ModelOrders1 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelOrders1(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelOrders1ByClientNumber
	
	public static ModelOrders1 getAllModelOrders1ByBookNumber(int number) {
		
		conn = getConnected();
		String sql = "SELECT ORDER_NUMBER, NAMES, O.CLIENT_NUMBER, TITLE, ISBN, QUANTITY, ORDER_DATE, SUM(QUANTITY*PRICE), ADDRESS, DONE " + 
				"FROM ORDERS O JOIN CLIENTS C ON O.CLIENT_NUMBER = C.CLIENT_NUMBER " + 
				"JOIN " + 
				"BOOKS B ON O.BOOK_NUMBER = B.BOOK_NUMBER WHERE O.BOOK_NUMBER="+number+" GROUP BY ORDER_NUMBER;";
		ResultSet result = null;
		ModelOrders1 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelOrders1(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelOrders1ByBookNumber

	// ----------------------------------- Клиенти -----------------------------------
	
	public static ModelClients getAllModelClients() {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number>4999;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelClients
	
	public static ModelClients getAllModelClientsDESC() {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number>4999 order by client_number desc;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelClientsDESC
	
	public static ModelClients getAllModelClientsByName() {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number>4999 order by names asc;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelClientsByName
	
	public static ModelClients getAllModelClientsByNameDESC() {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number>4999 order by names desc;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelClientsByNameDESC
	
	public static ModelClients getAllModelClientsByAddress() {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number>4999 order by address asc;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelClientsByAddress
	
	public static ModelClients getAllModelClientsByAddressDESC() {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number>4999 order by address desc;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelClientsByAddressDESC
	
	public static ModelClients getSpecificModelClients(int number) {
		
		conn = getConnected();
		String sql = "select client_number, names, address from clients where client_number="+number+";";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getSpecificModelClients
	
	public static ModelClients getSpecificModelClientsName(String name) {
		
		conn = getConnected();
		//String sql ="select client_number, names, address from clients where names like "+name+";";
		String sql ="select client_number, names, address from clients WHERE CHARINDEX('"+name+"', names) > 0;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getSpecificModelClientsName
	
	public static ModelClients getSpecificModelClientsAddress(String address) {
		
		conn = getConnected();
		//String sql ="select client_number, names, address from clients where names like ?;";
		String sql ="select client_number, names, address from clients WHERE CHARINDEX('"+address+"', address) > 0;";
		ResultSet result = null;
		ModelClients model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelClients(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getSpecificModelClientsAddress
	
	// ------------------------------------------ Автори ------------------------------------------
	
	public static ModelAuthors getAllModelAuthors() {
		
		conn = getConnected();
		String sql = "select author_number, name from authors where author_number>999;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelAuthors
	
	public static ModelAuthors getModelAuthorByNumber(int number) {
		
		conn = getConnected();
		String sql = "select author_number, name from authors where author_number=?;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, number);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getModelAuthorByNumber

	public static ModelAuthors getModelAuthorByName(String name) {
		
		conn = getConnected();
		String sql = "select author_number, name from authors WHERE CHARINDEX(?, name) > 0;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);			
			state.setString(1, name);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getModelAuthorByName
	
	public static ModelAuthors getAllModelAuthorsByNumberASC() {
		
		conn = getConnected();
		String sql = "select author_number, name from authors where author_number>999 order by author_number asc;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelAuthorsByNumberASC
	
	public static ModelAuthors getAllModelAuthorsByNumberDESC() {
		
		conn = getConnected();
		String sql = "select author_number, name from authors where author_number>999 order by author_number desc;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelAuthorsByNumberDESC
	
	public static ModelAuthors getAllModelAuthorsByNameASC() {
		
		conn = getConnected();
		String sql = "select author_number, name from authors where author_number>999 order by name asc;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelAuthorsByNameASC
	
	public static ModelAuthors getAllModelAuthorsByNameDESC() {
		
		conn = getConnected();
		String sql = "select author_number, name from authors where author_number>999 order by name desc;";
		ResultSet result = null;
		ModelAuthors model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelAuthors(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelAuthorsByNameDESC
	
	// ------------------------------------------ Книги ------------------------------------------
	public static ModelBooks getAllModelBooks() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooks
	
	public static ModelBooks getAllModelBooksByNumber(int number) {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number=?;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, number);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByNumber
	
	public static ModelBooks getAllModelBooksByTitle(String title) {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books WHERE CHARINDEX(?, title) > 0;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, title);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByTitle
	
	public static ModelBooks getAllModelBooksByAuthorNumber(int number) {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where author_number=?;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, number);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByAuthorNumber
	
	public static ModelBooks2 getAllModelBooksByAuthorName(String name) {
		
		conn = getConnected();
		String sql = "select book_number, title, name, b.author_number, isbn, count, price from books b join authors a on b.author_number = a.author_number WHERE CHARINDEX( ?, name) > 0;";
		ResultSet result = null;
		ModelBooks2 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, name);
			result = state.executeQuery();
			model = new ModelBooks2(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByAuthorName
	
	public static ModelBooks getAllModelBooksByISBN(String isbn) {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books WHERE CHARINDEX(?, isbn) > 0;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, isbn);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByISBN
	
	public static ModelBooks getAllModelBooksByPriceGreater(float price) {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where price > ?;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setFloat(1, price);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByPriceGreater
	
	public static ModelBooks getAllModelBooksByPriceLower(float price) {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where price < ? and book_number>2999;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			state.setFloat(1, price);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByPriceGreater
	
	public static ModelBooks getAllModelBooksByNumberASC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by book_number asc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByNumberASC
	
	public static ModelBooks getAllModelBooksByNumberDESC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by book_number desc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByNumberDESC
	
	public static ModelBooks getAllModelBooksByTitleASC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by title asc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByTitleASC
	
	public static ModelBooks getAllModelBooksByTitleDESC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by title desc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByTitleDESC
	
	public static ModelBooks getAllModelBooksByCountASC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by count asc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByCountASC
	
	public static ModelBooks getAllModelBooksByCountDESC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by count desc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByCountDESC
	
	public static ModelBooks getAllModelBooksByPriceASC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by price asc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByPriceASC
	
	public static ModelBooks getAllModelBooksByPriceDESC() {
		
		conn = getConnected();
		String sql = "select book_number, title, author_number, isbn, count, price from books where book_number>2999 order by price desc;";
		ResultSet result = null;
		ModelBooks model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelBooks(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getAllModelBooksByPriceDESC
	
	
	// ------------------------------------------ Допълнителни справки ------------------------------------------
	
	public static ModelExtra1 getModelExtra1(int number) {
		
		conn = getConnected();
		String sql = "select book_number, title, isbn, count, price from books where author_number="+number+";";
		ResultSet result = null;
		ModelExtra1 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelExtra1(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getModelExtra1
	
	public static ModelExtra1 getModelExtra2(int number) {
		
		conn = getConnected();
		String sql = "select distinct b.book_number, title, isbn, count, price from books b join orders o on b.book_number=o.book_number where o.client_number="+number+";";
		ResultSet result = null;
		ModelExtra1 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelExtra1(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getModelExtra2
	
	
	public static ModelExtra2 getModelExtra(String name, int number) {
		
		conn = getConnected();
		String sql = "select distinct b.book_number, title, isbn, price from books b join orders o on b.book_number=o.book_number join authors a on b.author_number = a.author_number where o.client_number="+number+" and b.author_number=select author_number from authors where name like '"+name+"';";
		ResultSet result = null;
		ModelExtra2 model = null;
		
		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new ModelExtra2(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseConn();
		
		return model;
		
	}//end getModelExtra
	
}//end DBUtil