import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ExtraFrame extends JFrame{
	
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
	
	//������� 1: ������ ����� �� ������ �� ���
	
	JLabel descrLabel1 = new JLabel("��� �� ������");
	JPanel spravka1Panel = new JPanel();
	JTextField authorNameTF=new JTextField();
	JButton searchButton1=new JButton("������ �����");
	
	//������� 2: ������ �����, ����� � ������� ������ �� ��������� �����
	
	JLabel descrLabel2=new JLabel("� �� ������");
	JPanel spravka2Panel = new JPanel();
	JTextField clientNumTF = new JTextField();
	JButton searchButton2=new JButton("������ �����");
	
	//������� �������
	JButton searchExtraButton = new JButton("������� �������");
	
	
	//------------������ �� ������ �����-------------
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	public ExtraFrame()
	{
		this.setTitle("������������ �������");
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(600, 178);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width-this.getSize().width, 0);
		
		//---------------------------------- ����� ����� ---------------------
		this.add(upPanel);
		upPanel.setLocation(0,0);
		upPanel.setSize(600,150);
		upPanel.setVisible(true);
		upPanel.setLayout(new GridLayout(6,1));
		
		//���������
		upPanel.add(warningPanel);
		warningPanel.add(labelWarning);
		warningPanel.setBackground(new Color(89, 89, 89));
		warningPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		labelWarning.setForeground(new Color(215, 248, 215));
		
		//������� 1: ������ ����� �� ������ �� ���
		
		upPanel.add(descrLabel1);
		upPanel.add(spravka1Panel);
		spravka1Panel.setLayout(new GridLayout(1,2));
		spravka1Panel.add(authorNameTF);
		spravka1Panel.add(searchButton1);
		
		searchButton1.addActionListener(new SearchAction1());
		
		
		
		//������� 2: ������ �����, ����� � ������� ������ �� ��������� �����
		
		upPanel.add(descrLabel2);
		upPanel.add(spravka2Panel);
		spravka2Panel.setLayout(new GridLayout(1,2));
		spravka2Panel.add(clientNumTF);
		spravka2Panel.add(searchButton2);
		
		searchButton2.addActionListener(new SearchAction2());
		
		//������� 3:
		upPanel.add(searchExtraButton);
		searchExtraButton.addActionListener(new BonusSearchAction());
		
		
		//---------------------------- ����� ����� ---------------------
		
		this.add(downPanel);
		downPanel.setLocation(0,150);
		downPanel.setSize(596,340);
		downPanel.setLayout(new BorderLayout());
		
		downPanel.add(scroller);
		//table.setModel(DBUtil.getAllModelAuthors());
	}
	
	private class BonusSearchAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(clientNumTF.getText().isEmpty() || authorNameTF.getText().isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>���� ��������� � ����� ������!</html>");
				return;
			}
			
			String clientNumber = clientNumTF.getText();
			int number;
			
			try {
			    number = Integer.parseInt(clientNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ��������� �����!</html>");
				  clientNumTF.selectAll();
				  clientNumTF.requestFocusInWindow();
				  return;
			  }
			
			if(number<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����������� ������ �������� �� 5000!</html>");
				clientNumTF.selectAll();
				clientNumTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sql ="select client_number from orders where client_number="+number+";";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>������ "+number+" ���� �������!</html>");
					clientNumTF.selectAll();
					clientNumTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				//�� ���� ���� ���� ����� ������ ���������� ��� �������
				String name = authorNameTF.getText();
				sql ="select b.book_number from books b join authors a on b.author_number = a.author_number WHERE a.name like ?;";
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� ����� �� ����� "+name+"</html>");
					authorNameTF.selectAll();
					authorNameTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				sql = "select b.book_number, title, isbn, count, price from books b join orders o on b.book_number=o.book_number join authors a on b.author_number = a.author_number where o.client_number="+number+" and b.author_number=select author_number from authors where name like '"+name+"';";
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� ����� �� ����� "+name+", ����� �� � �������� �� ������ � ����� "+number+"</html>");
					CloseConn();
					return;
				}
					
					
				table.setModel(DBUtil.getModelExtra(name, number));
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��� �����/� �� ����� "+name+", �����/��� �� �/�� ��������/� �� ������ � ����� "+number+"</html>");
				
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			setSize(600, 500);
			
		}
		
	}
	
	private class SearchAction2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String clientNumber = clientNumTF.getText();
			int number;
			
			try {
			    number = Integer.parseInt(clientNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>���� �������� ��������� �����!</html>");
				  clientNumTF.selectAll();
				  clientNumTF.requestFocusInWindow();
				  return;
			  }
			
			if(number<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����������� ������ �������� �� 5000!</html>");
				clientNumTF.selectAll();
				clientNumTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sql ="select client_number from orders where client_number="+number+";";
			ResultSet rs=null;
			
			try {
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>������ "+number+" ���� �������!</html>");
					clientNumTF.selectAll();
					clientNumTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				table.setModel(DBUtil.getModelExtra2(number));
				
				sql = "select sum(o.quantity), sum(b.price*o.quantity) from books b join orders o on b.book_number=o.book_number where o.client_number="+number+";";
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				
				int count=0;
				float totalPrice=0;
				if(rs.next())
				{
					count=rs.getInt(1);
					totalPrice=rs.getFloat(2);
				}
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>���� ������ � ������� "+count+" ����� �� ���� �������� "+totalPrice+"</html>");
				clientNumTF.setText(null);
				
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			setSize(600, 500);
		}
		
	}
	
	private class SearchAction1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(authorNameTF.getText().isEmpty())
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>�� ��� ������ ��� �� �����!</html>");
				authorNameTF.selectAll();
				authorNameTF.requestFocusInWindow();
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String name = authorNameTF.getText();
			String sql ="select author_number from authors where name like ?;";
			ResultSet rs=null;
			int authorNumber=0;
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				rs = state.executeQuery();
				if(!rs.next())
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���������� ����� � ���� ���!</html>");
					authorNameTF.selectAll();
					authorNameTF.requestFocusInWindow();
					CloseConn();
					return;
				}
				
				authorNumber=rs.getInt(1);
				
				table.setModel(DBUtil.getModelExtra1(authorNumber));
				
				sql ="select count(book_id) from books where author_number = "+authorNumber+";";
				state = conn.prepareStatement(sql);
				rs = state.executeQuery();
				
				int count=0;
				if(rs.next())  count=rs.getInt(1);
				
				labelWarning.setForeground(Color.GREEN);
				labelWarning.setText("<html>��� ���� �� ������� �� ���� �����: "+count+"</html>");
				authorNameTF.setText(null);
				
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
			setSize(600, 500);
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
