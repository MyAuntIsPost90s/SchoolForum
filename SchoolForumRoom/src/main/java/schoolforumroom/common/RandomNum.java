package schoolforumroom.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomNum {
	private static int index = 10;

	public static String getMID() {
		return "M" + getRandom();
	}

	public static String getNID() {
		return "N" + getRandom();
	}

	public static String getEBID() {
		return "EB" + getRandom();
	}

	public static String getEID() {
		return "E" + getRandom();
	}

	public static String getAID() {
		return "A" + getRandom();
	}

	public static String getBID() {
		return "B" + getRandom();
	}

	public static String getLGID() {
		return "LG" + getRandom();
	}

	public static String getCID() {
		return "C" + getRandom();
	}

	private static String getRandom() {
		if (index == 100)
			index = 10;

		int num = (int) (Math.random() * 900) + 100;
		return num + "" + new SimpleDateFormat("HHmmssSSS").format(new Date()) + (index++);
	}
}
