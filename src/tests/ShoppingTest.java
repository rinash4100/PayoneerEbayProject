package tests;

import java.io.IOException;

import infra.Browser;
import infra.LoadProperties;
import infra.Reporter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.HomePage;
import pages.SearchResultPage;
import testData.Writer;


public class ShoppingTest {

	@BeforeClass
	public static void openDriver() {
		Browser.getDriver();
		Browser.goToSite(new LoadProperties().getUrl());
	}

	@Test
	public void test() throws IOException {
		new HomePage().doActions();
		
		SearchResultPage searchResultPage = new SearchResultPage();
		searchResultPage.doActions();
		
		saveUrlsToFile(searchResultPage);
		
		Reporter.printAccess();
	}

	private void saveUrlsToFile(SearchResultPage searchResultPage) {
		Writer w=new Writer();
		searchResultPage.getProductsLinks()
		.stream().forEach(f->w.write(f));
		w.close();
	}


	@AfterClass
	public static void closeDriver() {
		Browser.getDriver().close();
	}
}
