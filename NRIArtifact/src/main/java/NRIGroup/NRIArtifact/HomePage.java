package NRIGroup.NRIArtifact;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.sun.java.swing.plaf.windows.resources.windows;

import junit.framework.Assert;

public class HomePage extends GenericWrappers{

	
	@Test
	public void BuySearch(){
		invokeApp("chrome", "http://spazure.sulekha.com/nri/chennai");
		
		//Verify Title 
		
		Assert.assertEquals(getTextByXpath("/html/body/div[4]/section[1]/div/h1"), "Find world-class properties in Chennai");
		
		
	}	


}
