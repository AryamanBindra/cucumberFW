package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	public homePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	public WebElement accept_Cookies;
	
	@FindBy(xpath ="//div[@class='search-input-wrapper']//input[@id='search-input-location']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//button[@id='search-submit']")
	public WebElement searchSubmit;
	
	@FindBy(xpath = "//select[@id='sort-order-dropdown']")
	public WebElement dropDown;
	
	@FindBy(xpath = "//body/div[@id='__next']/div[4]/div[1]/main[1]/div[2]/div[2]/div[5]/div[1]")
	public WebElement fifthProp;
	
	@FindBy(xpath = "//body/main[@id='main-content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement agentInfo;
	
	
	@FindBy(xpath = "//h1[contains(text(),'Property for sale in London')]")
	public WebElement title;
	
	@FindBy(xpath = "//button[@id='search-submit']")
	public WebElement submittButton;


	

}
