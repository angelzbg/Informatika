import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class ModelOrders1 extends AbstractTableModel {
	
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResultSet result;	
	private int rowCount;	
	private int columnCount;
	private ArrayList<Object> data=new ArrayList<Object>();
	 
	 public ModelOrders1(ResultSet rs) throws Exception
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
				 
				 if(j==(columnCount-1))
				 {
					 boolean b = Boolean.valueOf(row[j].toString());
					 if(b) row[j] = "Изпълнена";
					 else row[j] = "Неизпълнена";
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
			case 0: return "№ Поръчка";
			case 1: return "Имена на клиента";
			case 2: return "Клиентски №";
			case 3: return "Заглавие на книга";
			case 4: return "ISBN";
			case 5: return "Брой";
			case 6: return "Дата";
			case 7: return "Цена";
			case 8: return "Адрес";
			case 9: return "Състояние";
		}
		 /*try{
		 ResultSetMetaData metaData=result.getMetaData();
		 return metaData.getColumnName(columnIndex+1);
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 return null;
		 }*/
	 }// end getColumnName
} // end class MyModel 