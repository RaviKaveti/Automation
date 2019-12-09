package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

public class LoanEligibility {

	WebDriver driver;

	@Given("^User lands on the ANZ Loan Calculator page (.*)$")
	public void User_is_landing_on_the_ANZ_Loan_Calculator_page(String Applurl) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Applurl);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When ("User clicks on (.*) selects (.*) and clicks on (.*) under Your details section$")
	public void User_clicksonAppltype_selectsNoofDepdants_clicksonProptopay(String Applicationtype, String NumberofDependants, String Propertyyouwouldliketobuy)
	{
		driver.findElement(By.xpath("//label[contains(text(),'Single')]")).sendKeys(Applicationtype);
		driver.findElement(By.xpath("//select[@title='Number of dependants']")).sendKeys(NumberofDependants);
		driver.findElement(By.xpath("//label[contains(text(),'Home to live in')]")).sendKeys(Propertyyouwouldliketobuy);
	}

	@And ("^Also enters (.*) per year and (.*) per year under Your earnings section$")
	public void Also_entersYourincomepy_and_Yourotherincomepy_underYourearnssec(String Yourincome, String Yourotherincome)
	{
		driver.findElement(By.xpath("//label[contains(text(),'Your income')]/../div/input")).sendKeys(Yourincome);
		driver.findElement(By.xpath("//label[contains(text(),'Your other income')]/../div/input")).sendKeys(Yourotherincome );
	}

	@And("^Lastly enters (.*)per month (.*)per month (.*)per month (.*)per month and (.*) under Your expenses")
	public void Lastlyenters_Expensedetails_underYourexpenses(String Livingexpenses, String Currenthomeloanrepayments, String Otherloanrepayments, String Othercommitments, String Totalcreditcardlimits)
	{
		driver.findElement(By.xpath("//label[contains(text(),'Living expenses')]/../div/input")).sendKeys(Livingexpenses);
		driver.findElement(By.xpath("//label[contains(text(),'Current home loan')]/../div/input")).sendKeys(Currenthomeloanrepayments);
		driver.findElement(By.xpath("//label[contains(text(),'Other loan')]/../div/input")).sendKeys(Otherloanrepayments);
		driver.findElement(By.xpath("//label[contains(text(),'Other commitments')]/../div/input")).sendKeys(Othercommitments);
		driver.findElement(By.xpath("//label[contains(text(),'Total credit card limits')]/../div/input")).sendKeys(Totalcreditcardlimits);
	}

	@And("^User clicks on Work out how much I could borrow$")
	public void Userclickson_WorkouthowmuchIcouldborrow() throws InterruptedException
	{
		WebElement workoutbtn = driver.findElement(By.xpath("//button[contains(text(),'Work out how much I could borrow')]"));

		try
		{
			int cnt=0;
			while(cnt<50)
			{
				if(workoutbtn.isDisplayed())
				{
					workoutbtn.click();
					Thread.sleep(3000);
					break;
				}
				cnt++;				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	@Then("^User would be shown the estimated amount$")
	public void User_wouldbe_shownthe_estimatedamount() throws InterruptedException
	{
		WebElement resultantvalue = driver.findElement(By.xpath("//span[@class='borrow__result__text__amount']"));
		if(resultantvalue.isDisplayed())
		{
			String resamount = resultantvalue.getText();
			System.out.println("Resultant amount :" +resamount);

		}
	}

	@Then("^User would be shown the message$")
	public void User_wouldbe_shownthe_message()
	{
		String resultantmsg = driver.findElement(By.xpath("//span[@class='borrow__result__text__amount']")).getText();
		if(!resultantmsg.isEmpty())
		{
			System.out.println("Resultant message :" +resultantmsg);
		}
	}

	@And("^User clicks on Start Over button$")
	public void Userclicks_onStartOverbutton() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement startOver = driver.findElement(By.xpath("//button[@class='start-over']"));
		if(startOver.isDisplayed())
		{
			startOver.click();
			System.out.println("Page will be refreshed to create a new record");
		}
		else
		{
			driver.quit();
		}
	}

	@And("^User close the browser$")
	public void Userclose_thebrowser()
	{
		driver.quit();
	}



}

