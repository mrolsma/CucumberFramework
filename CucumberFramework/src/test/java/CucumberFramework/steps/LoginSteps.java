package CucumberFramework.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert; 

public class LoginSteps {
	
	WebDriver driver;
	
	@Before()
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\matth\\Desktop\\CucumberFramework\\CucumberFramework\\src\\test\\java\\CucumberFramework\\resources\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}
	
	@After()
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
		
		
	}
	
	@Given("^user navigates to demoaut website$")
	public void user_navigates_to_demoaut_website() throws Throwable {
		driver.get("http://www.newtours.demoaut.com/");
		System.out.println("user navigates to demoaut website");
	}


	@Given("^user enters \"([^\"]*)\" username$")
	public void user_enters_username(String userName) throws Throwable {
		driver.findElement(By.name("userName")).sendKeys(userName);
		System.out.println("user enters valid username");
	  
	}

	@Given("^user enters \"([^\"]*)\" password$")
	public void user_enters_valid_password(String password) throws Throwable {
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("user enters valid password");
	
	}
	
	@Given("^user enters invalid username$")
	public void user_enters_username() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Aart");
		System.out.println("user enters valid username");
	  
	}

	@Given("^user enters invalid password$")
	public void user_enters_invalid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("bullshit");
		System.out.println("user enters valid password");
	
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.name("userName")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		System.out.println("user clicks login button");
	
	}

	@Then("^user should be taking to the succesfull login page$")
	public void user_should_be_taking_to_the_succesfull_login_page() throws Throwable {
		WebElement findFlightsButton = driver.findElement(By.name("findFlights"));
		Thread.sleep(10000);
		Assert.assertEquals(true, findFlightsButton.isDisplayed());
		System.out.println("user should be taking to the succesfull login page");

	}
	@Then("^user should not be taking to the succesfull login page$")
	public void user_should__not_be_taking_to_the_succesfull_login_page() throws Throwable {
		WebElement loginButton = driver.findElement(By.name("login"));
		Thread.sleep(5000);
		Assert.assertEquals(true, loginButton.isDisplayed());
		System.out.println("user should be taking to the succesfull login page");

	}
	@Given("^user enters valid username and valid password$")
	public void user_enters_valid_username_and_valid_password(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		driver.findElement(By.name("userName")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	}
	@When("^the user finds a flight$")
	public void the_user_finds_a_flight() throws Throwable {
		Thread.sleep(5000);
		WebElement CheckboxTypeoneWay = driver.findElement(By.cssSelector("input[value='oneway']"));
        CheckboxTypeoneWay.click();
        driver.findElement(By.name("passCount")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        driver.findElement(By.name("fromPort")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        //select month
        
        driver.findElement(By.name("fromMonth")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        //
        driver.findElement(By.name("toPort")).sendKeys( Keys.DOWN, Keys.ENTER);
        
        //select day
        
        driver.findElement(By.name("fromDay")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        driver.findElement(By.name("toMonth")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        driver.findElement(By.name("toDay")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        WebElement CheckBoxBusinessclass1 = driver.findElement(By.cssSelector("input[value='Business']"));
        
        driver.findElement(By.name("airline")).sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        
        CheckBoxBusinessclass1.click();
        
        driver.findElement(By.name("findFlights")).click();

        

	}

	@When("^the user selects a flight$")
	public void the_user_selects_a_flight() throws Throwable {
		Thread.sleep(5000);
        driver.findElement(By.name("reserveFlights")).click();

	}

	@When("^the user secures a purchase$")
	public void the_user_secures_a_purchase() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.name("passFirst0")).sendKeys("Pino");
        driver.findElement(By.name("passLast0")).sendKeys("Sesam");
        driver.findElement(By.name("passFirst1")).sendKeys("Tommy");
        driver.findElement(By.name("passLast1")).sendKeys("Sesam");
        driver.findElement(By.name("passFirst2")).sendKeys("Inie Minie");
        driver.findElement(By.name("passFirst3")).sendKeys("Sesam");
        
        driver.findElement(By.name("creditnumber")).sendKeys("ikhebmoneyG");
        
        driver.findElement(By.name("buyFlights")).click();

	}

	@Then("^the user sees the flight confirmation page$")
	public void the_user_sees_the_flight_confirmation_page() throws Throwable {
		Thread.sleep(5000);
		driver.getPageSource().contains("New York to Frankfurt");
	}

}