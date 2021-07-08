/**
 * 
 */
package infra;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Creating a shell for elements
 */
public class WebElementDataList extends WebElementData {

	private List<WebElement> elements;

	public WebElementDataList(By by) {
		super(by);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void searchElement() {
		elements = Browser.getDriver().findElements(this.selector);
		if (elements.size() == 0) {
			try {
				throw new RuntimeException("אלמנט לא קיים");
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> getStringList(){
		searchElement();
		 return elements.stream().map(m->m.getText()).collect(Collectors.toList());
	}
	
	public List<WebElement> getList() {
		searchElement();
		return elements.stream().collect(Collectors.toList());
	}
	
	
}
