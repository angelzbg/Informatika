package com.fmi.decorator;

public class RedShapeDecorator extends AShapeDecorator {
	
	public RedShapeDecorator(IShape shapeArg) {
		super(shapeArg);
	}

	@Override
	public void draw() {
		shape.draw();
		setRedBorder();
	}

	private void setRedBorder() {
		System.out.println("With red border.");
	}

}
