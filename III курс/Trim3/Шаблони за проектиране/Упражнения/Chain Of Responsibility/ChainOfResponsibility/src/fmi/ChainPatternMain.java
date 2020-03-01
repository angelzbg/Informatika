package fmi;

public class ChainPatternMain {

	private static AbstractLogger getChainOfLoggers() {
		
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger warningLogger = new WarningLogger(AbstractLogger.WARNING);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(warningLogger);
		warningLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}

	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();
		loggerChain.logMessage(AbstractLogger.INFO, "This is an information");
		loggerChain.logMessage(AbstractLogger.WARNING, "This is an warning message");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error message");
	}
	
	
}
