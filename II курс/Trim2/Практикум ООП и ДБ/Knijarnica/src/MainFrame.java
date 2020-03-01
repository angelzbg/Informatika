import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//DB
	Connection conn = null;
	PreparedStatement state = null;
			
	//Up and Down Panel
	JPanel downPanel = new JPanel();
	JPanel upPanel = new JPanel();
	
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	//--- Всичко за горния панел ---
	//Навигация
	JPanel topNavPanel = new JPanel();
	JButton buttonToBooks = new JButton("Книги");
	JButton buttonToAuthors = new JButton("Автори");
	JButton buttonToClients = new JButton("Клиенти");
	JButton buttonToCustom = new JButton("Допълнителни справки");
	
	//Съобщения
	JPanel warningPanel = new JPanel();
	JLabel labelWarning = new JLabel("Съобщенията ще излизат тук");
	
	//Добавяне
	JPanel addLabelPanel = new JPanel();
	JLabel addLabel = new JLabel("Нова поръчка");
	
	JPanel addPanel = new JPanel();
	JTextField addClientNumberTF = new JTextField("Клиентски №");
	JTextField addBookNumberTF = new JTextField("№ на книга");
	JTextField addQuantityTF = new JTextField("Количество");
	String[] stateList = { "Неизпълнена", "Изпълнена" };
	JComboBox addComboBox = new JComboBox(stateList);
	JButton addButton = new JButton("Добави");
	
	//Изтриване
	JPanel deleteLabelPanel = new JPanel();
	JLabel deleteLabel = new JLabel("Изтриване на поръчка");
	
	JPanel deletePanel = new JPanel();
	JTextField deleteOrderNumberTF = new JTextField("№ на поръчката");
	JButton deleteButton = new JButton("Изтрий");
	
	//Редактиране
	JPanel editLabelPanel = new JPanel();
	JLabel editLabel = new JLabel("Редактиране на поръчка");
	
	JPanel editSearchPanel = new JPanel();
	JLabel editSearchDescr = new JLabel("№ на поръчката за редактиране: ", SwingConstants.RIGHT);
	JTextField editSearchOrderNumberTF = new JTextField("Например 2000");
	JButton editSearchButton = new JButton("Търси");
	
	JPanel editPanel = new JPanel();
	JTextField editOrderNumberTF = new JTextField("№ на поръчка");
	JTextField editClientNumberTF = new JTextField("№ на клиент");
	JTextField editBookNumberTF = new JTextField("№ на книга");
	JTextField editQuantityTF = new JTextField("Количество");
	JComboBox editComboBox = new JComboBox(stateList);
	JButton editButton = new JButton("Редактирай");
	
	//Търсене
	JPanel searchLabelPanel = new JPanel();
	JLabel searchLabel = new JLabel("Търсене");
	
	JPanel searchPanel = new JPanel();
	String[] searchCriteriaList = { "По № на поръчка", "По № на клиент", "По № на книга" };
	JComboBox searchComboBox = new JComboBox(searchCriteriaList);
	JTextField searchCriteriaTF = new JTextField();
	JButton searchButton = new JButton("Търси");
	
	//------------------Край на горен панел--------------------------
	
	WindowListener exitListener = new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e)
	    {
	        int confirm = JOptionPane.showOptionDialog(null, "Сигурни ли сте, че искате да затворите програмата?", "Потвърждение", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	        if (confirm == 0) System.exit(0);
	    }
	};
	
	public MainFrame()
	{
		this.getRootPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ResizeEverything();
            }
        });
		
		this.addWindowStateListener(new WindowStateListener() {
			   public void windowStateChanged(WindowEvent arg0) {
				   frame__windowStateChanged(arg0);
			}
		});
		
		this.setTitle("Книжарница (поръчки)");
		this.setMinimumSize(new Dimension(800,800));
		this.setSize(1200,900);
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(exitListener);
		this.setLayout(null);
		
		//------------Горен панел
		this.add(upPanel);
		upPanel.setLocation(0,0);
		upPanel.setLayout(new GridLayout(11,1));
		upPanel.setVisible(true);
		upPanel.add(topNavPanel);
		topNavPanel.setLayout(new GridLayout(1,4));
		topNavPanel.add(buttonToClients);
		topNavPanel.add(buttonToBooks);
		topNavPanel.add(buttonToAuthors);
		topNavPanel.add(buttonToCustom);
		topNavPanel.setBorder(BorderFactory.createLineBorder(new Color(215, 248, 215)));
		
		//Съобщения
		upPanel.add(warningPanel);
		warningPanel.add(labelWarning);
		warningPanel.setBackground(new Color(89, 89, 89));
		warningPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		labelWarning.setForeground(new Color(215, 248, 215));
		
		//Добавяне
		upPanel.add(addLabelPanel);
		addLabelPanel.add(addLabel);
		
		upPanel.add(addPanel);
		addPanel.setLayout(new GridLayout(1,5));
		addPanel.add(addClientNumberTF);
		addPanel.add(addBookNumberTF);
		addPanel.add(addQuantityTF);
		addPanel.add(addComboBox);
		addPanel.add(addButton);
		
		//Изтриване
		upPanel.add(deleteLabelPanel);
		deleteLabelPanel.add(deleteLabel);
		
		upPanel.add(deletePanel);
		deletePanel.setLayout(new GridLayout(1,2));
		deletePanel.add(deleteOrderNumberTF);
		deletePanel.add(deleteButton);
		
		
		//Редактиране
		upPanel.add(editLabelPanel);
		editLabelPanel.add(editLabel);
		
		upPanel.add(editSearchPanel);
		editSearchPanel.setLayout(new GridLayout(1,3));
		editSearchPanel.add(editSearchDescr);
		editSearchPanel.add(editSearchOrderNumberTF);
		editSearchPanel.add(editSearchButton);
		
		editSearchButton.addActionListener(new SearchForEditAction());
		
		upPanel.add(editPanel);
		editPanel.setLayout(new GridLayout(1,6));
		editPanel.add(editOrderNumberTF);
		editPanel.add(editClientNumberTF);
		editPanel.add(editBookNumberTF);
		editPanel.add(editQuantityTF);
		editPanel.add(editComboBox);
		editPanel.add(editButton);
		
		
		//Търсене
		upPanel.add(searchLabelPanel);
		searchLabelPanel.add(searchLabel);
		
		upPanel.add(searchPanel);
		searchPanel.setLayout(new GridLayout(1,3));
		searchPanel.add(searchComboBox);
		searchPanel.add(searchCriteriaTF);
		searchPanel.add(searchButton);
		
		searchButton.addActionListener(new SearchAction());
		
		//-----------Долен панел
		this.add(downPanel);
		downPanel.setLayout(new BorderLayout());
		downPanel.add(scroller);
		table.setModel(DBUtil.getAllModelOrders1());
		
		this.setSize(1199,900);
		this.setSize(1200,900);
		ResizeEverything();
	}//constructor
	
	private void ResizeEverything()
	{
		int jframeWidth=this.getWidth()-15, jframeHeight=this.getHeight()-36;
		downPanel.setLocation(0,(int) (jframeHeight/3)); // /3
		downPanel.setSize(jframeWidth, (int) (jframeHeight/1.5));// /1.5
		upPanel.setSize(jframeWidth, (int) (jframeHeight/3));// /3
	}
	
	public void frame__windowStateChanged(WindowEvent e)
	{
		if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH)
		{
			ResizeEverything();
		}
		else ResizeEverything();
	}//end of resizing
	
	
	void AddAction()
	{
			
			if(addClientNumberTF.getText().isEmpty() || addBookNumberTF.getText().isEmpty() || addQuantityTF.getText().isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Моля попълнете всички полета!</html>");
			}
			
			String clientNumberString = addClientNumberTF.getText(), bookNumberString = addBookNumberTF.getText(), quantityString = addQuantityTF.getText();
			
			int clientNumber;
			
			try {
				clientNumber = Integer.parseInt(clientNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Моля въведете номер на клиент!</html>");
				  addClientNumberTF.selectAll();
				  addClientNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(clientNumber<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на клиентите започват от 5000!</html>");
				addClientNumberTF.selectAll();
				addClientNumberTF.requestFocusInWindow();
				return;
			}
			
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			
			String sql ="select client_number from clients where client_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, clientNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува клиент с този номер!</html>");
					addClientNumberTF.selectAll();
					addClientNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			int bookNumber;
			
			try {
				bookNumber = Integer.parseInt(bookNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Моля въведете номер на книга!</html>");
				  addBookNumberTF.selectAll();
				  addBookNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(bookNumber<3000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на книгите започват от 3000!</html>");
				addBookNumberTF.selectAll();
				addBookNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="select book_number from books where book_number = ?;";
			rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува книга с този номер!</html>");
					addBookNumberTF.selectAll();
					addBookNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			
			int quantity;
			
			try {
				quantity = Integer.parseInt(quantityString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Въведете цяло число за количество!</html>");
				  addQuantityTF.selectAll();
				  addQuantityTF.requestFocusInWindow();
				  return;
			  }
			
			if(quantity<1)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Проверете стойността, зададена за количество!</html>");
				addQuantityTF.selectAll();
				addQuantityTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="select count from books where book_number = ?;";
			rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				
				if(rs.next())
				{
					int bookQuantity = rs.getInt(1);
					
					if(bookQuantity==0)
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>Книгата е с изчерпано количество!</html>");
						CloseConn();
						return;
					}
					
					if(bookQuantity>=quantity)
					{
						sql ="insert into orders values(null, null, ?, ?, ?, ?, ?);";
						state = conn.prepareStatement(sql);
						state.setInt(1, clientNumber);
						state.setInt(2, bookNumber);
						state.setInt(3, quantity);
						Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
						state.setDate(4, date);
						boolean sustoqnie;
						if(addComboBox.getSelectedItem().toString().equals(stateList[0])) //неизпълнена
						{
							sustoqnie = false;
						}
						else sustoqnie = true; //изпълнена
						state.setBoolean(5,  sustoqnie);
						state.execute();
						
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>Успешно добавихте поръчка!</html>");
						
						table.setModel(DBUtil.getAllModelOrders1());
						
						int newQuantity = bookQuantity-quantity;
						
						sql ="update books set count=? where book_number=?;";
						state = conn.prepareStatement(sql);
						state.setInt(1, newQuantity);
						state.setInt(2, bookNumber);
						state.execute();
						
						
						addClientNumberTF.setText("Клиентски №");
						addBookNumberTF.setText("№ на книга");
						addQuantityTF.setText("Количество");
					}
					else
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>Количеството, което сте въвели, надвишава реалните бройки на книгата = "+bookQuantity+"</html>");
						addQuantityTF.selectAll();
						addQuantityTF.requestFocusInWindow();
					}
				}
				
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
		
	}//end AddAction

	void DeleteAction()
	{
			
			if(deleteOrderNumberTF.getText().isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Моля въведете номер на поръчката за изтриване!</html>");
				deleteOrderNumberTF.selectAll();
				deleteOrderNumberTF.requestFocusInWindow();
				return;
			}
			
			String numberString = deleteOrderNumberTF.getText();
			int number;
			
			try {
				number = Integer.parseInt(numberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Номерата на поръчките са цели числа и започват от 2000!</html>");
				  deleteOrderNumberTF.selectAll();
				  deleteOrderNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(number<2000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на поръчките започват от 2000!</html>");
				deleteOrderNumberTF.selectAll();
				deleteOrderNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			
			String sql ="select order_number from orders where order_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, number);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува поръчка с този номер!</html>");
					addClientNumberTF.selectAll();
					addClientNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				else
				{
					sql ="select done, book_number, quantity from orders where order_number = ?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, number);
					rs = state.executeQuery();
					
					boolean done;
					if(rs.next())
					{
						done = rs.getBoolean(1);
						if(!done)
						{
							int bookNum = rs.getInt(2);
							int bookQuant = rs.getInt(3);
							
							sql ="select count from books where book_number = ?;";
							state = conn.prepareStatement(sql);
							state.setInt(1, bookNum);
							rs = state.executeQuery();
							
							int prevQuant=0;
							if(rs.next()) prevQuant = rs.getInt(1);
							
							sql ="update books set count="+(prevQuant+bookQuant)+" where book_number="+bookNum+";";
							state = conn.prepareStatement(sql);
							state.execute();
						}
					}
					
					sql ="delete from orders where order_number=?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, number);
					state.execute();
					
					labelWarning.setForeground(Color.GREEN);
					labelWarning.setText("<html>Успешно изтрихте поръчка с номер "+number+"</html>");
					addClientNumberTF.setText(null);
					
					table.setModel(DBUtil.getAllModelOrders1());
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
		
	}//end DeleteAction
	
	private class SearchForEditAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(editSearchOrderNumberTF.getText().isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Моля въведете номер на поръчка!</html>");
				editSearchOrderNumberTF.selectAll();
				editSearchOrderNumberTF.requestFocusInWindow();
				return;
			}
			
			String numberString = editSearchOrderNumberTF.getText();
			int number;
			
			try {
				number = Integer.parseInt(numberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Номерата на поръчките са цели числа и започват от 2000!</html>");
				  editSearchOrderNumberTF.selectAll();
				  editSearchOrderNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(number<2000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на поръчките започват от 2000!</html>");
				editSearchOrderNumberTF.selectAll();
				editSearchOrderNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			
			String sql ="select client_number, book_number, quantity, done from orders where order_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, number);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува поръчка с този номер!</html>");
					editSearchOrderNumberTF.selectAll();
					editSearchOrderNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				else
				{
					int clNum = rs.getInt(1), bkNum = rs.getInt(2), quant = rs.getInt(3);
					boolean done = rs.getBoolean(4);
					editOrderNumberTF.setText(""+number);
					editClientNumberTF.setText(""+clNum);
					editBookNumberTF.setText(""+bkNum);
					editQuantityTF.setText(""+quant);
					if(done) editComboBox.setSelectedItem(stateList[1]);
					else editComboBox.setSelectedItem(stateList[0]);
					labelWarning.setForeground(Color.CYAN);
					labelWarning.setText("<html>Редактирате поръчка с номер "+number+"</html>");
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
		}
		
	}//end SearchForEditAction
	
	void EditAction()
	{
			
			if(editOrderNumberTF.getText().isEmpty() || editClientNumberTF.getText().isEmpty() || editBookNumberTF.getText().isEmpty() || editQuantityTF.getText().isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Моля попълнете всички полета!</html>");
				return;
			}
			
			String numberString = editSearchOrderNumberTF.getText();
			int orderNumber;
			
			try {
				orderNumber = Integer.parseInt(numberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Номерата на поръчките са цели числа и започват от 2000!</html>");
				  editOrderNumberTF.selectAll();
				  editOrderNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(orderNumber<2000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на поръчките започват от 2000!</html>");
				editOrderNumberTF.selectAll();
				editOrderNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			
			String sql ="select order_number from orders where order_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, orderNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува поръчка с този номер!</html>");
					editSearchOrderNumberTF.selectAll();
					editSearchOrderNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			
			String clientNumberString=editClientNumberTF.getText();
			int clientNumber;
			
			try {
				clientNumber = Integer.parseInt(clientNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Моля въведете номер на клиент!</html>");
				  editClientNumberTF.selectAll();
				  editClientNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(clientNumber<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на клиентите започват от 5000!</html>");
				editClientNumberTF.selectAll();
				editClientNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="select client_number from clients where client_number = ?;";
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, clientNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува клиент с този номер!</html>");
					editClientNumberTF.selectAll();
					editClientNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			String bookNumberString = editBookNumberTF.getText();
			int bookNumber;
			
			try {
				bookNumber = Integer.parseInt(bookNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Моля въведете номер на книга!</html>");
				  editBookNumberTF.selectAll();
				  editBookNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(bookNumber<3000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Номерата на книгите започват от 3000!</html>");
				editBookNumberTF.selectAll();
				editBookNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="select book_number from books where book_number = ?;";
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Не съществува книга с този номер!</html>");
					editBookNumberTF.selectAll();
					editBookNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			String quantityString = editQuantityTF.getText();
			int quantity;
			
			try {
				quantity = Integer.parseInt(quantityString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>Въведете цяло число за количество!</html>");
				  addQuantityTF.selectAll();
				  addQuantityTF.requestFocusInWindow();
				  return;
			  }
			
			if(quantity<1)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>Проверете стойността, зададена за количество!</html>");
				addQuantityTF.selectAll();
				addQuantityTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="select count from books where book_number = ?;";
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				
				if(rs.next())
				{
					int bookQuantity = rs.getInt(1); //колко бройки от книгата имаме останали в книжарницата
					int bookQuantityCurrent = 0; //колко бройки имаме в поръчката за редактиране реално
					
					sql ="select quantity from orders where order_number = ?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, orderNumber);
					rs = state.executeQuery();
					
					if(rs.next()) bookQuantityCurrent = rs.getInt(1);
					
					if(quantity>bookQuantityCurrent) //т.е. добавяме бройки в поръчката
					{
						int upCount = quantity-bookQuantityCurrent;
						if(upCount>bookQuantity)
						{
							labelWarning.setForeground(Color.RED);
							labelWarning.setText("<html>Останали са само "+bookQuantity+" броя от тази книга! Моксимално допустимо = "+(bookQuantity+bookQuantityCurrent)+"</html>");
							addQuantityTF.selectAll();
							addQuantityTF.requestFocusInWindow();
							CloseConn();
							return;
						}
						
						boolean done;
						if(editComboBox.getSelectedItem().equals(stateList[0])) done=false;
						else done=true;
						
						sql ="update orders set client_number=?, book_number=?, quantity=?, done=? where order_number=?;";
						state = conn.prepareStatement(sql);
						state.setInt(1, clientNumber);
						state.setInt(2, bookNumber);
						state.setInt(3, quantity);
						state.setBoolean(4, done);
						state.setInt(5, orderNumber);
						state.execute();
						
						table.setModel(DBUtil.getAllModelOrders1());
						
						sql ="update books set count="+(bookQuantity-upCount)+" where book_number="+bookNumber+";";
						state = conn.prepareStatement(sql);
						state.execute();
						
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>Успешно редактирахте поръчка с номер "+orderNumber+"</html>");
						
					}
					else //ако quantity<bookQuantityCurrent т.е. премахваме бройки в поръчката
					{
						int downCount = bookQuantityCurrent-quantity;
						boolean done;
						if(editComboBox.getSelectedItem().equals(stateList[0])) done=false;
						else done=true;
						
						sql ="update orders set client_number=?, book_number=?, quantity=?, done=? where order_number=?;";
						state = conn.prepareStatement(sql);
						state.setInt(1, clientNumber);
						state.setInt(2, bookNumber);
						state.setInt(3, quantity);
						state.setBoolean(4, done);
						state.setInt(5, orderNumber);
						state.execute();
						
						table.setModel(DBUtil.getAllModelOrders1());
						
						sql ="update books set count="+(bookQuantity+downCount)+" where book_number="+bookNumber+";";
						state = conn.prepareStatement(sql);
						state.execute();
						
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>Успешно редактирахте поръчка с номер "+orderNumber+"</html>");
					}
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
		
	}//end EditAction
	
	private class SearchAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(searchComboBox.getSelectedItem().equals(searchCriteriaList[0])) //По № поръчка
			{
				String numberString = searchCriteriaTF.getText();
				int orderNumber;
				
				try {
					orderNumber = Integer.parseInt(numberString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>Номерата на поръчките са цели числа и започват от 2000!</html>");
					  searchCriteriaTF.selectAll();
					  searchCriteriaTF.requestFocusInWindow();
					  return;
				  }
				
				if(orderNumber<2000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Номерата на поръчките започват от 2000!</html>");
					searchCriteriaTF.selectAll();
					searchCriteriaTF.requestFocusInWindow();
					return;
				}
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				String sql ="select order_number from orders where order_number = ?;";
				ResultSet rs=null;
				
				try {
					state = conn.prepareStatement(sql);
					state.setInt(1, orderNumber);
					rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>Не съществува поръчка с този номер!</html>");
						searchCriteriaTF.selectAll();
						searchCriteriaTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>Намерена е поръчка с номер "+orderNumber+"</html>");
				table.setModel(DBUtil.getAllModelOrders1ByOrderNumber(orderNumber));
				searchCriteriaTF.setText(null);
				
			}
			else if(searchComboBox.getSelectedItem().equals(searchCriteriaList[1])) //По № клиент
			{
				String clientNumberString=searchCriteriaTF.getText();
				int clientNumber;
				
				try {
					clientNumber = Integer.parseInt(clientNumberString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>Моля въведете номер на клиент!</html>");
					  searchCriteriaTF.selectAll();
					  searchCriteriaTF.requestFocusInWindow();
					  return;
				  }
				
				if(clientNumber<5000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Номерата на клиентите започват от 5000!</html>");
					searchCriteriaTF.selectAll();
					searchCriteriaTF.requestFocusInWindow();
					return;
				}
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				String sql ="select client_number from orders where client_number = ?;";
				ResultSet rs=null;
				try {
					state = conn.prepareStatement(sql);
					state.setInt(1, clientNumber);
					rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>Няма поръчки от клиент с такъв клиентски номер!</html>");
						searchCriteriaTF.selectAll();
						searchCriteriaTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>Намерена е поръчка от клиент с клиентски номер "+clientNumber+"</html>");
				table.setModel(DBUtil.getAllModelOrders1ByClientNumber(clientNumber));
				searchCriteriaTF.setText(null);
			}
			else //По № на книга
			{
				String bookNumberString = searchCriteriaTF.getText();
				int bookNumber;
				
				try {
					bookNumber = Integer.parseInt(bookNumberString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>Моля въведете номер на книга!</html>");
					  searchCriteriaTF.selectAll();
					  searchCriteriaTF.requestFocusInWindow();
					  return;
				  }
				
				if(bookNumber<3000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>Номерата на книгите започват от 3000!</html>");
					searchCriteriaTF.selectAll();
					searchCriteriaTF.requestFocusInWindow();
					return;
				}
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				String sql ="select book_number from orders where book_number = ?;";
				ResultSet rs=null;
				
				try {
					state = conn.prepareStatement(sql);
					state.setInt(1, bookNumber);
					rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>Книга с номер "+bookNumber+" не е била поръчвана!</html>");
						searchCriteriaTF.selectAll();
						searchCriteriaTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>Успешно търсене!</html>");
				table.setModel(DBUtil.getAllModelOrders1ByBookNumber(bookNumber));
				searchCriteriaTF.setText(null);
			}
			
		}
		
	}
	
	//-------
	private void WarnNoConnection()
	{
		labelWarning.setForeground(Color.RED);
		labelWarning.setText("<html>Неуспешна връзка с датабазата!</html>");
	}
	private void WarnNotDone()
	{
		labelWarning.setForeground(Color.RED);
		labelWarning.setText("<html>Някъде по пътя възникна грешка!</html>");
	}
	private void CloseConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}//end class MainFrame
