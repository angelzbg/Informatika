package fmi;

public abstract class AbstractLogger {
	
	public static int INFO = 1;
	public static int WARNING = 2;
	public static int ERROR = 3;
	
	protected int level;
	// Reference to the next element in the chain
	protected AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		if(this.level <= level) {
			write(message);
		}
		if(nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
		
	}
	
	abstract protected void write(String message);
	
}
