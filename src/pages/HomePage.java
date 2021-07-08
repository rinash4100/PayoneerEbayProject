package pages;

import infra.Reporter;
import infra.WebElementData;

import org.openqa.selenium.By;


public class HomePage extends BasePage {
	
	private WebElementData searchBox=new WebElementData(By.id("gh-ac"));
	private WebElementData searchButton=new WebElementData(By.id("gh-btn"));
	
	
	@Override
	public void doActions() {
		Reporter.startPageInfo("HomePage");
		searchBox.input("wireless headphones QC 35 version 2");
		searchButton.click();
	}
	
	
	
	
}