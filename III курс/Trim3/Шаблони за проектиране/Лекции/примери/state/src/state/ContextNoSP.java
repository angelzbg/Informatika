package state;

import java.awt.Color;

/**
 * ����� ContextNoSP ��� ���������, ����� ������ �� ����������� ��. 
 * �������� push() � pull() ��������� �������� ���� � ���������� �� ����������� �� ������.
 * ���� ���� �� �������� ������� ���������.
 */
public class ContextNoSP {
	// �����������!
	private Color state = null;

	// ������� ��� ContextNoSP ��� ���������� ��������� (color).
	public ContextNoSP(Color color) {
		state = color;
	}

	// ������� ��� ContextNoSP ��� �������� �� ������������
	public ContextNoSP() {
		this(Color.red);
	}

	// ����� �����������.
	public Color getState() {
		return state;
	}

	// ������ ���������.
	public void setState(Color state) {
		this.state = state;
	}

	/**
	 * ������� push() �������� �������� �������� � ���������� �� ����������� �� ������.
	 * ������ ������������ ����, ����� ����� � ����� �� �����������.
	 */
	public void push() {
		if (state == Color.red)
			state = Color.blue;
		else if (state == Color.green)
			state = Color.black;
		else if (state == Color.black)
			state = Color.red;
		else if (state == Color.blue)
			state = Color.green;
	}

	/**
	 * ������� pull() �������� �������� �������� � ���������� �� ����������� �� ������.
	 * ������ ������������ ����, ����� ����� � ����� �� �����������.
	 */
	public void pull() {
		if (state == Color.red)
			state = Color.green;
		else if (state == Color.green)
			state = Color.blue;
		else if (state == Color.black)
			state = Color.green;
		else if (state == Color.blue)
			state = Color.red;
	}
}
