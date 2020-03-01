package state;

import java.awt.Color;

public class GreenState extends State {
	// �������� ��������� �� Green �����������:
	// ��� push(), ��������� � "black"
	// ��� pull(), ��������� � "blue"

	@Override
	public void handlePush(Context c) {
		c.setState(new BlackState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public Color getColor() {
		return (Color.green);
	}
}
