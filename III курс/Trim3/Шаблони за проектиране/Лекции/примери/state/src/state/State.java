package state;

import java.awt.Color;

/**
 * ���������� ����, ����� �������� ���������� �� ����������� �� 
 * ��������� ��������� �� Context.
 */
public abstract class State {
	public abstract void handlePush(Context c);

	public abstract void handlePull(Context c);

	public abstract Color getColor();
}
