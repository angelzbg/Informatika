public class Time {
	private int hour, minute; // актуалното време

	public Time(int h, int m) {
		hour = h;
		minute = m;
	}

	public Time() {
		hour = 0;
		minute = 0;
	}

	public void addMinutes(int m) {
		// увеличаване на текущото време в минути
		int totalMinutes = (60 * hour + minute + m) % (24 * 60);
		if (totalMinutes < 0)
			totalMinutes = totalMinutes + 24 * 60;
		hour = totalMinutes / 60;
		minute = totalMinutes % 60;
	}

	public void subtractMinutes(int m) {
		addMinutes(-m);
	}

	public void printTime() {
		// извеждане на текущото време
		// английската конвенция: AM, PM, noon, midnight
		if ((hour == 0) && (minute == 0))
			System.out.print("midnight");
		else if ((hour == 12) && (minute == 0))
			System.out.print("noon");
		else {
			if (hour == 0)
				System.out.print(12);
			else if (hour > 12)
				System.out.print(hour - 12);
			else
				System.out.print(hour);
			if (minute < 10)
				System.out.print(":0" + minute);
			else
				System.out.print(":" + minute);
			if (hour < 12)
				System.out.print("AM");
			else
				System.out.print("PM");
		}
	}

	public void printTimeInMinutes() {
		// отпечатва текущото време в кореспондиращи минути
		printTime();
		System.out.println(" = " + timeInMinutes() + ". minitues in day ");
	}

	private int timeInMinutes() { // private: Hilfsfunktion
		// определя броя минути след 0:00 часа, които съответстват на текущото време
		int totalMinutes = (60 * hour + minute) % (24 * 60);
		if (totalMinutes < 0)
			totalMinutes = totalMinutes + 24 * 60;
		return totalMinutes;
	}

	public boolean before(Time t) {
		return ((hour < t.hour) || ((hour == t.hour) && (minute < t.minute)));
	}

	public boolean after(Time t2) {
		return t2.before(this);
	}

	public Time copy() {
		return new Time(hour, minute);
	}
}
