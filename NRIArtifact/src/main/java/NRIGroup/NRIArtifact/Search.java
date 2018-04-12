package NRIGroup.NRIArtifact;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.sun.java.swing.plaf.windows.resources.windows;

import junit.framework.Assert;

public class Search extends GenericWrappers{

	
	//@Test
	public void BuySearch(){
		invokeApp("chrome", "http://property.sulekha.com/pune-real-estate");
		
		//Select Buy search - Location
		clickByClassName("//*[@class='CommonSearch']");
		enterByXpath("//*[@id='ulSelected']/li/input", "senap");
		clickByXpath("//*[@id='csContainer']/span/div/div/ul/li[2]");
		//String Hloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		String Hloc = "Senapati Bapat Road ×";
		
		//Select property type
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		clickByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[2]");
		String Hptype = getTextByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		
		//Select Price
		clickByXpath("//*[@id='fromprice']/dl/dt/a");
		String HFprice = getTextByXpath("//*[@id='fromprice']/dl/dd/ul/li[12]").substring(0,4);
		clickByXpath("//*[@id='fromprice']/dl/dd/ul/li[12]");
		
			
		clickByXpath("//*[@id='toprice']/dl/dt/a");
		String HTprice = getTextByXpath("//*[@id='toprice']/dl/dd/ul/li[8]").substring(0,4);
		clickByXpath("//*[@id='toprice']/dl/dd/ul/li[8]");
		
		String Hprice = HFprice+" - "+HTprice;
		
		//Select BHK
		clickByXpath("//*[@id='bedroom']/dt/a/span");
		String HBhk = getTextByXpath("//*[@id='bedroom']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='bedroom']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='bedroom']/dt/a/span");
			
		//Click Search - Navigate to listing page
		clickByXpath("/html/body/div[3]/div[2]/div/div[4]/a");
		
		String Lloc, Lptype, Lprice, LBhk;
		Lloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		Lptype = getTextByXpath("//*[@id='PropertyTypePanel']/a/span");
		Lprice = getTextByXpath("//*[@id='PriceRangePanel']/a/span");
		LBhk = getTextByXpath("//*[@id='BedroomsPanel']/a/span");
		
		
		
		Assert.assertTrue(getTextByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/h1").contains("2 BHK Apartments/Flats in Senapati Bapat Road for 50 lakhs to 85 lakhs"));
		Reporter.log("BUY: Basic filters applied successfully", true);
		
		Reporter.log("Page Title: "+getTextByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/h1"));
		Reporter.log("Location: "+Lloc);
		Reporter.log("Property Type: "+Lptype);
		Reporter.log("Price: "+Lprice);
		Reporter.log("Bedroom: "+LBhk);
		
		
		
		//Click on Save button
		clickById("Save-Search-Form");
		
		//Skip & Save search
		clickByXpath("//*[@id='RegisterForm']/div/div/div[2]/a");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click on Saved search icon
		
		clickByXpath("//*[@id='desk-saveIcon']/span");
	
		driver.quit();
		
	}

	//@Test
	public void RentSearch(){

		invokeApp("Chrome", "http://property.sulekha.com/rentals/hyderabad");
		//driver.get("http://property.sulekha.com/rentals/pune");
		
		//Select Buy search - Location
		clickByClassName("//*[@class='CommonSearch']");
		enterByXpath("//*[@id='ulSelected']/li/input", "Ameen");
		clickByXpath("//*[@id='csContainer']/span/div/div/ul/li[2]");
		//String Hloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		String Hloc = "Senapati Bapat Road ×";
		
		//Select property type
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		clickByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[3]");
		String Hptype = getTextByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[3]");
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		
		//Select Price
		clickByXpath("//*[@id='fromprice']/dl/dt/a");
		String HFprice = getTextByXpath("//*[@id='fromprice']/dl/dd/ul/li[12]").substring(0,4);
		clickByXpath("//*[@id='fromprice']/dl/dd/ul/li[12]");
		
			
		clickByXpath("//*[@id='toprice']/dl/dt/a");
		String HTprice = getTextByXpath("//*[@id='toprice']/dl/dd/ul/li[8]").substring(0,4);
		clickByXpath("//*[@id='toprice']/dl/dd/ul/li[8]");
		
		String Hprice = HFprice+" - "+HTprice;
		
		//Select BHK
		clickByXpath("//*[@id='bedroom']/dt/a/span");
		String HBhk = getTextByXpath("//*[@id='bedroom']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='bedroom']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='bedroom']/dt/a/span");
			
		//Click Search - Navigate to listing page
		clickByXpath("/html/body/div[3]/div[2]/div/div[4]/a");
		
		String Lloc, Lptype, Lprice, LBhk;
		Lloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		Lptype = getTextByXpath("//*[@id='PropertyTypePanel']/a/span");
		Lprice = getTextByXpath("//*[@id='PriceRangePanel']/a/span");
		LBhk = getTextByXpath("//*[@id='BedroomsPanel']/a/span");
		
		
		Assert.assertTrue(getTextByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/h1").contains("2 BHK Individual Houses for Rent in Ameenpur, Hyderabad"));
		Reporter.log("BUY: Basic filters applied successfully", true);
		
		Reporter.log("RENT: Basic filters applied successfully", true);
		Reporter.log("Title: "+getTextByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/h1"));
		Reporter.log("Location: "+Lloc);
		Reporter.log("Property Type: "+Lptype);
		Reporter.log("Price: "+Lprice);
		Reporter.log("Bedroom: "+LBhk);

		
	driver.quit();
		
	}
	
	@Test
	public void ProjSearch(){

		invokeApp("Chrome", "http://property.sulekha.com/pune-real-estate");
		
		clickByXpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
		
		//Select Buy search - Location
		clickByXpath("//*[@class='CommonSearch']");
	//	clickByXpath("//*[@id='csContainer']/span/div/ul[2]/li/a");
	//	clickByXpath("//*[@id='spc_city-localities']/div/div[2]/div[1]/div[1]/ul/li[12]/label");
	//	clickByXpath("//*[@id='spc_city-localities']/div/div[1]/span/a[2]");
		
		enterByXpath("//*[@id='ulSelected']/li/input", "Shirwal");
		clickByXpath("//*[@id='csContainer']/span/div/div/ul/li[2]");
		//String Hloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		String Hloc = "Shirwal ×";
		
		//Select property type
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		clickByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[3]/i");
		
		
		String Hptype = getTextByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		
		//Select Price
		clickByXpath("//*[@id='fromprice']/dl/dt/a");
		String HFprice = getTextByXpath("//*[@id='fromprice']/dl/dd/ul/li[12]").substring(0,4);
		clickByXpath("//*[@id='fromprice']/dl/dd/ul/li[12]");
		
			
		clickByXpath("//*[@id='toprice']/dl/dt/a");
		String HTprice = getTextByXpath("//*[@id='toprice']/dl/dd/ul/li[8]").substring(0,4);
		clickByXpath("//*[@id='toprice']/dl/dd/ul/li[8]");
		
		String Hprice = HFprice+" - "+HTprice;
		
		//Select BHK
		clickByXpath("//*[@id='bedroom']/dt/a/span");
		String HBhk = getTextByXpath("//*[@id='bedroom']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='bedroom']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='bedroom']/dt/a/span");
			
		//Click Search - Navigate to listing page
		clickByXpath("/html/body/div[3]/div[2]/div/div[4]/a");
		
			
		String Lloc, Lptype, Lprice, LBhk;
		Lloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		Lptype = getTextByXpath("//*[@id='PropertyTypePanel']/a/span");
		Lprice = getTextByXpath("//*[@id='PriceRangePanel']/a/span");
		LBhk = getTextByXpath("//*[@id='BedroomsPanel']/a/span");
		
		Assert.assertTrue(getTextByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/h1").contains("New Residential Projects in Shirwal"));
		Reporter.log("Project: Basic filters applied successfully", true);
		
		Reporter.log("Title:  "+getTextByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/h1"));
		Reporter.log("Basic filters applied successfully", true);
		Reporter.log("Location: "+Lloc);
		Reporter.log("Property Type: "+Lptype);
		Reporter.log("Price: "+Lprice);
		Reporter.log("Bedroom: "+LBhk);

		driver.quit();
		
	}
	//@Test
	public void Roommatesearch(){


		invokeApp("Chrome", "http://property.sulekha.com/bangalore-real-estate");
		
		clickByXpath("/html/body/div[3]/div[2]/div/ul/li[3]/a");
		
		//Select Buy search - Location
		clickByXpath("//*[@class='CommonSearch']");
		/*clickByXpath("//*[@id='csContainer']/span/div/ul[2]/li/a");
		clickByXpath("//*[@id='spc_city-localities']/div/div[2]/div[1]/div[1]/ul/li[12]/label");
		clickByXpath("//*[@id='spc_city-localities']/div/div[1]/span/a[2]");*/
		
		enterByXpath("//*[@id='ulSelected']/li/input", "White");
		clickByXpath("//*[@id='csContainer']/span/div/div/ul/li[2]");
		//String Hloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		String Hloc = "whitefield ×";
		
		//Select property type
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		clickByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[3]");
		
		
		
		String Hptype = getTextByXpath("//*[@id='propertyTypeList']/dd/div/ul/li[2]");
		clickByXpath("//*[@id='propertyTypeList']/dt/a/span");
		
		//Select Price
		clickByXpath("//*[@id='fromprice']/dl/dt/a");
		String HFprice = getTextByXpath("//*[@id='fromprice']/dl/dd/ul/li[6]").substring(0,4);
		clickByXpath("//*[@id='fromprice']/dl/dd/ul/li[6]");
		
			
		clickByXpath("//*[@id='toprice']/dl/dt/a");
		String HTprice = getTextByXpath("//*[@id='toprice']/dl/dd/ul/li[6]").substring(0,4);
		clickByXpath("//*[@id='toprice']/dl/dd/ul/li[6]");
		
		String Hprice = HFprice+" - "+HTprice;
		
		
		//Click Search - Navigate to listing page
		clickByXpath("/html/body/div[3]/div[2]/div/div[4]/a");
		
			
	/*	String Lloc, Lptype, Lprice, LBhk;
		Hloc = getTextByXpath("//*[@id='ulSelected']/li[1]");
		Lptype = getTextByXpath("//*[@id='PropertyTypePanel']/a/span");
		Lprice = getTextByXpath("//*[@id='PriceRangePanel']/a/span"); */
				
			
		Assert.assertEquals("Paying Guests,Roommates for Rs 5000 - 10000 in Whitefield", getTextByXpath("//*[@id='ListingsContent']/h1"));
		Reporter.log("Roommates: Basic filters applied successfully", true);
		Reporter.log("Title: "+getTextByXpath("//*[@id='ListingsContent']/h1"));
		//Reporter.log("Location: "+Hloc);
		Reporter.log("Property Type: "+Hptype);
		Reporter.log("Price: "+HFprice+" to "+HTprice);
		
		
	/*	if(Hloc.equalsIgnoreCase(Lloc) & Hptype.equalsIgnoreCase(Lptype) & Hprice.equalsIgnoreCase(Lprice) & HBhk.equalsIgnoreCase(LBhk)){
			System.out.println("Basic search filters applied successfully");
			Reporter.log("Basic filters applied successfully", true);
			Reporter.log("Location: "+Lloc);
			Reporter.log("Property Type: "+Lptype);
			Reporter.log("Price: "+Lprice);
			Reporter.log("Bedroom: "+LBhk);
		} else {  System.out.println("Problem in search");
					Assert.fail();
					Reporter.log("Problerm in basic search", false);
		}*/
		driver.quit();
		
	
		
	}
	//Advance search
		//@Test
		public void Advsearch()
		{
			invokeApp("Chrome", "http://property.sulekha.com/apartments-flats-in-pune-for-sale");
			String stype, pcount, possession; 
			
			//Select Popular locality
			clickByXpath("//li[@class='locitem']/a[1]");
			verifyTextContainsByXpath("//*[@id='divListingsContainer']/section/div/div/div[1]/ul/li[1]", "Nearby Localities Added");
		
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			//Verify Sale type (New)
			clickByXpath("//li[@id='SalesTypePanel']/ul/li/div/ul/li[1]/label");
			//clickByXpath("//li[@id='SalesTypePanel']/ul/li/div/ul/li[2]/label");
						
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			//Possession (2018)
			clickByXpath("//li[@id='PosessionPanel']/ul/li/div/ul[1]/li[1]/label");
			//clickByXpath("//*[@id='PropertyAgePanel']/ul/li/div/ul/li[1]/label");
		
	
			
			String srt, saletype, possn, advtype, furnish, area, amenity;
			srt = getTextByXpath("//li[@id='SortByPanel']/ul/li/a");
			saletype = getTextByXpath("//li[@id='SalesTypePanel']/ul/li/a");
			possn = getTextByXpath("//li[@id='PosessionPanel']/ul/li/a");
			advtype = getTextByXpath("//li[@id='PostedByPanel']/ul/li/a");
			furnish = getTextByXpath("//li[@id='FurnishingTypePanel']/ul/li/a");
			area = getTextByXpath("//li[@id='AreaPanel']/ul/li/a");  
			amenity = getTextByXpath("//li[@id='AmenitiesPanel']/ul/li/a");  
			
			if(srt.equalsIgnoreCase("Sort by") && saletype.equalsIgnoreCase("Sale type") && possn.equalsIgnoreCase("Possession") && advtype.equalsIgnoreCase("Posted by") && furnish.equalsIgnoreCase("Furnishing type") && area.equalsIgnoreCase("Area") && amenity.equalsIgnoreCase("Amenities"))
			{ Assert.assertTrue("All filters available", true); 
			  Reporter.log(srt+"\n"+saletype+"\n"+possn+"\n"+advtype+"\n"+furnish+"\n"+area+"\n"+amenity);
			}
			else
			{ Assert.assertTrue("Problem in filters displaye", false);}
			Reporter.log(srt+"\n"+saletype+"\n"+possn+"\n"+advtype+"\n"+furnish+"\n"+area+"\n"+amenity);
			}


}

