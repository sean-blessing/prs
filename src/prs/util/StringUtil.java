package prs.util;

import java.text.NumberFormat;

public class StringUtil { 
	public static String getCurrencyFormat(double d) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(d);
	}
}
