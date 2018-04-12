package NRIGroup.NRIArtifact;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
public class GenericWrappers implements Wrappers {
	// Declare Driver Class
	RemoteWebDriver driver;
	int i = 1;
	WebDriverWait wait;
	//object creation of Webdriverwait can be declared here globally to reduc te repetition of code

	
	/**
	 * 
	 * 
	 */
	//@Override
	public void invokeApp(String browser, String Url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} 
			else if(browser.equalsIgnoreCase("Mobile")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		      	 Map<String, String> mobileEmulation = new HashMap<String, String>(); 
		      	 mobileEmulation.put("deviceName", "Google Nexus 5");  
		      	 Map<String, Object> chromeOptions = new HashMap<String, Object>(); 
		      	 chromeOptions.put("mobileEmulation", mobileEmulation); 
		      	 DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
		      	 capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		      	driver = new ChromeDriver(capabilities);
				
			}
			else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Url);
			wait = new WebDriverWait(driver, 10);
			//Initialising object in InvokeApp method can make you to change the number of second needed to wait only once in coding
			//takeSnap();
			System.out.println("The application is launched");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");

		}

	}

	// Webdriver exception
	// NosuchElement Exception

	//@Override
	public void enterById(String idValue, String data) {

		try {
			driver.findElementById(idValue).click();
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The value " +data + "is entered"); // what value
			// what locator
		} catch (NoSuchElementException e) {
			System.out.println("Element " + idValue + " not found");
			Assert.fail("Element " + idValue + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}

		finally {
			takeSnap();
		}

	}

	
	//@Override
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(nameValue).clear();
			driver.findElementById(nameValue).sendKeys(data);
			System.out.println("The value " +data + "is entered"); // what value
			// what locator
		} catch (NoSuchElementException e) {
			System.out.println("Element " + nameValue + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}
		
		finally {
			//takeSnap();
		}
		
	}

	// Webdriver exception
	// NosuchElement Exception

	//public void enterByName(String nameValue, String data) {

	//@Override
	public void enterByXpath(String xpathValue, String data) {
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue)));
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Value " +data+" is entered");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathValue + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}

		// TODO Auto-generated method stub

	}

	////@Override
	public void verifyTitle(String title) {
		try {
			String actualtitle = driver.getTitle();
			//string name should be declared with standard
			if (actualtitle.contains(title)) {
				System.out.println("title :" + title + " verified");
			}

			else {
				System.out.println("Title " + title +" not verified");
			}
		}

		catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}
		// TODO Auto-generated method stub

	}

	//@Override
	public void verifyTextById(String id, String text) {
		try {
			String actualtext = driver.findElementById(id).getText();
			//string name should be declared with standard
			if (actualtext.equalsIgnoreCase(text)) {
				System.out.println("Text" +text+ "is verified");
			} else {
				System.out.println("Text " +text+ "not verified");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public void verifyTextByXpath(String xpath, String text) {
		try {
			String actualtext = driver.findElementByXPath(xpath).getText();
			//string name should be declared with standard
			if (actualtext.equalsIgnoreCase(text)) {
				System.out.println("Text " +text+ " is verified");
			} else {
				System.out.println("Text " +text+ " not verified");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpath + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String actualText = driver.findElementByXPath(xpath).getText();
			//string name should be declared with standard
			if (actualText.contains(text)) {
				System.out.println("Verification is success and it contains "+text);
			} else {
				System.out.println("Verification not success and it doesnot contains"+text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpath + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}
	}

	//@Override
	public void verifyTextContainsById(String id, String text) {
		try {
			String actualtext = driver.findElementById(id).getText();
			//string name should be declared with standard
			if (actualtext.contains(text)) {
				System.out.println("Verification is success and it contains "+text);
			} else {
				System.out.println("Verification not success and it doesnot contains"+text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}
		// TODO Auto-generated method stub

	}

	//@Override
	public void clickById(String id) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			//this should be implemented before click() function
			driver.findElementById(id).click();

			//System.out.println("Click is successful");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}
		// TODO Auto-generated method stub

	}

	//@Override
	public void clickByClassName(String classVal) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.className(classVal)));
			//this should be implemented before click() function
			driver.findElementByClassName(classVal).click();
			System.out.println(" Click is successful");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + classVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}

	}

	//@Override
	public void clickByName(String name) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
			//this should be implemented before click() function
			driver.findElementByName(name).click();
			System.out.println(" Click is successful");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + name + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public void clickByLink(String name) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
			//this should be implemented before click() function
			driver.findElementByLinkText(name).click();
			System.out.println(" Click is successful");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + name + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}
		// TODO Auto-generated method stub

	}

	//@Override
	public void clickByXpath(String xpathVal) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			//this should be implemented before click() function
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("Click is successful");
		} catch (NoSuchElementException e1) {
			System.out.println("Element " + xpathVal + " not found");
		} catch (WebDriverException e2) {
			System.out.println("Driver not launched successfully");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub

	}

	public void clickByXpathWithoutSnap(String xpathVal) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			//this should be implemented before click() function
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("Click is successful");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public String getTextById(String idVal) {
		String realtext = null;
		try {

			realtext = driver.findElementById(idVal).getText();
			System.out.println(realtext);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + idVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub
		return realtext;
	}

	//@Override
	public String getTextByXpath(String xpathVal) {
		String realtext=null;
		try {

			 realtext = driver.findElementByXPath(xpathVal).getText();
			 return realtext;
			// System.out.println(realtext);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}

		finally {
			//takeSnap();
		}
		
		// TODO Auto-generated method stub
		return realtext;
	}

	//@Override
	public String getTextByClassname(String className) {
		String realtext=null;
		try {

			 realtext = driver.findElementByClassName(className).getText();
			 return realtext;
			// System.out.println(realtext);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + className + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}

		finally {
			//takeSnap();
		}
		
		// TODO Auto-generated method stub
		return realtext;
	}
	//@Override
	public void selectVisibileTextById(String id, String value) {
		try {
			new Select(driver.findElementById(id)).selectByVisibleText(value);

			//WebElement drop = driver.findElementById(id);
			//Select obj = new Select(drop);
			//obj.selectByVisibleText(value);

		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}

		// TODO Auto-generated method stub

	}

	//@Override
	// selectIndexById("username","s4");
/*	public void selectIndexById(String id, String value) {
		try {
			 
new Select(driver.findElementById(id)).selectByIndex(Integer.parseInt(value));
//WebElement drop = driver.findElementById(id);
			//Select obj = new Select(drop);
			//int result = Integer.parseInt(value);// to convert
			//obj.selectByIndex(result);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} catch (NumberFormatException e) {
			System.out.println("The entered text" +value +"should be only numbers");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub

	}
*/
	
	public void selectIndexById(String id, String value) {
		try {
			 
new Select(driver.findElementById(id)).selectByIndex(Integer.parseInt(value));
WebElement drop = driver.findElementById(id);
			Select obj = new Select(drop);
			int result = Integer.parseInt(value);// to convert
			obj.selectByIndex(result);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} catch (NumberFormatException e) {
			System.out.println("The entered text" +value +"should be only numbers");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub

	}
	
	
	public void selectAutosearchById(String id, String value, String path) {
		
		try{
		WebElement autoOptions= driver.findElement(By.id(id));
		autoOptions.sendKeys(value);

		List<WebElement> optionsToSelect = driver.findElements(By.xpath(path));

		for(WebElement option : optionsToSelect){
		    System.out.println(option);
		    option.click();
		   /* if(option.getText().equals(value)) {
		        System.out.println("Trying to select: "+value);
		        option.click();
		        break;
		    }*/}	
	
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} catch (NumberFormatException e) {
			System.out.println("The entered text" +value +"should be only numbers");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub

	}
	//@Override
	public void switchToParentWindow() {
		try {
			for (String wineach : driver.getWindowHandles())
			{////can be directly implemented in for each loop instead of storing it in set {
				driver.switchTo().window(wineach);
				break;
			}
			System.out.println("Switched out to parent window");

		} catch (NoSuchWindowException e) {
			System.out.println("No such window found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public void switchToLastWindow() {
		try {
			//Set<String> wins = driver.getWindowHandles();
			//can be directly implemented in for each loop instead of storing it in set
			for (String wineach : driver.getWindowHandles()) {
				driver.switchTo().window(wineach);
			}
			System.out.println("Switched out to last window");
		} catch (NoSuchWindowException e) {
			System.out.println("No such window found");
		} catch (WebDriverException e2) {
			System.out.println("Driver not launched successfully");
		}

		finally {
			//takeSnap();
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public void acceptAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());//wait object can be implemented here to wait for alert to appear
			driver.switchTo().alert().accept();
			System.out.println("Alert Accepted");
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert Present");
		} catch (WebDriverException e2) {
			System.out.println("Driver not launched successfully");
		}

		// TODO Auto-generated method stub

	}

	//@Override
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./snaps/snap" + i + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;

	}

	//@Override
	public void quitBrowser() {
		try {

			driver.quit();
			System.out.println("All browsers closed");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		}
	}

	public void getcount(String xpathValue) {
		try {
			String total = driver.findElementByXPath(xpathValue).getText().replaceAll(",", "");
			//to handle the special characters in string in run time use replaceAll()
			System.out.println("Count is" + total);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathValue + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {
			//takeSnap();
		}
	
	}
	
	public void login(){
		String Lname, Login, Signup;
	//	invokeApp("Firefox", "http://property.sulekha.com/apartments-flats-in-pune-for-sale");
		//clickByXpath("/html/body/header/div[5]/a[1]");
		clickByClassName("sul_ressignin");
		
		//Iframe element (Login panel)
		driver.switchTo().frame("frMyAccount");
		
		//Username
	   	enterByXpath("//input[@id='txtuname']", "jaleel.sulekha@gmail.com");
	   	//Password
		enterById("txtpwd", "sulekha123");
		
		clickById("btnsignin");
		
		driver.switchTo().parentFrame();
		//Navigate to home page
		clickByXpath("//*[@id='Layer_1']");
		//clickByXpath("/html/body/header/div[5]/div/a/span");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lname = getTextByClassname("sul_loginname");
		if(Lname.equalsIgnoreCase("ahkelus")){
			Reporter.log("Logged In Successfully", true);
		} else {
			Reporter.log("Problem in logging in", false);
		}
			
	/*	Actions builder = new Actions(driver);
		WebElement we = driver.findElement(By.className("sul_loginname"));
		builder.moveToElement(we).perform();
		we.click();
		
		clickByXpath("/html/body/header/div[5]/div/ul/li[3]/a");
		
		clickByClassName("//*[@class='CommonSearch']");
		enterByXpath("//*[@id='ulSelected']/li/input", "senap");
		clickByXpath("//*[@id='csContainer']/span/div/div/ul/li[2]");
		Login = getTextByClassname("sul_ressignin");
		Signup = getTextByClassname("sul_resreg");
		
		if(Login.equalsIgnoreCase("Login") & Signup.equalsIgnoreCase("Sign up")){
			Reporter.log("Logged out successfully", true);
		} else { Reporter.log("Not logged out", false);  } */
	   }
	
	//@Override
	public String getclassnameXpath(String xpathVal) {
		String realtext = null;
		try {

			realtext = driver.findElementByXPath(xpathVal).getAttribute("class");
			return realtext;
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub
		return realtext;
	}
	
	//@Override
	public String getDataIdbyXpath(String xpathVal) {
		String realtext = null;
		try {

			realtext = driver.findElementByXPath(xpathVal).getAttribute("data-adsid");
			System.out.println(realtext);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub
		return realtext;
	}
	
	//@Override
	public String getHrefbyXpath(String xpathVal) {
		String realtext = null;
		try {

			realtext = driver.findElementByXPath(xpathVal).getAttribute("href");
			System.out.println(realtext);
		} catch (NoSuchElementException e) {
			System.out.println("Element " + xpathVal + " not found");
		} catch (WebDriverException e) {
			System.out.println("Driver not launched successfully");
		} finally {

			//takeSnap();
		}
		// TODO Auto-generated method stub
		return realtext;
	}
	
	public void mouseHoverByXpath(String xpathVal){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));		
	Actions builder = new Actions(driver);
	WebElement we = driver.findElement(By.xpath(xpathVal));
	builder.moveToElement(we).perform();
	}
	
	protected boolean isElementPresent(String elem){
        try{
            driver.findElementByXPath(elem);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
	
	  public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;
		          
		      }
		          }
		     return false;
		  }

}
