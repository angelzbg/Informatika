import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class AuthorsFrame extends JFrame{
	
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
	JTextField addAuthorName = new JTextField("��� �� ������");
	JButton addButton= new JButton("������");
	
	//���������
	JPanel deleteLabelPanel = new JPanel();
	JLabel deleteLabel = new JLabel("���������");
	JPanel deletePanel = new JPanel();
	JTextField delAuthorNum = new JTextField("����� �� ������");
	JButton delButton = new JButton("������");
	
	//����������� �� �����
	JPanel editLabelPanel = new JPanel();
	JLabel editLabel = new JLabel("����������� �� �����");
	
	JPanel editPanel1 = new JPanel();
	JLabel authorNumLabel = new JLabel("����� �� ������ �� �����������: ", SwingConstants.RIGHT);
	JTextField searchNumberForEdit = new JTextField("�������� 1000");
	JButton searchForEditButton = new JButton("�����");
	
	JPanel editPanel2 = new JPanel();
	JTextField editAuthorNumber = new JTextField("����� �� ������");
	JTextField editAuthorName = new JTextField("��� �� ������");
	JButton editAuthorButton = new JButton("����������");
	
	//������� �� �����
	JPanel searchLabelPanel = new JPanel();
	JLabel searchLabel = new JLabel("������� �� �����");
	
	JPanel searchPanel = new JPanel();
	String[] criteriaList = { "�� � �� ������", "�� ���(��)" };
	JComboBox searchCriteriaList = new JComboBox(criteriaList);
	JTextField searchKriteria = new JTextField();
	JButton searchButton = new JButton("�����");
	
	//���������
	JPanel sortLabelPanel = new JPanel();
	JLabel sortLabel = new JLabel("��������� �� ������ ������ � ����������");
	JPanel sortPanel = new JPanel();
	JButton sortByNumber = new JButton("� �� ������ (���������)");
	JButton sortByName = new JButton("��� (���������)");
	
	private boolean isASC=true;
	
	//------------������ �� ������ �����-------------
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	public AuthorsFrame()
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
		
		this.setTitle("������");
		this.setVisible(true);
		this.setLayout(null);
		this.setMinimumSize(new Dimension(700,900));
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		addPanel.setLayout(new GridLayout(1,2));
		addPanel.add(addAuthorName);
		addPanel.add(addButton);
		
		addButton.addActionListener(new AddAction());
		
		//���������
		upPanel.add(deleteLabelPanel);
		deleteLabelPanel.add(deleteLabel);
		
		upPanel.add(deletePanel);
		deletePanel.setLayout(new GridLayout(1,2));
		deletePanel.add(delAuthorNum);
		deletePanel.add(delButton);
		
		
		//����������� �� �����
		upPanel.add(editLabelPanel);
		editLabelPanel.add(editLabel);
		
		upPanel.add(editPanel1);
		editPanel1.setLayout(new GridLayout(1,3));
		editPanel1.add(authorNumLabel);
		editPanel1.add(searchNumberForEdit);
		editPanel1.add(searchForEditButton);
		searchForEditButton.addActionListener(new SearchAuthorForEdit());
		
		upPanel.add(editPanel2);
		editPanel2.setLayout(new GridLayout(1,3));
		editPanel2.add(editAuthorNumber);
		editPanel2.add(editAuthorName);
		editPanel2.add(editAuthorButton);
		editAuthorButton.addActionListener(new EditAction());
		
		
		//������� �� �����
		upPanel.add(searchLabelPanel);
		searchLabelPanel.add(searchLabel);
		
		
		upPanel.add(searchPanel);
		searchPanel.setLayout(new GridLayout(1,3));
		searchPanel.add(searchCriteriaList);
		searchPanel.add(searchKriteria);
		searchPanel.add(searchButton);
		searchButton.addActionListener(new SearchAction());
		
		//���������
		upPanel.add(sortLabelPanel);
		sortLabelPanel.add(sortLabel);
		
		upPanel.add(sortPanel);
		sortPanel.setLayout(new GridLayout(1,2));
		sortPanel.add(sortByNumber);
		sortPanel.add(sortByName);
		sortByNumber.addActionListener(new SortAction());
		sortByName.addActionListener(new SortAction());
		
		
		
		//---------------------------- ����� ����� ---------------------
		
		this.add(downPanel);
		downPanel.setLayout(new BorderLayout());
		
		downPanel.add(scroller);
		table.setModel(DBUtil.getAllModelAuthors());
		
		
		
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
		/*if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH)
		{
			ResizeEverything();
		}
		else ResizeEverything();*/
		ResizeEverything();
	}//enough resizing for today
	
	private class AddAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String aName = addAuthorName.getText();
			
			if(aName.length()==0)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�� ��� ������ ���!</html>");
				addAuthorName.selectAll();
				addAuthorName.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sql ="select name from authors where name = ?;";
			
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, aName);
				rs = state.executeQuery();
				
				if(rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� ���������� ����� � ���� ���!</html>");
					addAuthorName.selectAll();
					addAuthorName.requestFocusInWindow();
				}
				else
				{
					sql ="insert into authors values(null,null,?);";
					state = conn.prepareStatement(sql);
					state.setString(1, aName);
					state.execute();
					table.setModel(DBUtil.getAllModelAuthors());
					addAuthorName.selectAll();
					addAuthorName.requestFocusInWindow();
					labelWarning.setForeground(Color.GREEN);
					labelWarning.setText("<html>������� ��������� �����!</html>");
					table.setModel(DBUtil.getAllModelAuthorsByNumberDESC());
				}
			} catch (SQLException e1) {
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>��������� �����!</html>");
				e1.printStackTrace();
			}
			
			CloseConn();
			
		}
		
	}//end AddAction
	
	void DeleteAction()
	{
			String aNumber = delAuthorNum.getText();
			
			int number;
			
			try {
			    number = Integer.parseInt(aNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ����� �� �����!</html>");
				  delAuthorNum.selectAll();
				  delAuthorNum.requestFocusInWindow();
				  return;
			  }
			
			if(number<1000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
				delAuthorNum.selectAll();
				delAuthorNum.requestFocusInWindow();
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
				state.setInt(1, number);
				rs = state.executeQuery();
				
				if(rs.next())
				{
					sql ="delete from authors where author_number = ?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, number);
					state.execute();
					table.setModel(DBUtil.getAllModelAuthors());
					labelWarning.setForeground(Color.GREEN);
					labelWarning.setText("<html>������� �������� ����� � ����� "+number+"</html>");
					delAuthorNum.selectAll();
					delAuthorNum.requestFocusInWindow();
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					delAuthorNum.selectAll();
					delAuthorNum.requestFocusInWindow();
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			
			CloseConn();
	}//end DeleteAction
	
	private class SearchAuthorForEdit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String aNumber = searchNumberForEdit.getText();
			
			int number;
			
			try {
			    number = Integer.parseInt(aNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ����� �� �����!</html>");
				  searchNumberForEdit.selectAll();
				  searchNumberForEdit.requestFocusInWindow();
				  return;
			  }
			
			if(number<1000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
				searchNumberForEdit.selectAll();
				  searchNumberForEdit.requestFocusInWindow();
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
				state.setInt(1, number);
				rs = state.executeQuery();
				
				if(rs.next())
				{
					sql ="select name from authors where author_number = ?;";
					state = conn.prepareStatement(sql);
					state.setInt(1, number);
					ResultSet rsName = state.executeQuery();
					String name=null;
					if(rsName.next()) name = rsName.getString(1);
					editAuthorNumber.setText(""+number);
					editAuthorName.setText(name);
					searchNumberForEdit.setText(null);
					labelWarning.setForeground(Color.CYAN);
					labelWarning.setText("<html>����������� ����� � ����� "+number+"</html>");
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					searchNumberForEdit.selectAll();
					searchNumberForEdit.requestFocusInWindow();
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			
			CloseConn();
			
		}
	}//end SearchAuthorForEdit
	
	private class EditAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String aNum = editAuthorNumber.getText();
			
			int number;
			
			try {
			    number = Integer.parseInt(aNum);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ����� �� �����!</html>");
				  editAuthorNumber.selectAll();
				  editAuthorNumber.requestFocusInWindow();
				  return;
			  }
			
			if(number<1000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
				editAuthorNumber.selectAll();
				editAuthorNumber.requestFocusInWindow();
				return;
			}
			
			String name = editAuthorName.getText();
			if(name.length()==0)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�� ��� ������ ���!</html>");
				editAuthorName.selectAll();
				editAuthorName.requestFocusInWindow();
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
				state.setInt(1, number);
				rs = state.executeQuery();
				
				if(rs.next())
				{
					sql ="update authors set name=? where author_number = ?;";
					state = conn.prepareStatement(sql);
					state.setString(1, name);
					state.setInt(2, number);
					state.execute();
					table.setModel(DBUtil.getAllModelAuthors());
					labelWarning.setForeground(Color.GREEN);
					labelWarning.setText("<html>������������ ����� � ����� "+number+" �������!</html>");
					editAuthorNumber.setText(null);
					editAuthorName.setText(null);
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
					editAuthorNumber.selectAll();
					editAuthorNumber.requestFocusInWindow();
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			
			CloseConn();
			
		}
	}//end EditAction
	
	private class SearchAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[0])) //�� � �� ������
			{
				String aNum = searchKriteria.getText();
				
				int number;
				
				try {
				    number = Integer.parseInt(aNum);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>���������� �������� �� ������� � �� �����!</html>");
					  searchKriteria.selectAll();
					  searchKriteria.requestFocusInWindow();
					  return;
				  }
				
				if(number<1000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�������� �� �������� �������� �� 1000!</html>");
					searchKriteria.selectAll();
					searchKriteria.requestFocusInWindow();
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
					state.setInt(1, number);
					rs = state.executeQuery();
					
					if(rs.next())
					{
						table.setModel(DBUtil.getModelAuthorByNumber(number));
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>������� � ����� � ����� "+number+"</html>");
						searchKriteria.setText(null);
					}
					else
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���������� ����� � ���� �����!</html>");
						searchKriteria.selectAll();
						searchKriteria.requestFocusInWindow();
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				
				CloseConn();
				
			}
			else //�� ��� �� ������
			{
				if(searchKriteria.getText().isEmpty())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ��� ������ ��� � ������ �� �������!</html>");
					return;
				}
				
				String name = searchKriteria.getText();
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				String sql ="select author_number from authors WHERE CHARINDEX(?, name) > 0;";
				
				ResultSet rs=null;
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, name);
					rs = state.executeQuery();
					
					if(rs.next())
					{
						table.setModel(DBUtil.getModelAuthorByName(name));
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>�������(�) �/�� �����(�) � ��� "+name+"</html>");
						searchKriteria.setText(null);
					}
					else
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� ���������� ����� � �o�� ���!</html>");
						searchKriteria.selectAll();
						searchKriteria.requestFocusInWindow();
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				
				CloseConn();
			}
			
		}
	}//end SearchAction
	
	private class SortAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
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
			
			if(event.getSource()==sortByNumber)
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelAuthorsByNumberDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>�������� �� ��������� � �������� ��� ������ ��������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelAuthorsByNumberASC());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>�������� �� ��������� ��� �������� ��� ������ ��������.</html>");
				}
			}
			else if(event.getSource()==sortByName)
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelAuthorsByNameDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>�������� �� ��������� � �������� ��� ������ �������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelAuthorsByNameASC());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>�������� �� ��������� ��� �������� ��� ������ �������.</html>");
				}
			}
			
			sortByNumber.setText("� �� ������ "+bool);
			sortByName.setText("��� "+bool);
			
		}
		
	}//end SortAction
	
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
