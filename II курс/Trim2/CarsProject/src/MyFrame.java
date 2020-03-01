import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	int id=0;
	
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	JButton addBtn = new JButton("Add");
	JButton searchBtn = new JButton("Search");
	JButton updateBtn = new JButton("Update");
	
	JLabel markLabel = new JLabel("Mark:");
	JLabel modelLabel = new JLabel("Model:");
	JLabel yearLabel = new JLabel("Year:");
	JLabel engineLabel = new JLabel("Engine:");
	
	JTextField markTField = new JTextField();
	JTextField modelTField = new JTextField();
	JTextField yearTField = new JTextField();
	JTextField seachTField = new JTextField(10);
	String[] content = {"Gasoline", "Diesel", "LPG"};
	JComboBox<String> engineCBox = new JComboBox<String>(content);
	
	public MyFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));
		this.add(upPanel);
		this.add(midPanel);
		this.add(downPanel);
		
		//upPanel
		upPanel.setLayout(new GridLayout(4, 2));
		upPanel.add(markLabel);
		upPanel.add(markTField);
		upPanel.add(modelLabel);
		upPanel.add(modelTField);
		upPanel.add(yearLabel);
		upPanel.add(yearTField);
		upPanel.add(engineLabel);
		upPanel.add(engineCBox);
		//midPanel
		midPanel.add(addBtn);
		addBtn.addActionListener(new AddCar());
		midPanel.add(searchBtn);
		searchBtn.addActionListener(new SearchAction());
		midPanel.add(seachTField);
		midPanel.add(updateBtn);
		updateBtn.addActionListener(new UpdateAction());
		//downPanel
		scroller.setPreferredSize(new Dimension(450, 120));
		downPanel.add(scroller);
		try {
			table.setModel(new MyModel(getAllFromCars()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.addMouseListener(new ClickAction());
	}//end constructor
	
	class UpdateAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String mark = markTField.getText();
			String model = modelTField.getText();
			int year = Integer.parseInt(yearTField.getText());
			String engine = (String) engineCBox.getSelectedItem();
			
			String sql = "update car set mark=?, model=?, year=?, engine=? where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, mark);
				state.setString(2, model);
				state.setInt(3, year);
				state.setString(4, engine);
				state.setInt(5, id);
				state.execute();
				table.setModel(new MyModel(getAllFromCars()));
				clearForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}//end UpdateAction
	
	class ClickAction implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			String idText = table.getValueAt(row, 0).toString();
			id = Integer.parseInt(idText);
			
			markTField.setText((String) table.getValueAt(row, 1));
			modelTField.setText((String) table.getValueAt(row, 2));
			yearTField.setText(table.getValueAt(row, 3).toString());
			engineCBox.setSelectedItem(table.getValueAt(row, 4));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}//end ClickAction
	
	public ResultSet getAllFromCars() {
		conn = DBConnector.getConnection();
		String sql = "SELECT * FROM CAR";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}//end method
	
	class SearchAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String input = seachTField.getText();
			String sql = "select model,engine from car where model like ?;";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1,"%" + input + "%");
				result = state.executeQuery();
				table.setModel(new MyModel(result));
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
		
	}//end SearchAction
	
	class AddCar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String mark = markTField.getText();
			String model = modelTField.getText();
			int year = Integer.parseInt(yearTField.getText());
			String engine = (String) engineCBox.getSelectedItem();
			
			String sql = "insert into car values(null,?,?,?,?);";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, mark);
				state.setString(2, model);
				state.setInt(3, year);
				state.setString(4, engine);
				state.execute();
				clearForm();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}//end actionPerformed
		
	}//end AddCar
	
	public void clearForm() {
		markTField.setText("");
		modelTField.setText("");
		yearTField.setText("");
		engineCBox.setSelectedIndex(0);
	}

}//end MyFrame class
