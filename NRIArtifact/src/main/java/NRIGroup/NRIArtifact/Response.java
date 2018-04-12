package NRIGroup.NRIArtifact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.*;


public class Response extends GenericWrappers {

	@Test
	public void re_resp(){
		String Msg1, Msg2;
		Msg1 = "Thank you. You already contacted this advertiser. However, he / she will respond to you within the next 48hrs or else you can contact him / her at the given number";
		Msg2 = "Thank you. We have shared your interest with this advertiser. He / she will contact you within the next 48hrs or else you can contact him / her at the given number";
		invokeApp("Chrome","http://property.sulekha.com/apartments-flats-in-pune-for-sale");
		
		//Close LCF popup window
		clickByXpath("//*[@id='lcfPanelV1']/div[2]/a");
		
		
		//Click on View Contact button
		clickByXpath("//a[starts-with(@id,'btnViewContact_')][1]");
		//Enter responder name
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_name']","ahkelus");
		//Enter responder email id
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_email']","ganesunisan@gmail.com");
		//Enter responder Mobile number
		clickByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on mobile number & update the masked number
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']","7338852451");
	    //Click on submit button
		clickByXpath("//*[@id='frmSPR']/div[6]/a");
		
		if(Msg1.equalsIgnoreCase(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p")))
		{
			System.out.println("Response posted successfully");
			Assert.assertTrue(true);
			Reporter.log(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p"));
		}
		else if(Msg2.equalsIgnoreCase(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p")))
		{
			System.out.println("Response posted successfully");
			Assert.assertTrue(true);
			Reporter.log(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p"));
		}
		else
		{
			System.out.println("Problem in posting response");
			Assert.assertTrue(false);
		}
		driver.close();
	}
	
	@Test
	public void rent_resp(){

		String Msg1, Msg2;
		Msg1 = "Thank you. You already contacted this advertiser. However, he / she will respond to you within the next 48hrs or else you can contact him / her at the given number";
		Msg2 = "Thank you. We have shared your interest with this advertiser. He / she will contact you within the next 48hrs or else you can contact him / her at the given number";
		invokeApp("Chrome","http://property.sulekha.com/apartments-flats-for-rent/bangalore");
		//Close LCF popup window
				clickByXpath("//*[@id='lcfPanelV1']/div[2]/a");
		
		//Click on View Contact button
		clickByXpath("//button[starts-with(@id,'btnViewContact_')][1]");  
		//Enter responder name
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_name']","ahkelus");
		//Enter responder email id
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_email']","ganesunisan@gmail.com");
		//Enter responder Mobile number
		clickByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on mobile number & update the masked number
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']","7338852451");
	    //Click on submit button
		clickByXpath("//*[@id='frmSPR']/div[6]/a");
		
		if(Msg1.equalsIgnoreCase(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p")))
		{
			System.out.println("Response posted successfully");
			Assert.assertTrue(true);
			Reporter.log(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p"));
		}
		else if(Msg2.equalsIgnoreCase(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p")))
		{
			System.out.println("Response posted successfully");
			Assert.assertTrue(true);
			Reporter.log(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p"));
		}
		else
		{
			System.out.println("Problem in posting response");
			Assert.assertTrue(false);
		}
		driver.close();
	
	}
	
	@Test
	public void Proj_resp(){
		String Msg1, Msg2;
		Msg1 = "Thank you. You already contacted this advertiser. However, he / she will respond to you within the next 48hrs or else you can contact him / her at the given number";
		Msg2 = "Thank you. We have shared your interest with this advertiser. He / she will contact you within the next 48hrs or else you can contact him / her at the given number";
		invokeApp("Chrome","http://property.sulekha.com/ongoing-projects-in-pune");
		
		//Close LCF popup window
				clickByXpath("//*[@id='lcfPanelV1']/div[2]/a");
		
		//Click on View Contact button
		clickByXpath("//a[starts-with(@id,'btnViewContact_')][1]");
		//Enter responder name
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_name']","ahkelus");
		//Enter responder email id
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_email']","ganesunisan@gmail.com");
		//Enter responder Mobile number
		clickByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on mobile number & update the masked number
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']","7338852451");
	   //Select Unit
		//clickByXpath("//*[@id='divContent']/div/ul/div/div/li[1]");
		//*[@id="ulbuyingperiod"]/div/div/li[6]/div/b
		
		
		//Click on submit button
		clickByXpath("//*[@id='frmSPR']/div[6]/a");
		
		if(Msg1.equalsIgnoreCase(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p")))
		{
			System.out.println("Response posted successfully");
			Assert.assertTrue(true);
			Reporter.log(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p"));
		}
		else if(Msg2.equalsIgnoreCase(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p")))
		{
			System.out.println("Response posted successfully");
			Assert.assertTrue(true);
			Reporter.log(getTextByXpath("//*[@id='contact-thanks-modal']/div[1]/div[1]/p"));
		}
		else
		{
			System.out.println("Problem in posting response");
			Assert.assertTrue(false);
		}
		driver.close();
	}
	
	//@Test
	public void Proj_brochure(){
		String Msg1, Msg2, resptype;
		Msg1 = "Thank you. You already contacted this advertiser. However, he / she will respond to you within the next 48hrs or else you can contact him / her at the given number";
		Msg2 = "Thank you. We have shared your interest with this advertiser. He / she will contact you within the next 48hrs or else you can contact him / her at the given number";
		invokeApp("Chrome","http://property.sulekha.com/ongoing-projects-in-pune");
		//Click on View Contact button
		clickByXpath("//a[starts-with(@id,'btnDownloadBrochure_')][1]");
		
		resptype = getTextByXpath("//*[@id='divResponseForm']/div[1]/h4");
		
		if(resptype.equalsIgnoreCase("Download Brochure")){
		//Enter responder name
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_name']","ahkelus");
		//Enter responder email id
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/input[@id='spr_email']","ganesunisan@gmail.com");
		//Enter responder Mobile number
		clickByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on mobile number & update the masked number
		enterByXpath("//section[@id='ResponseControl']/div/div/form/div/div/div/input[@id='spr_mobile']","7338852451");
	 		
		//Click on submit button
		clickByXpath("//*[@id='frmSPR']/div[6]/a");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(isFileDownloaded("C:/Users/mohamedjaleel/Downloads","Sulekha-Property_-satyam-serenity-in-wadgaon-sheri-pune.pdf"));
		}
		else
		{Reporter.log("Download brochure title doesn match");
		Assert.assertTrue(false);
				
		}
		
		driver.close();
	}
	
}
