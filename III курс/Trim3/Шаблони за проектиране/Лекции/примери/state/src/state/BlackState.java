package state;

import java.awt.Color;

public class BlackState extends State {
	// �������� ��������� �� Black �����������:
	// ��� push(), ��������� � "red"
	// ��� pull(), ��������� � "green"

	@Override
	public void handlePush(Context c) {
		c.setState(new RedState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new GreenState());
	}

	@Override
	public Color getColor() {
		return (Color.black);
	}
}
