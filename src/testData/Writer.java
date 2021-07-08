package testData;

import infra.Reporter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
	BufferedWriter buffer;
	
	public Writer() {
		try {
			buffer = new BufferedWriter(new FileWriter("../PayoneerProject/resources/CheapestProducts.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String text) {
		try {
			buffer.append(text);
			buffer.append('\n');			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.printInfo("Written to file successfully! "+text);
	}
	
	public void close(){
		try {
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
