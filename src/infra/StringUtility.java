package infra;

/**
 * This class is designed for functions that handle strings and are repeated
 * several times
 */

public class StringUtility {

	public static double getOnlyNumbersFromString(String string) {
		if(string.contains("to")){	
			string=string.substring(0,string.indexOf("t"));
		}
		string = string.replaceAll("[^0-9?!\\.]", "");
		return Double.parseDouble(string);
	}
	
	public static String splitSpaces(String value){
		return value.split("\\s+").toString();
	}
	
	
	
//	public static String getStringInPropertyFormat(String propValue){
//		return propValue.split("\\s+").toString().toLowerCase();
//	}
}
