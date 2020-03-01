package fmi;

public class NamesRepository implements Container{
	public String names[] = {
			"Ivan",
			"Peter",
			"Dragan"
	};
	
	public Iterator getIterator(){
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator {
		int index;
		Object current;
		
		public boolean hasNext(){
			if(index < names.length){
				return true;
			}
			return false;
		}
		public Object next(){
			if(this.hasNext()){
				current = names[index];
				index++;
				return current;
			}
			return null;
		}
	}
}
