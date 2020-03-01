import java.io.*;

public class Keyboard {
	// Primitive Keyboard input of integers, reals,
	// strings, and characters.
	static boolean iseof = false;
	static char c;
	static int i;
	static double d;
	static String s;
	/*
	 * WARNING: THE BUFFER VALUE IS SET TO 1 HERE TO OVERCOME* A KNOWN BUG IN
	 * WIN95 (WITH JDK 1.1.3 ONWARDS)
	 */
	static BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in), 1);

	public static int readInt() {
		if (iseof)
			return 0;
		System.out.flush();
		try {
			s = input.readLine();
		} catch (IOException e) {
			System.exit(-1);
		}
		if (s == null) {
			iseof = true;
			return 0;
		}
		i = new Integer(s.trim()).intValue();
		return i;
	}

	public static char readChar() {
		if (iseof)
			return (char) 0;
		System.out.flush();
		try {
			i = input.read();
		} catch (IOException e) {
			System.exit(-1);
		}
		if (i == -1) {
			iseof = true;
			return (char) 0;
		}
		return (char) i;
	}

	public static double readDouble() {
		if (iseof)
			return 0.0;
		System.out.flush();
		try {
			s = input.readLine();
		} catch (IOException e) {
			System.exit(-1);
		}
		if (s == null) {
			iseof = true;
			return 0.0;
		}
		d = new Double(s.trim()).doubleValue();
		return d;
	}

	public static String readString() {
		if (iseof)
			return null;
		System.out.flush();
		try {
			s = input.readLine();
		} catch (IOException e) {
			System.exit(-1);
		}
		if (s == null) {
			iseof = true;
			return null;
		}
		return s;
	}

	public static boolean eof() {
		return iseof;
	}
}
