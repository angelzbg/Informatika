package com.fmi.decorator;

public class DecoratorDemo {

	public static void main(final String[] args) {
		final IShape shape = new Circle();
		shape.draw();
		final AShapeDecorator decorator = new RedShapeDecorator(shape);
		decorator.draw();
	}
}
