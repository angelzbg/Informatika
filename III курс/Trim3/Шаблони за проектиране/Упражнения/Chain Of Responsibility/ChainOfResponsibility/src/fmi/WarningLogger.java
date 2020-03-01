package fmi;

public class WarningLogger extends AbstractLogger {

	public WarningLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Warning Console: " + message);

	}

}
