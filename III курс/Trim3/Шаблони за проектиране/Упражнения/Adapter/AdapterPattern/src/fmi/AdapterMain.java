package fmi;

import java.util.ArrayList;

public class AdapterMain {

	public static void main(String[] args) {
			
		ArrayList<String> list = new ArrayList<String>();
		list.add("Edno");
		list.add("Dve");
		list.add("Tri");
		
		PrintableList pl = new PrintableListAdapter();
		pl.printList(list);
		
	}

}
