package infra;

/**
 * class as a kind of report, prints to the console
 * In the real world, I would produce a report designed with graphs, screenshots, etc.
 */
public class Reporter {
	
	public static void startPageInfo(String pageName){
		System.out.println("*************************");
		System.out.println("entry new page:"+pageName);
	}
	
	public static void elementInformation(String action,String element){
		System.out.println(action+" on "+action);
	}
	
	public static void printError(){
		System.out.println("XXXXXXXXXXXXXXXX");
		System.out.println("THIS IS ERROR");
	}
	
	public static void printAccess(){
		System.out.println("VVVVVVVVVVVVVVVVVVVVVV");
		System.out.println("THIS TEST IS SUCCESSFUL");
	}
	
	public static void printInfo(String text){
		System.out.println("INFO:"+text);
	}
	
}
