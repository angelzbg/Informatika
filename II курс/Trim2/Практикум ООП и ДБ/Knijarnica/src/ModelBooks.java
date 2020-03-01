import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class ModelBooks extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResultSet result;	
	private int rowCount;	
	private int columnCount;
	private ArrayList<Object> data=new ArrayList<Object>();
	 
	 public ModelBooks(ResultSet rs) throws Exception
	 {
		 setRS(rs);
	 }// end constructor
	 
	 public void setRS(ResultSet rs) throws Exception
	 {
		 this.result=rs;
		 ResultSetMetaData metaData=rs.getMetaData();
		 rowCount=0;
		 columnCount=metaData.getColumnCount();
		 
		 while(rs.next())
		 {
			 Object[] row=new Object[columnCount];
			 for(int j=0;j<columnCount;j++)
			 {
				 row[j]=rs.getObject(j+1);
				 
				 if(j==(columnCount-4))
				 {
					 int b = Integer.valueOf(row[j].toString());
					 if(b<1000) row[j] = "ИЗТРИТ";
				 }
			 }			 
			 data.add(row);
			 rowCount++;
		 }// while
		 
	 }// end setRS - filling ArrayList with ResultSet values
	 
	 public int getColumnCount(){
		 return columnCount;
	 }
	 
	 public int getRowCount(){
		 return rowCount;
	 }
	 
	 public Object getValueAt(int rowIndex, int columnIndex){
		 Object[] row=(Object[]) data.get(rowIndex);
		 return row[columnIndex];
	 }
	 
	 public String getColumnName(int columnIndex){
		 switch (columnIndex) {
			default: return super.getColumnName(columnIndex);
			case 0: return "№ на книга";
			case 1: return "Заглавие";
			case 2: return "№ на автор";
			case 3: return "ISBN";
			case 4: return "Наличен брой";
			case 5:	return "Единична цена";
		}
	 }// end getColumnName
}