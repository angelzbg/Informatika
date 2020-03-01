package com.fmi.decorator;

public abstract class AShapeDecorator implements IShape {

	public final IShape shape;

	public AShapeDecorator(final IShape shapeArg) {
		this.shape = shapeArg;
	}
}
