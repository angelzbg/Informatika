package fmi;

public class BlueCarDecorator extends CarDecorator {

	public BlueCarDecorator(Car decoratedCar) {
		super(decoratedCar);
	}
	
	public void create(){
		decoratedCar.create();
		setBlueColor(decoratedCar);
	}
	
	private void setBlueColor(Car decoratedCar){
		System.out.println("Base color: blue");
	}

}
