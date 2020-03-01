package fmi;

public class Book implements ItemElement{
	private int price;
	private String isbnNumber;
	
	public Book(int price, String isbnNumber){
		this.price = price;
		this.isbnNumber = isbnNumber;
	}
	
	public int getPrice() {
		return price;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public int accept(ShoppingCartVisitor visitor){
		return visitor.visit(this);
	}
	
}
