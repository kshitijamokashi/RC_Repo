
//Created by swapnil



package com.rc.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
import com.rc.qa.util.TestUtil;
import com.rc.qa.util.WebEventListener;

public class TestBase 
{
	static Logger log = Logger.getLogger(TestBase.class);

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public Select select;
	public static JavascriptExecutor js;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	public Actions action;

	@FindBy(xpath = "//div[@class='ajs-message ajs-visible']")
	static WebElement alertify_popup;

	@FindBy(xpath = "//div[@id='dismiss_maint_alert']")
	static WebElement button_dismiss;

	public TestBase() {

		try {
			prop = new Properties();

			FileInputStream ip;
			// For office machine
			ip = new FileInputStream(
					"D:\\Kshitija\\RC_Maven_Project\\RC-MAVEN\\src\\main\\java\\com\\rc\\qa\\config\\config.properties");
			prop.load(ip);
			log.info("Configurations loaded");

			// For Personal Machine
			// ip = new
			// FileInputStream("C:\\Users\\swapnil\\eclipse-workspace\\UKTD_Maven\\src\\main\\java\\com\\uktd\\qa\\config\\config.properties");
			// prop.load(ip);
			//

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String broweserName = prop.getProperty("browser");

		String machineName = prop.getProperty("machine");

		if (broweserName.equalsIgnoreCase("chrome")) {

			if (machineName.equalsIgnoreCase("office")) {
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
				log.info("Browser Opened");
			}
			// else if(machineName.equalsIgnoreCase("personal"))
			// {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\swapnil\\eclipse-workspace\\WebDriver\\test\\scripts\\resources\\chromedriver.exe");
			// }
			else {
				System.out.println("Please add new machine chromedriver path");
			}

			driver = new ChromeDriver();
			log.info("Chrome Browser Started");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		}

		else if (broweserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\swapnil\\eclipse-workspace\\WebDriver\\test\\scripts\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox Browser Started");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		else {
			System.out.println("Browser did not identified");
		}

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		if (prop.getProperty("LoginType").equalsIgnoreCase("User"))
			driver.get(prop.getProperty("cleanerUrl"));
		else
			driver.get(prop.getProperty("adminUrl"));
	}

	public static void logoutCurrentSessionandOpenNewWindow(String URL) {
		// Quit current session
		driver.quit();

		// Open new browser session for applicant login
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
	}

	/***
	 * This function waits till element visibility
	 * 
	 * @param WebElement
	 */
	public static void waitTillElemenyVisibility(WebElement elementTofind) {

		try {
			long timeout = Long.parseLong(prop.getProperty("timeout"));
			wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(elementTofind));
			js = (JavascriptExecutor) driver;

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
	}

	/***
	 * This function is for click on the element
	 * 
	 * @param WebElement
	 */
	public static void clickOnElement(WebElement elementToClick) {

		try {

			waitTillElemenyVisibility(elementToClick);
			elementToClick.click();
			} catch (Exception e) {
			System.out.println("Exception Occurred: " + e.getMessage());
		}
	}

	/***
	 * This function verify element is displayed
	 * 
	 * @param WebElement
	 */
	public static boolean verifyElementIsDisplayed(WebElement elementToVerify) {

		try {
			waitTillElemenyVisibility(elementToVerify);
			if (elementToVerify.isDisplayed())
				return true;
			else
				return false;

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
			return false;

		}
	}

	/***
	 * This function verify element is visible
	 * 
	 * @param WebElement
	 */
	public static boolean verifyElementIsEnabled(WebElement elementToVerify) {

		try {
			waitTillElemenyVisibility(elementToVerify);
			if (elementToVerify.isEnabled())
				return true;
			else
				return false;

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
		return false;
	}

	/***
	 * This function will enter input in text field
	 * 
	 * @param WebElement,
	 *            textToEnter
	 */
	public static void enterText(WebElement elementToClick, String inputToEnter) {

		try {
			waitTillElemenyVisibility(elementToClick);
			elementToClick.clear();
			elementToClick.sendKeys(inputToEnter);

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
	}

	/***
	 * This function is for selection value from drop down
	 * @param WebElement, optionToSelect
	 */
	public static void selectFromDropDown(WebElement dropdownElement, String optionToSelect) {

		try {

			waitTillElemenyVisibility(dropdownElement);
			Select drp = new Select(dropdownElement);
			drp.selectByVisibleText(optionToSelect);
			
			} catch (Exception e) {
			System.out.println("Exception Occurred: " + e.getMessage());
		}
	}
	/***
	 * This function will find text given on the navigation bar abd click on it
	 * 
	 * @param navigation
	 *            bar text
	 */
	public static void clickOnNavigatorBarLinks(String inputToEnter) {

		try {
			String xpath = "//a[contains(text(), '" + inputToEnter + "')]";
			// System.out.println(xpath);
			WebElement elementToClick = driver.findElement(By.xpath(xpath));
			waitTillElemenyVisibility(elementToClick);
			elementToClick.click();

		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
	}

	
	/***
	 * This function verify given string in the table rows and return true of
	 * false
	 * 
	 * @param textToVerify
	 * @return boolean
	 */
	public static Boolean verifyTableData(String textToVerify) {

		boolean isFound = false;
		int columnHead = 0;

		// Get the column where the quantity is listed
		for (WebElement header : getTable()) {
			columnHead++;
			// System.out.println(header.getText());
			if (header.getText().contains(textToVerify)) {
				isFound = true;
			}
		}
		return isFound;
	}

	/***
	 * This function is to get table from the page
	 * 
	 * @return List
	 *         <table>
	 */
	public static List<WebElement> getTable() {
		WebElement table = driver.findElement(By.xpath("//table[@id='data-table']"));
		List<WebElement> allHeaders = table.findElements(By.tagName("tr"));
		// System.out.println("This is the total numbers of rows" +
		// allHeaders.size());

		return allHeaders;
	}

	/***
	 * This function verify given string in the table rows and return true of
	 * false
	 * 
	 * @param textToMatch
	 * @return Integer
	 */
	public static Integer getTableRow(String textTomatch) {
		int columnHead = 0;

		// Get the column where the quantity is listed
		for (WebElement header : getTable()) {
			columnHead++;
			// System.out.println(header.getText());
			if (header.getText().contains(textTomatch)) {
				// System.out.println(columnHead);
				break;
			}
		}
		// doing minus 1 as table contains one row of header
		return columnHead - 1;
	}

	public static void clickOnTableActionButton(String textTomatchFromRow, String optionToselect) {
		try {
			getTable();
			int i = getTableRow(textTomatchFromRow);
			Actions drpdwn = new Actions(driver);
			driver.findElement(By.xpath("//*[@id='data-table']/tbody/tr[" + i + "]/td[4]/div/button")).click();
			WebElement option = driver.findElement(By.linkText(optionToselect));
			waitTillElemenyVisibility(option);
			Action selectobject = drpdwn.moveToElement(option).click().build();
			selectobject.perform();
		} catch (Exception e) {
			System.out.println("Exception Found..." + e.getMessage());
		}
	}

	public static void clickOnTableActionButtonWithAlert(String textTomatchFromRow, String optionToselect) {
		try {

			getTable();
			int i = getTableRow(textTomatchFromRow);
			Actions drpdwn = new Actions(driver);
			driver.findElement(By.xpath("//*[@id='data-table']/tbody/tr[" + i + "]/td[4]/div/button")).click();
			WebElement option = driver.findElement(By.linkText(optionToselect));
			waitTillElemenyVisibility(option);
			Action selectobject = drpdwn.moveToElement(option).click().build();
			selectobject.perform();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//button[@class='ajs-button ajs-ok']")).isDisplayed()) {
				clickOnElement(driver.findElement(By.xpath("//button[@class='ajs-button ajs-ok']")));
			}
		}

		catch (Exception e) {
			System.out.println("Exception Found..." + e.getMessage());
		}
	}
	
	/***
	 * This function is for click on the element
	 * 
	 * @param WebElement
	 */
	public static boolean verifyNavigationToURL(String URLToVerify ) {

		try {
				String url = driver.getCurrentUrl();
				System.out.println(url);
				if(prop.getProperty("Environment").equalsIgnoreCase("live")){
					String liveurl = url.replaceAll("demo", "dahshboard");
					if(liveurl.equals(URLToVerify)){
						return true;
					}
						else return false;
					
				
				}else if(url.equals(URLToVerify)){
					return true;
				}
				else
					return false;
			
			} catch (Exception e) {
			System.out.println("Exception Occurred: " + e.getMessage());
		}
		return false;
	}

	public static String getTodayesDateFormatted(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();

		
		return formatter.format(date);
		
	}
	
	
	public static void dismissAlertify() {
		if (verifyElementIsDisplayed(driver.findElement(By.xpath("//div[@class='ajs-message ajs-visible']")))) {
			clickOnElement(driver.findElement(By.xpath("//div[@id='dismiss_maint_alert']")));
			clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'OK')][@class='ajs-button ajs-ok']")));
		}
	}

}
