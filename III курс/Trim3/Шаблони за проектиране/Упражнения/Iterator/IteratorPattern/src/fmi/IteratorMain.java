package fmi;

public class IteratorMain {

	public static void main(String[] args) {
		
		NamesRepository nr = new NamesRepository();
		for(Iterator iter = nr.getIterator(); iter.hasNext();){
			String name = (String)iter.next();
			System.out.println(name);
		}

	}

}
