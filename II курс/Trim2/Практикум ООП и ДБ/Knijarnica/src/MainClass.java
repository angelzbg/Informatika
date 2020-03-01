import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainClass {
	
	private static ClientsFrame clientsFrame=null;
	private static BooksFrame booksFrame=null;
	private static AuthorsFrame authorsFrame=null;
	private static ExtraFrame extraFrame=null;
	
	private static MainFrame mainFrame = null;

	public static void main(String[] args) {
		
		mainFrame = new MainFrame();
		
		mainFrame.buttonToClients.addActionListener(new GoToClients());
		mainFrame.buttonToBooks.addActionListener(new GoToBooks());
		mainFrame.buttonToAuthors.addActionListener(new GoToAuthors());
		mainFrame.buttonToCustom.addActionListener(new GoToExtra());
		
		mainFrame.addButton.addActionListener(new AddActionOrders());
		mainFrame.deleteButton.addActionListener(new DeleteActionOrders());
		mainFrame.editButton.addActionListener(new EditActionOrders());
		
	} //main
	
	//-------------------------------------------АctionListeners
	static class GoToClients implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(clientsFrame==null)
			{
				clientsFrame = new ClientsFrame();
				clientsFrame.addWindowListener(exitListenerClients);
				clientsFrame.deleteButton.addActionListener(new DeleteActionClient());
				clientsFrame.editButton.addActionListener(new EditActionClients());
			}
			else
			{
				clientsFrame.requestFocus();
			}
		}
	}
	static class GoToBooks implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(booksFrame==null)
			{
				booksFrame = new BooksFrame();
				booksFrame.addWindowListener(exitListenerBooks);
				booksFrame.deleteButton.addActionListener(new DeleteActionBooks());
				booksFrame.editButton.addActionListener(new EditActionBooks());
			}
			else
			{
				booksFrame.requestFocus();
			}
		}
	}
	static class GoToAuthors implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(authorsFrame==null)
			{
				authorsFrame = new AuthorsFrame();
				authorsFrame.addWindowListener(exitListenerAuthors);
				authorsFrame.delButton.addActionListener(new DeleteActionAuthors());
			}
			else
			{
				authorsFrame.requestFocus();
			}
		}
	}
	
	static class GoToExtra implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(extraFrame==null)
			{
				extraFrame = new ExtraFrame();
				extraFrame.addWindowListener(exitListenerExtra);
			}
			else
			{
				extraFrame.requestFocus();
			}
		}
	}
	
	//exitListeners
	static WindowListener exitListenerClients = new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
	        clientsFrame = null;
	    }
	};
	static WindowListener exitListenerBooks = new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
	        booksFrame = null;
	    }
	};
	static WindowListener exitListenerAuthors = new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
	        authorsFrame = null;
	    }
	};
	static WindowListener exitListenerExtra = new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
	        extraFrame = null;
	    }
	};
	
	
	
	//-----------------------------------ActionListeners GLOBAL
	
	private static class DeleteActionAuthors implements ActionListener //при изтриване на автор
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			authorsFrame.DeleteAction(); //извикваме метода за изтриване на автор
			if(booksFrame!=null) booksFrame.table.setModel(DBUtil.getAllModelBooks()); //обновяваме таблицата с книгите
		}
		
	}//end DeleteActionAuthors
	
	private static class DeleteActionClient implements ActionListener //при изтриване на клиент
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			clientsFrame.DeleteAction();
			mainFrame.table.setModel(DBUtil.getAllModelOrders1());
		}
		
	}//end DeleteActionClient
	
	private static class EditActionClients implements ActionListener //при редактиране на клиент
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			clientsFrame.EditAction();
			mainFrame.table.setModel(DBUtil.getAllModelOrders1());
		}
		
	}//end EditActionClients
	
	private static class DeleteActionBooks implements ActionListener //при изтриване на книга
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			booksFrame.DeleteAction();
			mainFrame.table.setModel(DBUtil.getAllModelOrders1());
		}
		
	}//end DeleteActionBooks
	
	private static class EditActionBooks implements ActionListener //при редактиране на книга
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			booksFrame.EditAction();
			mainFrame.table.setModel(DBUtil.getAllModelOrders1());
		}
		
	}//end DeleteActionBooks
	
	
	private static class AddActionOrders implements ActionListener //при добавяне на поръчка
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			mainFrame.AddAction();
			if(booksFrame!=null) booksFrame.table.setModel(DBUtil.getAllModelBooks());
		}
		
	}
	
	private static class DeleteActionOrders implements ActionListener //изтриване на поръчки
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			mainFrame.DeleteAction();
			if(booksFrame!=null) booksFrame.table.setModel(DBUtil.getAllModelBooks());
			
		}
		
	}
	
	private static class EditActionOrders implements ActionListener //редактиране на поръчки
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			mainFrame.EditAction();
			if(booksFrame!=null) booksFrame.table.setModel(DBUtil.getAllModelBooks());
			
		}
		
	}
	
}
