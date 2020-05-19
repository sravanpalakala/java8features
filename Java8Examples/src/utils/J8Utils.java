package utils;

import java.util.Random;

public class J8Utils {

	public static int getRandomNumber(int min, int max) {
		return (new Random().nextInt(max-min)+1)+10;
	}
}
