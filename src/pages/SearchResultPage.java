package pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import infra.Browser;
import infra.Reporter;
import infra.StringUtility;
import infra.WebElementData;
import infra.WebElementDataList;

public class SearchResultPage extends BasePage {

	private WebElementDataList productListPrices = new WebElementDataList(By.className("s-item__price"));

	private List<Double> doubleLowPrices = new ArrayList<Double>();
	private List<String> stringProductList;
	private ArrayList<String> productsLinksList=new ArrayList<String>();

	@Override
	public void doActions() {
		Reporter.startPageInfo("SearchResultPage");
		stringProductList = productListPrices.getStringList();
		set3LowPrices();
		setProductsLinks();
	}
	
	private void set3LowPrices() {
		for (int i = 0; i < 3; i++) {
			getMinFromList();
		}
		Reporter.printInfo("the 3 cheapest prices is:" + doubleLowPrices);
	}

	private void getMinFromList() {
		//convert stringProductList to double and find the min
		double minPrice = stringProductList.stream().mapToDouble(m -> StringUtility.getOnlyNumbersFromString(m)).min().getAsDouble();
		doubleLowPrices.add(minPrice);
		//remove the min from list, in order To find the next min
		stringProductList = stringProductList.stream().filter(f -> !f.contains(String.valueOf(minPrice))).collect(Collectors.toList());
	}
	
	/**
	 *According to the minimum prices found, finding their father element, and finding the link below it.
	 */
	private void setProductsLinks() {
		for (Double price : doubleLowPrices) {
			//find the parent with XPath axes: /ancestor::div[3]
			WebElement lowPriceParent = Browser.getDriver().findElement
					(By.xpath("//span[@class='s-item__price'][contains(text(),'" + price + "')]/ancestor::div[3]"));
			//find the link below it
			WebElement productsLink = lowPriceParent.findElement(By.cssSelector("a[class='s-item__link']"));
			//get url
			productsLinksList.add(productsLink. getAttribute("href"));
		}
	}

	public List<String> getProductsLinks() {
		return this.productsLinksList;
	}
	
	

}