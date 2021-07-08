package pages;

/**
 * All pages inherit from this class The goal is to create a uniform framework
 * for all pages
 */

public abstract class BasePage {

	public abstract void doActions();
	
	/**
	 * Appropriate to add here additional functions like:
	 * -public abstract void validationPage();
	 * for validate the page 
	 * -public abstract void root();
	 * Make sure they are on the correct page by checking the main element on the page
	 */
}
