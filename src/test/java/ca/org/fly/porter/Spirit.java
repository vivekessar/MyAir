package ca.org.fly.porter;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Spirit {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WeKay\\eclipse-workspace\\MyAir\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// get the web site
		driver.get("https://www.spirit.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement rdoOneway = driver.findElement(By.xpath("//span[contains(text(),'One Way')]"));
		rdoOneway.click();

		WebElement txtFrom = driver.findElement(By.xpath("//input[@id='flight-OriginStationCode']"));
		txtFrom.click();

		WebElement SelDenver = driver.findElement(By.xpath(
				"//div[@class='row ng-tns-c18-4 d-flex ng-star-inserted']//button[@class='btn btn-link pt-0 pb-0 font-size-dropdown h-unset text-left text-capitalize'][contains(text(),'Denver, CO (DEN)')]"));
		SelDenver.click();

		WebElement txtTo = driver.findElement(By.xpath("//input[@id='flight-DestinationStationCode']"));
		txtTo.click();

		WebElement SelChic = driver.findElement(By.xpath(
				"//div[@class='row ng-tns-c18-4 d-flex ng-star-inserted']//div[@class='d-flex align-items-center pt-1 pb-1 bg-color-even ng-star-inserted']//button[@class='btn btn-link pt-0 pb-0 font-size-dropdown h-unset text-left text-capitalize'][contains(text(),\"Chicago, IL - O'Hare (ORD)\")]"));
		SelChic.click();

		WebElement cal = driver.findElement(By.xpath("//input[@id='flight-Date']"));
		cal.click();

		WebElement cal31 = driver.findElement(By.xpath("//tr[5]//td[7]"));
		cal31.click();

		WebElement passangers = driver.findElement(By.xpath("//input[@id='passengers']"));
		passangers.click();

		for (int i = 0; i < 1; i++) {
			WebElement AdultAdd = driver
					.findElement(By.xpath("//div[@class='d-flex pt-1']//i[@class='icon-add-circle']"));
			AdultAdd.click();
		}

		WebElement btnSearch = driver.findElement(By.xpath("//button[@class='btn btn-primary d-block']"));
		btnSearch.click();
		Thread.sleep(3000L);
		WebElement scrollDown = driver.findElement(By.xpath("(//div[text()=' $9 Fare Club '])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollDown);

		Thread.sleep(3000L);

		WebElement SelFlight = driver.findElement(By.xpath(
				"//label[@class='ng-star-inserted custom-control-label bold-label p-lead font-weight-bold']//span[contains(text(),'$32.49')]"));

		js.executeScript("arguments[0].click()", SelFlight);

		Thread.sleep(3000L);
		WebElement btnContinue = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		btnContinue.click();

		Thread.sleep(3000L);
		WebElement btnBook = driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-block']"));
		btnBook.click();

		// WebElement scrollDownTwo =
		// driver.findElement(By.xpath("//h3[contains(text(),'Passenger 2')]"));
		// JavascriptExecutor js2 = (JavascriptExecutor) driver;
		// js2.executeScript("arguments[0].scrollIntoView(true)", scrollDownTwo);

		// Filling details of passangers

		Thread.sleep(3000L);
		WebElement ddSelTitle0 = driver.findElement(By.xpath("//select[@id='title0']"));
		ddSelTitle0.click();
		Thread.sleep(2000L);
		ddSelTitle0.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000L);
		ddSelTitle0.sendKeys(Keys.ENTER);

		WebElement txtFirstName0 = driver.findElement(By.xpath("//input[@id='firstName0']"));
		txtFirstName0.sendKeys(getData(1, 1));

		WebElement txtLastName0 = driver.findElement(By.xpath("//input[@id='lastName0']"));
		txtLastName0.sendKeys(getData(1, 3));

		WebElement calDOB0 = driver.findElement(By.xpath("//input[@id='dateOfBirth0']"));
		calDOB0.click();

		WebElement yr1986 = driver.findElement(By.xpath("//span[contains(text(),'1986')]"));
		yr1986.click();

		WebElement janMo = driver.findElement(By.xpath("//span[contains(text(),'January')]"));
		janMo.click();

		WebElement date25 = driver.findElement(By.xpath("//tr[4]//td[8]"));
		date25.click();

		//

		// Passenger 2

		WebElement ddSelTitle = driver.findElement(By.xpath("//select[@id='title1']"));
		ddSelTitle.click();
		ddSelTitle.click();
		ddSelTitle.sendKeys(Keys.ARROW_DOWN);
		ddSelTitle.sendKeys(Keys.ENTER);

		WebElement txtFirstName1 = driver.findElement(By.xpath("//input[@id='firstName1']"));
		txtFirstName1.sendKeys(getData(2, 1));

		WebElement txtLastName1 = driver.findElement(By.xpath("//input[@id='lastName1']"));
		txtLastName1.sendKeys(getData(2, 3));

		WebElement calDOB1 = driver.findElement(By.xpath("//input[@id='dateOfBirth1']"));
		calDOB1.click();
		WebElement calYear1 = driver.findElement(By.xpath("//span[contains(text(),'1982')]"));
		calYear1.click();

		WebElement calMonFeb = driver.findElement(By.xpath("//span[contains(text(),'February')]"));
		calMonFeb.click();

		WebElement date7 = driver.findElement(By.xpath("//tr[1]//td[7]"));
		date7.click();

		WebElement samePerson = driver
				.findElement(By.xpath("//span[contains(text(),'The primary passenger is the contact person')]"));
		samePerson.click();

		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("test address");

		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("test city");

		driver.findElement(By.xpath("//select[@id='provinceState']")).sendKeys("a");
		driver.findElement(By.xpath("//select[@id='provinceState']")).sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//input[@id='postalCode']")).sendKeys("999888");

		driver.findElement(By.xpath("//input[@id='contactEmailPrimary']")).sendKeys("test@mil.test");

		driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("000999887");
		driver.findElement(By.xpath("//button[contains(text(),'continue')]")).click();

	}

	private static String getData(int rowNo, int cellno) throws Throwable {
		String v = null;
		File loc = new File("C:\\Users\\WeKay\\eclipse-workspace\\MyAir\\Excel\\DataFlight.xlsx");
		FileInputStream st = new FileInputStream(loc);

		Workbook w = new XSSFWorkbook(st);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellno);
		v = c.getStringCellValue();
		return v;
	}
}
