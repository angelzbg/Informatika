import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BooksFrame extends JFrame {
	
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
		
		//-------������ �� ������ �����------------
		
		//���������
		JPanel warningPanel = new JPanel();
		JLabel labelWarning = new JLabel("����������� �� ������� ���");
		
		//��������
		
		JPanel addLabelPanel = new JPanel();
		JLabel addLabel = new JLabel("�������� �� �����");
		JPanel addPanel = new JPanel();
		JTextField addTitleTF = new JTextField("��������"); 
		JTextField addAuthorNumberTF = new JTextField("� �� �����");
		JTextField addIsbnTF = new JTextField("ISBN");
		JTextField addCountTF = new JTextField("������� ����");
		JTextField addPriceTF = new JTextField("��. ����");
		JButton addButton = new JButton("������");
		
		//���������
		
		JPanel deleteLabelPanel = new JPanel();
		JLabel deleteLabel = new JLabel("��������� �� �����");
		JPanel deletePanel = new JPanel();
		JTextField deleteBookNumberTF = new JTextField("� �� �����");
		JButton deleteButton = new JButton("������");
		
		//����������� �� �����
		
		JPanel editLabelPanel = new JPanel();
		JLabel editLabel = new JLabel("����������� �� �����");
		
		JPanel editSearchPanel = new JPanel();
		JLabel editSearchBookNumberDesc = new JLabel("����� �� ������� �� �����������: ", SwingConstants.RIGHT);
		JTextField editSearchBookNumberTF = new JTextField("�������� 3000");
		JButton editSearchButton = new JButton("�����");
		
		JPanel editPanel = new JPanel();
		JTextField editNumberTF = new JTextField("� �����");
		JTextField editTitleTF = new JTextField("��������");
		JTextField editAuthorNumberTF = new JTextField("� �����");
		JTextField editIsbnTF = new JTextField("ISBN");
		JTextField editCountTF = new JTextField("����");
		JTextField editPriceTF = new JTextField("��. ����");
		JButton editButton = new JButton("����������");
		
		//������� �� �����
		
		JPanel searchLabelPanel = new JPanel();
		JLabel searchLabel = new JLabel("������� �� �����");
		
		JPanel searchPanel = new JPanel();
		String[] criteriaList = { "�� � �� �����", "�� ��������", "�� � �� �����", "�� ��� �� �����", "�� ISBN", "���� > ��:", "���� < ��:" };
		JComboBox searchCriteriaList = new JComboBox(criteriaList);
		JTextField searchTF = new JTextField();
		JButton searchButton = new JButton("�����");
		
		
		//���������
		
		JPanel sortLabelPanel = new JPanel();
		JLabel sortLabel = new JLabel("��������� �� ������ ����� � ����������");
		JPanel sortPanel = new JPanel();
		JButton sortBookNumber = new JButton("� �� �����");
		JButton sortTitle = new JButton("��������");
		JButton sortCount = new JButton("����");
		JButton sortPrice = new JButton("����");
		
		private boolean isASC=true;
		
		
		//------------������ �� ������ �����-------------
		JTable table = new JTable();
		JScrollPane scroller = new JScrollPane(table);
	
	public BooksFrame()
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
		
		this.setTitle("�����");
		this.setVisible(true);
		this.setLayout(null);
		this.setMinimumSize(new Dimension(900,900));
		
		//---------------------------------- ����� ����� ---------------------
		this.add(upPanel);
		upPanel.setLocation(0,0);
		upPanel.setVisible(true);
		upPanel.setLayout(new GridLayout(12,1));
		
		//���������
		upPanel.add(warningPanel);
		warningPanel.add(labelWarning);
		warningPanel.setBackground(new Color(89, 89, 89));
		warningPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		labelWarning.setForeground(new Color(215, 248, 215));
		
		//��������
		upPanel.add(addLabelPanel);
		addLabelPanel.add(addLabel);
		
		upPanel.add(addPanel);
		addPanel.setLayout(new GridLayout(1, 6));
		addPanel.add(addTitleTF);
		addPanel.add(addAuthorNumberTF);
		addPanel.add(addIsbnTF);
		addPanel.add(addCountTF);
		addPanel.add(addPriceTF);
		addPanel.add(addButton);
		addButton.addActionListener(new AddAction());
		
		
		//���������
		
		upPanel.add(deleteLabelPanel);
		deleteLabelPanel.add(deleteLabel);
		
		upPanel.add(deletePanel);
		deletePanel.setLayout(new GridLayout(1,2));
		deletePanel.add(deleteBookNumberTF);
		deletePanel.add(deleteButton);
		
		
		//�����������
		
		upPanel.add(editLabelPanel);
		editLabelPanel.add(editLabel);
		
		upPanel.add(editSearchPanel);
		editSearchPanel.setLayout(new GridLayout(1,3));
		editSearchPanel.add(editSearchBookNumberDesc);
		editSearchPanel.add(editSearchBookNumberTF);
		editSearchPanel.add(editSearchButton);
		
		editSearchButton.addActionListener(new SearchForEditAction());
		
		upPanel.add(editPanel);
		editPanel.setLayout(new GridLayout(1,7));
		editPanel.add(editNumberTF);
		editPanel.add(editTitleTF);
		editPanel.add(editAuthorNumberTF);
		editPanel.add(editIsbnTF);
		editPanel.add(editCountTF);
		editPanel.add(editPriceTF);
		editPanel.add(editButton);
		
		
		//�������
		upPanel.add(searchLabelPanel);
		searchLabelPanel.add(searchLabel);
		
		upPanel.add(searchPanel);
		searchPanel.setLayout(new GridLayout(1,3));
		searchPanel.add(searchCriteriaList);
		searchPanel.add(searchTF);
		searchPanel.add(searchButton);
		
		searchButton.addActionListener(new SearchAction());
		
		
		//���������
		
		upPanel.add(sortLabelPanel);
		sortLabelPanel.add(sortLabel);
		
		upPanel.add(sortPanel);
		sortPanel.setLayout(new GridLayout(1,4));
		sortPanel.add(sortBookNumber);
		sortBookNumber.addActionListener(new SortAction());
		sortPanel.add(sortTitle);
		sortTitle.addActionListener(new SortAction());
		sortPanel.add(sortCount);
		sortCount.addActionListener(new SortAction());
		sortPanel.add(sortPrice);
		sortPrice.addActionListener(new SortAction());
		
		//---------------------------- ����� ����� ---------------------
		
		this.add(downPanel);
		downPanel.setLayout(new BorderLayout());
				
		downPanel.add(scroller);
		table.setModel(DBUtil.getAllModelBooks());
		
		
		ResizeEverything();
	}
	
	private void ResizeEverything()
	{
		int jframeWidth=this.getWidth()-15, jframeHeight=this.getHeight()-36;
		downPanel.setLocation(0,(int) (jframeHeight/3)); // /3
		downPanel.setSize(jframeWidth, (int) (jframeHeight/1.5));// /1.5
		upPanel.setSize(jframeWidth, (int) (jframeHeight/3));// /3
	}//end ResizeEverything
	
	public void frame__windowStateChanged(WindowEvent e)
	{
		if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH)
		{
			ResizeEverything();
		}
		else ResizeEverything();
	}//enough resizing for today
	
	//ActionListeners
	private class AddAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String title = addTitleTF.getText(), authorNumberString = addAuthorNumberTF.getText(),
					isbnString = addIsbnTF.getText(), countString = addCountTF.getText(), priceString = addPriceTF.getText();
			if(title.isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �������� �� �����!</html>");
				addTitleTF.selectAll();
				addTitleTF.requestFocusInWindow();
				return;
			}
			
			int authorNumber;
			
			try {
				authorNumber = Integer.parseInt(authorNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ����� �� �����!</html>");
				  addAuthorNumberTF.selectAll();
				  addAuthorNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(authorNumber<1000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
				addAuthorNumberTF.selectAll();
				addAuthorNumberTF.requestFocusInWindow();
				return;
			}
			
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			
			String sql ="select author_number from authors where author_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, authorNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					addAuthorNumberTF.selectAll();
					addAuthorNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			
			if(isbnString.length() > 13)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>ISBN �� ���� �� � ��-����� �� 13 �������!</html>");
				addIsbnTF.selectAll();
				addIsbnTF.requestFocusInWindow();
				return;
			}
			
			long isbnCheck;
			
			try {
				isbnCheck = Long.parseLong(isbnString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>ISBN ������� ������ �� � �������� ���� �� ���� �����!</html>");
				  addIsbnTF.selectAll();
				  addIsbnTF.requestFocusInWindow();
				  return;
			  }
			
			if(isbnCheck<0)
			{
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>ISBN ������� �� ���� �� � �����������!</html>");
				  addIsbnTF.selectAll();
				  addIsbnTF.requestFocusInWindow();
				  return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="select isbn from books where isbn = ?;";
			rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, isbnString);
				rs = state.executeQuery();
				if(rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� ISBN ����� ���� ���������� � ����������!</html>");
					addIsbnTF.selectAll();
					addIsbnTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			
			int count;
			
			try {
				count = Integer.parseInt(countString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>����� �� ������� ������ �� � �����!</html>");
				  addCountTF.selectAll();
				  addCountTF.requestFocusInWindow();
				  return;
			  }
			
			if(count<0)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����� �� ������� �� ���� �� � �����������!</html>");
				addCountTF.selectAll();
				addCountTF.requestFocusInWindow();
				return;
			}
			
			float price;
			
			try {
				price = Float.parseFloat(priceString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ������ ����!</html>");
				  addPriceTF.selectAll();
				  addPriceTF.requestFocusInWindow();
				  return;
			  }
			
			if(price<0 || price>=10000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>������ � ������ ��������!</html>");
				addPriceTF.selectAll();
				addPriceTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="insert into books values(null, null, ?, ?, ?, ?, ?);";
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, title);
				state.setInt(2, authorNumber);
				state.setString(3, isbnString);
				state.setInt(4, count);
				state.setFloat(5, price);
				state.execute();
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>������� ��������� ������� \""+title+"\" � ������������!</html>");
				
				table.setModel(DBUtil.getAllModelBooksByNumberDESC());
				
				addTitleTF.setText(null);
				addAuthorNumberTF.setText(null);
				addIsbnTF.setText(null);
				addCountTF.setText(null);
				addPriceTF.setText(null);
				
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			
			CloseConn();
			
		}
		
	}//end AddAction
	
	
	void DeleteAction()
	{
			String bookNumberString = deleteBookNumberTF.getText();
			
			int bookNumber;
			
			try {
				bookNumber = Integer.parseInt(bookNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>�� ��� ������ ����� �� ����a!</html>");
				  deleteBookNumberTF.selectAll();
				  deleteBookNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(bookNumber<3000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� ������� �������� �� 3000!</html>");
				deleteBookNumberTF.selectAll();
				deleteBookNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sql ="select book_number from books where book_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				if(rs.next())
				{
					sql ="delete from books where book_number = ?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, bookNumber);
					state.execute();
					
					labelWarning.setForeground(Color.GREEN);
					labelWarning.setText("<html>������� �������� ����� � ����� "+bookNumber+"</html>");
					deleteBookNumberTF.selectAll();
					deleteBookNumberTF.requestFocusInWindow();
					
					table.setModel(DBUtil.getAllModelBooks());
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					deleteBookNumberTF.selectAll();
					deleteBookNumberTF.requestFocusInWindow();
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
		public void actionPerformed(ActionEvent arg0) {
			
			String bookNumberString = editSearchBookNumberTF.getText();
			
			int bookNumber;
			
			try {
				bookNumber = Integer.parseInt(bookNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>�� ��� ������ ����� �� ����a!</html>");
				  editSearchBookNumberTF.selectAll();
				  editSearchBookNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(bookNumber<3000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� ������� �������� �� 3000!</html>");
				editSearchBookNumberTF.selectAll();
				editSearchBookNumberTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sql ="select book_number from books where book_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				if(rs.next())
				{
					sql ="select title, author_number, isbn, count, price from books where book_number = ?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, bookNumber);
					rs = state.executeQuery();
					
					if(rs.next()) 
					{
						editNumberTF.setText(""+bookNumber);
						editTitleTF.setText(rs.getString(1));
						editAuthorNumberTF.setText(rs.getString(2));
						editIsbnTF.setText(rs.getString(3));
						editCountTF.setText(rs.getString(4));
						editPriceTF.setText(rs.getString(5));
					}
					
					labelWarning.setForeground(Color.CYAN);
					labelWarning.setText("<html>� ������� ����������� ����� � ����� "+bookNumber+"</html>");
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					editSearchBookNumberTF.selectAll();
					editSearchBookNumberTF.requestFocusInWindow();
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
			
			String bookNumberString=editNumberTF.getText(), title = editTitleTF.getText(), authorNumberString = editAuthorNumberTF.getText(),
					isbnString = ""+editIsbnTF.getText(), countString = editCountTF.getText(), priceString = editPriceTF.getText();
			if(title.isEmpty() || authorNumberString.isEmpty() || isbnString.isEmpty() || countString.isEmpty() || priceString.isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>���� ��������� ������ ������!</html>");
			}
			
			int bookNumber;
			
			try {
				bookNumber = Integer.parseInt(bookNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ����� �� �������!</html>");
				  editNumberTF.selectAll();
				  editNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(bookNumber<3000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� ������� �������� �� 3000!</html>");
				addAuthorNumberTF.selectAll();
				addAuthorNumberTF.requestFocusInWindow();
				return;
			}
			
			int authorNumber;
			
			try {
				authorNumber = Integer.parseInt(authorNumberString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ����� �� �����!</html>");
				  addAuthorNumberTF.selectAll();
				  addAuthorNumberTF.requestFocusInWindow();
				  return;
			  }
			
			if(authorNumber<1000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
				addAuthorNumberTF.selectAll();
				addAuthorNumberTF.requestFocusInWindow();
				return;
			}
			
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			
			String sql ="select book_number from books where book_number = ?;";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					editNumberTF.selectAll();
					editNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			
			
			sql ="select author_number from authors where author_number = ?;";
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, authorNumber);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					editAuthorNumberTF.selectAll();
					editAuthorNumberTF.requestFocusInWindow();
					CloseConn();
					return;
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			
			if(isbnString.length() > 13)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>ISBN �� ���� �� � ��-����� �� 13 �������!</html>");
				editIsbnTF.selectAll();
				editIsbnTF.requestFocusInWindow();
				return;
			}
			
			long isbnCheck;
			
			try {
				isbnCheck = Long.parseLong(isbnString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>ISBN ������� ������ �� � �������� ���� �� ���� �����!</html>");
				  editIsbnTF.selectAll();
				  editIsbnTF.requestFocusInWindow();
				  return;
			  }
			
			if(isbnCheck<0)
			{
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>ISBN ������� �� ���� �� � �����������!</html>");
				  editIsbnTF.selectAll();
				  editIsbnTF.requestFocusInWindow();
				  return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String testIsbn=null;
			try {
				sql ="select isbn from books where book_number = ?;";
				state = conn.prepareStatement(sql);
				state.setInt(1, bookNumber);
				rs = state.executeQuery();
				if(rs.next())
				{
					testIsbn = rs.getString(1);

					System.out.println(testIsbn + " - " + isbnString);
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			
			if( !testIsbn.equals(isbnString) )
			{
				try {
					sql ="select isbn from books where isbn like ?;";
					state = conn.prepareStatement(sql);
					state.setString(1, isbnString);
					rs = state.executeQuery();
					if(rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>���� ISBN ����� ���� ���������� � ����������!</html>");
						editIsbnTF.selectAll();
						editIsbnTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				}catch(SQLException e8)
				{
					WarnNotDone();
					e8.printStackTrace();
				}
			}
			CloseConn();
			
			int count;
			
			try {
				count = Integer.parseInt(countString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>����� �� ������� ������ �� � �����!</html>");
				  editCountTF.selectAll();
				  editCountTF.requestFocusInWindow();
				  return;
			  }
			
			if(count<0)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����� �� ������� �� ���� �� � �����������!</html>");
				editCountTF.selectAll();
				editCountTF.requestFocusInWindow();
				return;
			}
			
			float price;
			
			try {
				price = Float.parseFloat(priceString);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ������ ����!</html>");
				  editPriceTF.selectAll();
				  editPriceTF.requestFocusInWindow();
				  return;
			  }
			
			if(price<0 || price>=10000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>������ � ������ ��������!</html>");
				editPriceTF.selectAll();
				editPriceTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			sql ="update books set title = ?, author_number = ?, isbn = ?, count = ?, price = ? where book_number = ?;";
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, title);
				state.setInt(2, authorNumber);
				state.setString(3, isbnString);
				state.setInt(4, count);
				state.setFloat(5, price);
				state.setFloat(6, bookNumber);
				state.execute();
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>������� ������������ ������� \""+title+"\" ["+bookNumber+"]</html>");
				
				table.setModel(DBUtil.getAllModelBooks());
				
				editNumberTF.setText(null);
				editTitleTF.setText(null);
				editAuthorNumberTF.setText(null);
				editIsbnTF.setText(null);
				editCountTF.setText(null);
				editPriceTF.setText(null);
				
				editSearchBookNumberTF.selectAll();
				editSearchBookNumberTF.requestFocusInWindow();
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
		
	}//end EditAction
	
	private class SearchAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[0])) //�� � �� �����
			{
				String bookNumberString = searchTF.getText();
				
				int bookNumber;
				
				try {
					bookNumber = Integer.parseInt(bookNumberString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>��������� �� ������� � �� � �� �����!</html>");
					  searchTF.selectAll();
					  searchTF.requestFocusInWindow();
					  CloseConn();
					  return;
				  }
				
				if(bookNumber<3000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�������� �� ������� �������� �� 3000!</html>");
					searchTF.selectAll();
					searchTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				String sql ="select book_number from books where book_number = ?;";
				ResultSet rs=null;
				
				try {
					state = conn.prepareStatement(sql);
					state.setInt(1, bookNumber);
					rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByNumber(bookNumber));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>�������� � ����� � ����� "+bookNumber+"</html>");
				searchTF.setText(null);
				
			}
			else if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[1])) //�� ��������
			{
				if(searchTF.getText().isEmpty())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� �������� �������� �� �����!</html>");
					searchTF.selectAll();
					searchTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				String title = searchTF.getText();
				
				String sql ="select title from books WHERE CHARINDEX(?, title) > 0;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, title);
					ResultSet rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���� �������� ����� � ������� ��������!</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByTitle(title));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��������(�) �/�� �����(�) ��� ��������, ��������� "+title+"</html>");
				searchTF.setText(null);
			}
			else if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[2])) //�� � �� �����
			{
				String authorNumberString = searchTF.getText();
				
				int authorNumber;
				
				try {
					authorNumber = Integer.parseInt(authorNumberString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>���� �������� ����� �� �����!</html>");
					  searchTF.selectAll();
					  searchTF.requestFocusInWindow();
					  CloseConn();
					  return;
				  }
				
				if(authorNumber<1000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
					searchTF.selectAll();
					searchTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				String sql ="select author_number from books where author_number = ?;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setInt(1, authorNumber);
					ResultSet rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���� �������� ����� � ���� ����� �� �����!</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByAuthorNumber(authorNumber));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��������(�) �/�� �����(�) �� ����� � ����� "+authorNumber+"</html>");
				searchTF.setText(null);
			}
			else if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[3])) //�� ��� �� �����
			{
				if(searchTF.getText().isEmpty())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� �������� ��� �� �����!</html>");
					searchTF.selectAll();
					searchTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				String name = searchTF.getText();
				
				String sql ="select b.book_number from books b join authors a on b.author_number = a.author_number WHERE CHARINDEX(?, a.name) > 0;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, name);
					ResultSet rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���� �������� ����� �� ���� �����!</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByAuthorName(name));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��������(�) �/�� �����(�) �� �����(�) "+name+"</html>");
				searchTF.setText(null);
			}
			else if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[4])) //�� ISBN
			{
				String isbnString = searchTF.getText();
				
				if(isbnString.length() > 13)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>ISBN �� ���� �� � ��-����� �� 13 �������!</html>");
					editIsbnTF.selectAll();
					editIsbnTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				long isbnCheck;
				
				try {
					isbnCheck = Long.parseLong(isbnString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>ISBN ������� ������ �� � �������� ���� �� ���� �����!</html>");
					  editIsbnTF.selectAll();
					  editIsbnTF.requestFocusInWindow();
					  CloseConn();
					  return;
				  }
				
				if(isbnCheck<0)
				{
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>ISBN ������� �� ���� �� � �����������!</html>");
					  editIsbnTF.selectAll();
					  editIsbnTF.requestFocusInWindow();
					  CloseConn();
					  return;
				}
				
				String sql ="select isbn from books WHERE CHARINDEX(?, isbn) > 0;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, isbnString);
					ResultSet rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���� �������� ����� � ����� ISBN!</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByISBN(isbnString));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��������(�) �/�� �����(�), �����/��� ISBN �������(�) "+isbnString+"</html>");
				searchTF.setText(null);
				
			}
			else if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[5])) //���� > ��:
			{
				String priceString = searchTF.getText();
				
				float price;
				
				try {
					price = Float.parseFloat(priceString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>���� �������� ������ ����!</html>");
					  editPriceTF.selectAll();
					  editPriceTF.requestFocusInWindow();
					  CloseConn();
					  return;
				  }
				
				if(price<0 || price>=10000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>������ � ������ ��������!</html>");
					editPriceTF.selectAll();
					editPriceTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				String sql ="select book_number from books where price > ?;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setFloat(1, price);
					ResultSet rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���� �������� ����� � ���� ��-������ �� "+price+" ��</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByPriceGreater(price));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��������(�) �/�� �����(�), �����/��� ����(�) �/�� ��-������ �� "+price+" ��</html>");
				searchTF.setText(null);
				
			}
			else //���� < ��:
			{
				
				String priceString = searchTF.getText();
				
				float price;
				
				try {
					price = Float.parseFloat(priceString);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>���� �������� ������ ����!</html>");
					  editPriceTF.selectAll();
					  editPriceTF.requestFocusInWindow();
					  CloseConn();
					  return;
				  }
				
				if(price<0 || price>=10000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>������ � ������ ��������!</html>");
					editPriceTF.selectAll();
					editPriceTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				String sql ="select book_number from books where price < ? and book_number>2999;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setFloat(1, price);
					ResultSet rs = state.executeQuery();
					if(!rs.next())
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���� �������� ����� � ���� ��-����� �� "+price+" ��</html>");
						searchTF.selectAll();
						searchTF.requestFocusInWindow();
						CloseConn();
						return;
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
				table.setModel(DBUtil.getAllModelBooksByPriceLower(price));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��������(�) �/�� �����(�), �����/��� ����(�) �/�� ��-�����(�) �� "+price+" ��</html>");
				searchTF.setText(null);
				
			}
			
		}
		
	}//end SearchAction
	
	private class SortAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent ev) {
			String bool;
			
			if(isASC)
			{
				isASC=false;
				bool="(���������)";
			}
			else
			{
				isASC=true;
				bool="(���������)";
			}
			
			Color Redish = new Color(255, 77, 77);
			Color Bluish = new Color(179, 204, 255);
			
			if(ev.getSource() == sortBookNumber) //�� �����
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelBooksByNumberDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>������� �� ��������� � �������� ��� ������ ��������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelBooksByNumberASC());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>������� �� ��������� ��� �������� ��� ������ ��������.</html>");
				}
				
			}
			else if(ev.getSource() == sortTitle) //�� ��������
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelBooksByTitleDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>������� �� ��������� � �������� ��� ������ ����������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelBooksByTitleASC());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>������� �� ��������� ��� �������� ��� ������ ����������.</html>");
				}
				
			}
			else if(ev.getSource() == sortCount) //�� ����
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelBooksByCountDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>������� �� ��������� � �������� ��� ������ �������� �� ����.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelBooksByCountASC());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>������� �� ��������� ��� �������� ��� ������ �������� �� ����.</html>");
				}
				
			}
			else if(ev.getSource() == sortPrice) //�� ����
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelBooksByPriceDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>������� �� ��������� � �������� ��� ������ ������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelBooksByPriceASC());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>������� �� ��������� ��� �������� ��� ������ ������.</html>");
				}
				
			}
			
			sortBookNumber.setText("� �� ����� "+bool);
			sortTitle.setText("�������� "+bool);
			sortCount.setText("���� "+bool);
			sortPrice.setText("���� "+bool);
			
		}
		
	}
	
	
	//--
		private void WarnNoConnection()
		{
			labelWarning.setForeground(Color.RED);
			labelWarning.setText("<html>��������� ������ � ����������!</html>");
		}
		private void WarnNotDone()
		{
			labelWarning.setForeground(Color.RED);
			labelWarning.setText("<html>������ �� ���� �������� ������!</html>");
		}
		
		private void CloseConn() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
