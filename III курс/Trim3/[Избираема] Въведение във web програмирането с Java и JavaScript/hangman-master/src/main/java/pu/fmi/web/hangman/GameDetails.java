package pu.fmi.web.hangman;

public class GameDetails {
	String id;
	
	int maxTries = 10;
	int tries = 0;
	
	int charCount;
	char firstChar;
	char lastChar;
	
	String current;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMaxTries() {
		return maxTries;
	}

	public void setMaxTries(int maxTries) {
		this.maxTries = maxTries;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public int getCharCount() {
		return charCount;
	}

	public void setCharCount(int charCount) {
		this.charCount = charCount;
	}

	public char getFirstChar() {
		return firstChar;
	}

	public void setFirstChar(char firstChar) {
		this.firstChar = firstChar;
	}

	public char getLastChar() {
		return lastChar;
	}

	public void setLastChar(char lastChar) {
		this.lastChar = lastChar;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}
}
