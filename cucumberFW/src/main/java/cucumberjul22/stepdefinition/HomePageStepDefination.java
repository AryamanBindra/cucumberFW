package cucumberjul22.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.homePage;

public class HomePageStepDefination {
	static WebDriver driver = null;
	
	


	@Given("user is on home page")
	public void user_is_on_home_page() throws Exception {
		
		System.out.println("user can see the homepage");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.zoopla.co.uk");
		homePage hp = new homePage(driver);
		System.out.println("opened");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		hp.accept_Cookies.click();
		Thread.sleep(3000);
		

	}

	@When("click on the searchbox")
	public void click_on_the_searchbox() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.searchBox.click();

		Thread.sleep(8000);

	}

	@When("send keys")
	public void send_keys() {
		System.out.println("location has been entered manually");
	}

	@Then("navigate to next page1")
	public void navigate_to_next_page1() {
		homePage hp = new homePage(driver);
		hp.searchSubmit.click();
	}

	@Given("click on dropDown")
	public void click_on_drop_down() throws InterruptedException {
		homePage hp = new homePage(driver);
		hp.dropDown.click();
		Thread.sleep(4000);

	}

	@When("select the highest Price")
	public void select_the_highest_price() throws InterruptedException {
		homePage hp = new homePage(driver);
		Select s = new Select(hp.dropDown);
		s.selectByValue("highest_price");
		Thread.sleep(5000);

	}

	@Then("displays all the props decending from highest price")
	public void displays_all_the_props_decending_from_highest_price() throws InterruptedException {
		
		List<WebElement> listings = driver.findElements(By.xpath("//p[@class='css-18tfumg-Text eczcs4p0']"));

		List<WebElement> HigherPrice = listings;

		System.out.println(HigherPrice.size());

		for (int i = 0; i < HigherPrice.size(); i++) {

			System.out.println("Price Of Property is :" + HigherPrice.get(i).getText());
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}

	}

	@Given("property info is open")
	public void property_info_is_open() {

		System.out.println("Property listing is open");

	}

	@When("select the fifth prop and click")
	public void select_the_fifth_prop_and_click() throws InterruptedException {
		homePage hp = new homePage(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hp.fifthProp);
		hp.fifthProp.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@When("opened the next page")
	public void opened_the_next_page() {
		System.out.println("User can see the listing page");
	}

	@Then("validate the agent")
	public void validate_the_agent() {
		homePage hp = new homePage(driver);
		String AgentNameOn_clickedPage = "Panther International Properties";
		String AgentInfo_validation = hp.agentInfo.getText();
		System.out.println("Actual Agent name on the page is: " + AgentInfo_validation);
		Assert.assertTrue(AgentInfo_validation.contains(AgentNameOn_clickedPage));
		driver.quit();
	}
}