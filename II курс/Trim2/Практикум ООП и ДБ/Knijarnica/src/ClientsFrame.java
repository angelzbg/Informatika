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

public class ClientsFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Connection conn = null;
	PreparedStatement state = null;
	
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	JPanel downPanel = new JPanel();
	
	JPanel upPanel = new JPanel();
	
	JPanel warningPanel = new JPanel();
	JPanel addPanel = new JPanel();
	JPanel removePanel = new JPanel();
	JPanel searchPanel = new JPanel();
	JPanel sortPanel = new JPanel();
	
	JTextField tfieldAddName = new JTextField();
	JTextField tfieldAddAddress = new JTextField();
	private String tfieldAddNameHint = "��� �� �������", tfieldAddAddressHint = "����� �� �������";
	JButton addButton = new JButton("������");
	
	JTextField tfieldDelete = new JTextField();
	private String tfieldDeleteHint = "��������� �����";
	JButton deleteButton = new JButton("������");
	
	JLabel labelWarning = new JLabel("����������� �� ������� ���");
	
	
	JPanel miniSearch = new JPanel();
	JPanel miniEdit = new JPanel();
	
	JLabel miniSearchInfo = new JLabel("<html><font style='color:#1aa3ff;'>��������� ����� �� ������� �� �����������</font></html>", SwingConstants.RIGHT);
	JTextField tfieldMiniSearchNumber = new JTextField("�������� 5000");
	JButton miniSearchButton = new JButton("�����");
	
	JTextField tfieldEditClientNumber = new JTextField("��������� �����");
	JTextField tfieldEditNames = new JTextField("����� �� �������");
	JTextField tfieldEditAddress = new JTextField("����� �� �������");
	JButton editButton = new JButton("����������");
	
	//������ � ������� �� ���������� �� ������ ��� ���
	JPanel addDescrPanel = new JPanel();
	JLabel addDescr = new JLabel("<html><font style='color:#70db70'><i>--------------------  �������� �� ������  --------------------</i></font></html>");
	JPanel deleteDescrPanel = new JPanel();
	JLabel deleteDescr = new JLabel("<html><font style='color:#ff1a1a'><i>------------------  ��������� �� ������  ------------------</i></font></html>");
	JPanel editDescrPanel = new JPanel();
	JLabel editDescr = new JLabel("<html><font style='color:#1aa3ff'><i>----------------  ����������� �� ������  -----------------</i></font></html>");
	JPanel searchDescrPanel = new JPanel();
	JLabel searchDescr = new JLabel("<html><font style='color:#8c1aff'><i>---------------------  ������� �� ������  ---------------------</i></font></html>");
	JPanel sortDescrPanel = new JPanel();
	JLabel sortDescr = new JLabel("<html><font style='color:#3333cc'><i>--  ��������� �� ������ ������� � ����������  --</i></font></html>");
	
	// Search Criteria Combo Box
	String[] criteriaList = { "�� ��������� �", "�� ���(��)", "�� �����" };
	JComboBox searchCriteriaList = new JComboBox(criteriaList);
	
	JTextField tfieldSearch = new JTextField();
	JButton buttonSearch = new JButton("�����");
	
	//-------- ���������
	//sortButtons
	JButton sortByNumberButton = new JButton("��������� ����� (���������)");
	JButton sortByNamesButton = new JButton("����� (���������)");
	JButton sortByAddressButton = new JButton("����� (���������)");
	private boolean isASC=true;

	public ClientsFrame()
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
		
		this.setTitle("�������");
		this.setVisible(true);
		this.setLayout(null);
		this.setMinimumSize(new Dimension(800,900));
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//---------------------------------- ����� ����� ---------------------
		
		this.add(upPanel);
		upPanel.setLocation(0,0);
		upPanel.setVisible(true);
		upPanel.setLayout(new GridLayout(12,1));
		
		// warningPanel
		upPanel.add(warningPanel);
		warningPanel.add(labelWarning);
		warningPanel.setBackground(new Color(89, 89, 89));
		warningPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		labelWarning.setForeground(new Color(215, 248, 215));
		
		// addPanel
		upPanel.add(addDescrPanel);
		addDescrPanel.add(addDescr);
		upPanel.add(addPanel);
		addPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(112, 219, 112)));
		addPanel.setLayout(new GridLayout(1,3));
		addPanel.add(tfieldAddName);
		tfieldAddName.setText(tfieldAddNameHint);
		addPanel.add(tfieldAddAddress);
		tfieldAddAddress.setText(tfieldAddAddressHint);
		addPanel.add(addButton);
		addButton.addActionListener(new AddAction());
		
		// deletePanel
		upPanel.add(deleteDescrPanel);
		deleteDescrPanel.add(deleteDescr);
		upPanel.add(removePanel);
		removePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 51, 51)));
		removePanel.setLayout(new GridLayout(1,2));
		removePanel.add(tfieldDelete);
		tfieldDelete.setText(tfieldDeleteHint);
		removePanel.add(deleteButton);
		
		// Edit Panels
		upPanel.add(editDescrPanel);
		editDescrPanel.add(editDescr);
		upPanel.add(miniSearch);
		miniSearch.setLayout(new GridLayout(1,3));
		upPanel.add(miniEdit);
		miniEdit.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(26, 163, 255)));
		miniEdit.setLayout(new GridLayout(1,4));
		
		miniSearch.add(miniSearchInfo);
		miniSearch.add(tfieldMiniSearchNumber);
		miniSearch.add(miniSearchButton);
		miniSearchButton.addActionListener(new SearchForEdit());
		
		miniEdit.add(tfieldEditClientNumber);
		miniEdit.add(tfieldEditNames);
		miniEdit.add(tfieldEditAddress);
		miniEdit.add(editButton);
		
		//searchPanel
		upPanel.add(searchDescrPanel);
		searchDescrPanel.add(searchDescr);
		upPanel.add(searchPanel);
		searchPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(140, 26, 255)));
		searchPanel.setLayout(new GridLayout(1,3));
		searchPanel.add(searchCriteriaList);
		searchPanel.add(tfieldSearch);
		searchPanel.add(buttonSearch);
		buttonSearch.addActionListener(new startSearching());
		
		
		
		//sortPanel
		upPanel.add(sortDescrPanel);
		sortDescrPanel.add(sortDescr);
		upPanel.add(sortPanel);
		sortPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(51, 51, 204)));
		sortPanel.setLayout(new GridLayout(1,3));
		sortPanel.add(sortByNumberButton);
		sortByNumberButton.addActionListener(new SortTheTable());
		sortPanel.add(sortByNamesButton);
		sortByNamesButton.addActionListener(new SortTheTable());
		sortPanel.add(sortByAddressButton);
		sortByAddressButton.addActionListener(new SortTheTable());
		
		//---------------------------- ����� ����� ---------------------
		
		this.add(downPanel);
		downPanel.setLayout(new BorderLayout());
		
		downPanel.add(scroller);
		table.setModel(DBUtil.getAllModelClients());
		
		
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
		public void actionPerformed(ActionEvent e) {
			String name = tfieldAddName.getText(), address = tfieldAddAddress.getText();
			
			if(name.equals(tfieldAddNameHint) || address.equals(tfieldAddAddressHint) || name.equals("") || address.equals("") || name == null || address == null)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>���������� ��� � ����� �� ����������� ��� ������ �� �� ��������!</html>");
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sql ="insert into clients values (null,null,?,?);";
			
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				state.setString(2, address);
				state.execute();
				table.setModel(DBUtil.getAllModelClientsDESC());
				tfieldAddName.setText(null);
				tfieldAddAddress.setText(null);
				labelWarning.setForeground(Color.GREEN); //����� ������
				labelWarning.setText("<html>������� ��������� ������!</html>");
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
			String clientNumber = tfieldDelete.getText();
			int number;
			
			try {
			    number = Integer.parseInt(clientNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>����������� ������ �������� �� ������ ;)))</html>");
				  return;
			  }
			
			if(number<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����������� ������ �������� �� 5000!</html>");
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sqlCheckIfExists ="select client_id from clients where client_number = ?;";
			
			try {
				state = conn.prepareStatement(sqlCheckIfExists);
				state.setInt(1, number);
				ResultSet rsCheck = state.executeQuery();
				
				if(rsCheck.next())
				{
					String sql ="delete from clients where client_number = ?;";
					
					try {
						state = conn.prepareStatement(sql);
						state.setInt(1, number);
						state.execute();
						table.setModel(DBUtil.getAllModelClients());
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>������� �������� ������ � ��������� ����� " + number + "</html>");
						tfieldDelete.setText(null);
					} catch (SQLException e1) {
						WarnNotDone();
						e1.printStackTrace();
					}
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� ������ � ���� ����� �� �� ���� ������...</html>");
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
			
	}//end DeleteAction
	
	private class SearchForEdit implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			String clientNumber = tfieldMiniSearchNumber.getText();
			int number;
			
			try {
			    number = Integer.parseInt(clientNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>����������� ������ �������� �� ������ ;)))</html>");
				  return;
			  }
			
			if(number<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����������� ������ �������� �� 5000!</html>");
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String names=null, address=null;
			
			String sql ="select names from clients where client_number = ?;";
			String sql2 ="select address from clients where client_number = ?;";
			
			ResultSet rs1, rs2;
			
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, number);
				//state.execute();
				
				rs1 = state.executeQuery();
				
				state = conn.prepareStatement(sql2);
				state.setInt(1, number);
				state.execute();
				
				rs2 = state.executeQuery();
				
				if (rs1.next()) names = rs1.getString(1);
				if (rs2.next()) address = rs2.getString(1);
				
				if(names!=null && address!=null)
				{
					tfieldEditClientNumber.setText(""+number);
					tfieldEditNames.setText(names);
					tfieldEditAddress.setText(address);
					labelWarning.setForeground(new Color(51, 204, 255));
					labelWarning.setText("<html>����������� ������ � ����� "+number+"</html>");
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>���� ������ � ����� ��������� �����!</html>");
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
		}
		
	}//end SearchForEdit
	
	void EditAction()
	{
			String clientNumber =  tfieldEditClientNumber.getText(), name = tfieldEditNames.getText(), address = tfieldEditAddress.getText();
			
			if(clientNumber.length()==0 || name.length()==0 || address.length()==0)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>���������� ����� �� �����������!</html>");
				return;
			}
			
			int number;
			
			try {
			    number = Integer.parseInt(clientNumber);
			  } catch (NumberFormatException nfe) {
				  labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>����������� ������ �������� �� ������ ;)))</html>");
				  return;
			  }
			
			if(number<5000)
			{
				labelWarning.setForeground(Color.RED);
				labelWarning.setText("<html>����������� ������ �������� �� 5000!</html>");
				return;
			}
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			
			String sqlCheck ="select names from clients where client_number=?;";
			
			try {
				state = conn.prepareStatement(sqlCheck);
				state.setInt(1, number);
				ResultSet rs = state.executeQuery();
				
				if(rs.next())
				{
					String sql ="update clients set names=?, address=? where client_number=?;";
					state = conn.prepareStatement(sql);
					state.setString(1, name);
					state.setString(2, address);
					state.setInt(3, number);
					state.execute();
					table.setModel(DBUtil.getSpecificModelClients(number));
					tfieldAddName.setText(null);
					tfieldAddAddress.setText(null);
					labelWarning.setForeground(Color.GREEN);
					labelWarning.setText("<html>������� ������������ ������ "+number+"</html>");
					tfieldEditClientNumber.setText("��������� �����");
					tfieldEditNames.setText(tfieldAddNameHint);
					tfieldEditAddress.setText(tfieldAddAddressHint);
				}
				else
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>�� ���� ������� ������ � ����� "+number+" �� �� ���� ����������!</html>");
				}
			} catch (SQLException e1) {
				WarnNotDone();
				e1.printStackTrace();
			}
			CloseConn();
		
	}//end EditAction
	
	private class startSearching implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(tfieldSearch.getText().length()==0)
			{
				labelWarning.setForeground(Color.RED);
				  labelWarning.setText("<html>������ �� ������� � ������!</html>");
				return;
			}
			
			if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[0])) //�� �����
			{
				String clientNumber = tfieldSearch.getText();
				int number;
				
				try {
				    number = Integer.parseInt(clientNumber);
				  } catch (NumberFormatException nfe) {
					  labelWarning.setForeground(Color.RED);
					  labelWarning.setText("<html>���������� �������� �� ������� � �� ������!!!</html>");
					  return;
				  }
				
				if(number<5000)
				{
					labelWarning.setForeground(Color.RED);
					labelWarning.setText("<html>����������� ������ �������� �� 5000!</html>");
					return;
				}
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				String sql ="select client_number, names, address from clients where client_number=?;";
				
				try {
					state = conn.prepareStatement(sql);
					state.setInt(1, number);
					ResultSet rs = state.executeQuery();
					
					if(rs.next())
					{
						table.setModel(DBUtil.getSpecificModelClients(number));
						tfieldSearch.setText(null);
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>������� � ������ � ����� "+number+"</html>");
					}
					else
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� � ������� ������ � ����� "+number+"</html>");
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
			}
			else if(searchCriteriaList.getSelectedItem().toString().equals(criteriaList[1])) //�� ���
			{
				String name = tfieldSearch.getText();
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				//String sql ="select client_number, names, address from clients where names like ?;";
				String sql ="select client_number, names, address from clients WHERE CHARINDEX(?, names) > 0";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, name);
					ResultSet rs = state.executeQuery();
					
					if(rs.next())
					{
						table.setModel(DBUtil.getSpecificModelClientsName(name));
						tfieldSearch.setText(null);
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>��� ��������(�) �� ��� "+name+"</html>");
					}
					else
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� � ������� ������ � ��� "+name+"</html>");
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
				
			}
			else //�� �����
			{
				String address = tfieldSearch.getText();
				
				conn = DBUtil.getConnected();
				if(conn == null)
				{
					WarnNoConnection();
					return;
				}
				
				//String sql ="select client_number, names, address from clients where names like ?;";
				String sql ="select client_number, names, address from clients WHERE CHARINDEX(?, address) > 0";
				
				try {
					state = conn.prepareStatement(sql);
					state.setString(1, address);
					ResultSet rs = state.executeQuery();
					
					if(rs.next())
					{
						table.setModel(DBUtil.getSpecificModelClientsAddress(address));
						tfieldSearch.setText(null);
						labelWarning.setForeground(Color.GREEN);
						labelWarning.setText("<html>��� ��������(�) �� ����� "+address+"</html>");
					}
					else
					{
						labelWarning.setForeground(Color.RED);
						labelWarning.setText("<html>�� � ������� ������ � ����� "+address+"</html>");
					}
				} catch (SQLException e1) {
					WarnNotDone();
					e1.printStackTrace();
				}
				CloseConn();
			}
		}
		
	}// end startSearching
	
	private class SortTheTable implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			conn = DBUtil.getConnected();
			if(conn == null)
			{
				WarnNoConnection();
				return;
			}
			CloseConn();
			
			TurnTheBoolean();
			
			Color Redish = new Color(255, 77, 77);
			Color Bluish = new Color(179, 204, 255);
			
			if(arg0.getSource()==sortByNumberButton)
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelClientsDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>��������� �� ��������� � �������� ��� ������ ��������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelClients());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>��������� �� ��������� ��� �������� ��� ������ ��������.</html>");
				}
			}
			else if(arg0.getSource()==sortByNamesButton)
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelClientsByNameDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>��������� �� ��������� � �������� ��� ������ �������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelClientsByName());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>��������� �� ��������� ��� �������� ��� ������ �������.</html>");
				}
			}
			else if(arg0.getSource()==sortByAddressButton)
			{
				if(isASC)
				{
					table.setModel(DBUtil.getAllModelClientsByAddressDESC());
					labelWarning.setForeground(Redish);
					labelWarning.setText("<html>��������� �� ��������� � �������� ��� ������ ������.</html>");
				}
				else
				{
					table.setModel(DBUtil.getAllModelClientsByAddress());
					labelWarning.setForeground(Bluish);
					labelWarning.setText("<html>��������� �� ��������� ��� �������� ��� ������ ������.</html>");
				}
			}
		}
		
	}// end SortTheTable
	
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
	
	private void TurnTheBoolean()
	{
		if(isASC) isASC = false;
		else isASC = true;
		
		String bool;
		
		if(isASC)
		{
			bool="(���������)";
			sortByNumberButton.setForeground(Color.BLUE);
			sortByNamesButton.setForeground(Color.BLUE);
			sortByAddressButton.setForeground(Color.BLUE);
		}
		else
		{
			bool="(���������)";
			sortByNumberButton.setForeground(new Color(255, 77, 77));
			sortByNamesButton.setForeground(new Color(255, 77, 77));
			sortByAddressButton.setForeground(new Color(255, 77, 77));
		}
		
		sortByNumberButton.setText("��������� ����� " + bool);
		sortByNamesButton.setText("����� " + bool);
		sortByAddressButton.setText("����� " + bool);
	}
	
	private void CloseConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//--
}
