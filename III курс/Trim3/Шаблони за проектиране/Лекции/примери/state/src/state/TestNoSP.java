package state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ���� �������� �� ����� ContextNoSP, ����� �� �������� ������� ���������.
 */
public class TestNoSP extends Frame implements ActionListener {
	// GUI ��������.
	private Button pushButton = new Button("Push Operation");
	private Button pullButton = new Button("Pull Operation");
	private Button exitButton = new Button("Exit");
	private Canvas canvas = new Canvas();
	private Panel toolbox = new Panel();

	// ���������
	private ContextNoSP context = null;

	public TestNoSP() {
		super("��� ������� ���������");
		context = new ContextNoSP();
		setupWindow();
	}

	private void setupWindow() {
		setSize(500, 500);

		setLayout(new BorderLayout());
		add(canvas, BorderLayout.CENTER);
		canvas.setBackground(context.getState());

		toolbox.setLayout(new GridBagLayout());
		add(toolbox, BorderLayout.SOUTH);
		toolbox.add(pushButton);
		toolbox.add(pullButton);
		toolbox.add(exitButton);

		pushButton.addActionListener(this);
		pullButton.addActionListener(this);
		exitButton.addActionListener(this);
	}

	// ��������� �� ��������� �� ��������.
	public void actionPerformed(ActionEvent event) {
		Object src = event.getSource();
		if (src == pushButton) {
			context.push();
			canvas.setBackground(context.getState());
		} else if (src == pullButton) {
			context.pull();
			canvas.setBackground(context.getState());
		} else if (src == exitButton) {
			System.exit(0);
		}
	}

	public static void main(String[] argv) {
		TestNoSP gui = new TestNoSP();
		gui.setVisible(true);
	}
}
