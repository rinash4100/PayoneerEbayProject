/**
 * 
 */
package infra;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Creating a shell for elements
 */
public class WebElementData{

	protected By selector;
	private WebElement element;

	public WebElementData(By by) {
		this.selector = by;	
	}
	
	public void searchElement(){
		List<WebElement> elements = Browser.getDriver().findElements(this.selector);
		if (elements.size() == 0) {
			try {
				throw new RuntimeException("אלמנט לא קיים");
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		else{
			element = elements.get(0);
		}
	}
	
	public void input(String text){
		searchElement();
		element.clear();
	    element.sendKeys(text);
	}

	public void click() {
		searchElement();
		element.click();
	}
	
	public String getText(){
		searchElement();
		return element.getText();
	}
	
}
