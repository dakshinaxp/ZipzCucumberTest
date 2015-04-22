package zipzmaven;


import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefination {
	public static AndroidDriver  driver;
	
	@Given("^step up maven dependency for netive app$")
	public void step_up_maven_dependency_for_netive_app() throws Throwable {
		
		String Path = "E:/Maven/Zipz/Excel/Input/Zipz-mastercopy-inputfile.xls";
		FileInputStream file = new FileInputStream(new File(Path));
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet setup = workbook.getSheetAt(0);

		Cell classpath = setup.getRow(31).getCell(9); 
		classpath.setCellType(Cell.CELL_TYPE_STRING);
		String root = classpath.getStringCellValue(); 
		File classpathRoot = new File(System.getProperty(root));
		System.out.println("Classpathroot: " + root );

		File appDir = new File(classpathRoot,"/appfiles2");
		
		Cell appname = setup.getRow(32).getCell(9); 
		appname.setCellType(Cell.CELL_TYPE_STRING);
		String name = appname.getStringCellValue(); 
		File app = new File(appDir,name);
		System.out.println("App Name: " + name );
			
		DesiredCapabilities Capabilities  = new DesiredCapabilities();
		
		Cell Devices = setup.getRow(33).getCell(9); 
		Devices.setCellType(Cell.CELL_TYPE_STRING);
		String Devicename = Devices.getStringCellValue(); 
		Capabilities.setCapability("deviceName",Devicename);
		System.out.println("Device Name: " + Devicename );
		
		Cell Platform = setup.getRow(34).getCell(9); 
		Platform.setCellType(Cell.CELL_TYPE_STRING);
		String platformname = Platform.getStringCellValue(); 
		Capabilities.setCapability("platformName",  platformname );
		System.out.println("platform Name: " + platformname );
		
		Cell platform1 = setup.getRow(35).getCell(9); 
		platform1.setCellType(Cell.CELL_TYPE_STRING);
		String platformversion = platform1.getStringCellValue(); 
		Capabilities.setCapability("platformVersion",platformversion);
		System.out.println("platform version: " + platformversion );
	
		Cell Browsername = setup.getRow(37).getCell(9); 
		Browsername.setCellType(Cell.CELL_TYPE_STRING);
		String browser = Browsername.getStringCellValue(); 
		Capabilities.setCapability("browserName",browser);
		System.out.println("Browser Name: " + browser );
		
		Capabilities.setCapability("app",app.getAbsolutePath());
		
		Cell Apppackage = setup.getRow(38).getCell(9); 
		Apppackage.setCellType(Cell.CELL_TYPE_STRING);
		String apppack = Apppackage.getStringCellValue(); 
		Capabilities.setCapability("appActivity",apppack);
		System.out.println("App package: " + apppack );
		
		Cell Appacitivity = setup.getRow(39).getCell(9); 
		Appacitivity.setCellType(Cell.CELL_TYPE_STRING);
		String appactv = Appacitivity.getStringCellValue(); 
		Capabilities.setCapability("appActivity",appactv);
		System.out.println("App Acitivity: " + appactv );
		
		Cell Appwaiting = setup.getRow(40).getCell(9); 
		Appwaiting.setCellType(Cell.CELL_TYPE_STRING);
		String Appwait = Appwaiting.getStringCellValue(); 
		Capabilities.setCapability("appWaitActivity",Appwait);
		System.out.println("App Wait Activity: " + Appwait );
		
		Cell UID = setup.getRow(36).getCell(9); 
		UID.setCellType(Cell.CELL_TYPE_STRING);
		String UIDnumber = UID.getStringCellValue(); 
		Capabilities.setCapability("udid",UIDnumber);
		System.out.println("UID Number: " + UIDnumber );
		
	
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),Capabilities);
	
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^getting current app active page name$")
	public void getting_current_app_active_page_name() throws Throwable {
	  
		String currentpage =  driver.currentActivity();
	    System.out.println(currentpage);
	    
	}

	@And("^Enter valid zipcode$")
	public void Enter_valid_zipcode() throws Throwable {
	   
		String Path = "E:/Maven/Zipz/Excel/Input/Zipz-mastercopy-inputfile.xls";
		FileInputStream file = new FileInputStream(new File(Path));
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(3);
		
		Cell zip = sheet.getRow(21).getCell(8); 
		zip.setCellType(Cell.CELL_TYPE_STRING);
		String zipcode = zip.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_splash_activity_address")).sendKeys(zipcode);
		System.out.println("Zipcode: " + zipcode );
		
				
					
			
	}

	@And("^click on Go button$")
	public void click_on_Go_button() throws Throwable {
	   
		driver.findElement(By.id("com.zipz.zipzapp:id/button_splash_activity_go")).click();
		Thread.sleep(6000);
	}

	

	@And("^Select Sign in option in menu bar$")
	public void Select_Sign_in_option_in_menu_bar() throws Throwable {
		driver.findElement(By.id("com.zipz.zipzapp:id/button_customer_baselayout_activity_list")).click();
		List<WebElement> weekObjectList = driver.findElements(By.xpath("//android.widget.ListView[1]//android.widget.TextView"));
		weekObjectList.get(2).click();
	}

	@And("^Checking the current app page$")
	public void Checking_the_current_app_page() throws Throwable {
		
		String currentpage =  driver.currentActivity();
	    System.out.println(currentpage);
	    
	}

	@And("^Click thr Creare an account button$")
	public void Click_thr_Creare_an_account_button() throws Throwable {
	    
		driver.findElement(By.id("com.zipz.zipzapp:id/button_customer_signin_activity_createan_account")).click();
	}



	@And("^populate all values in excel sheet$")
	public void populate_all_values_in_excel_sheet() throws Throwable {
		System.out.println("5345465");
		String Path = "E:/Maven/Zipz/Excel/Input/Zipz-mastercopy-inputfile.xls";
		FileInputStream file = new FileInputStream(new File(Path));
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		
		HSSFSheet sheet = workbook.getSheetAt(4);
		HSSFSheet sheet1 = workbook.getSheetAt(5);
		
		HSSFSheet sheet3 = workbook.getSheetAt(1);
		
		StringBuffer outputbuf1 = new StringBuffer();
		StringBuffer outputbuf2 = new StringBuffer();
		
		Cell remark = sheet1.getRow(19).getCell(2);
		remark.setCellValue(outputbuf1.toString());
		
		for(int i=8; true; i++) 
		{
		  	HSSFCell TC = sheet.getRow(i).getCell(0);
			if( TC.getStringCellValue().length() < 1)
				{
					break;
				}
		Cell FullName = sheet.getRow(i).getCell(1); 
		FullName.setCellType(Cell.CELL_TYPE_STRING);
		String name1 = FullName.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_firstname")).sendKeys(name1);
		System.out.println("Full Name: " + name1 );
		
		Cell Lastname = sheet.getRow(i).getCell(2); 
		Lastname.setCellType(Cell.CELL_TYPE_STRING);
		String lname = Lastname.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_lastname")).sendKeys(lname);
		System.out.println("last Name: " + lname );
		
		Cell Emailid = sheet.getRow(i).getCell(3); 
		Emailid.setCellType(Cell.CELL_TYPE_STRING);
		String Email = Emailid.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_email")).sendKeys(Email);
		System.out.println("E-mail id: " + Email );
		
		Cell Password = sheet.getRow(i).getCell(4); 
		Password.setCellType(Cell.CELL_TYPE_STRING);
		String pwd = Password.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_password")).sendKeys(pwd);
		System.out.println("Password: " + pwd );
		driver.scrollToExact("Agree to ");
		
		Cell cPassword = sheet.getRow(i).getCell(5); 
		cPassword.setCellType(Cell.CELL_TYPE_STRING);
		String cpwd = cPassword.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_confirmpassword")).sendKeys(cpwd);
		System.out.println("confrim Password: " + cpwd );
		
		Cell Phone = sheet.getRow(i).getCell(6); 
		Phone.setCellType(Cell.CELL_TYPE_STRING);
		String mobile = Phone.getStringCellValue(); 
		driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_mobile")).sendKeys(mobile);
		System.out.println("Mobile " + mobile );
		
		WebElement checkBox = driver.findElement(By.id("com.zipz.zipzapp:id/checkbox_customer_signup_activity_privacypolicy"));
		if(!checkBox.isSelected())
		{
			
			checkBox.click();
		}
		
		driver.findElement(By.id("com.zipz.zipzapp:id/button_customer_signup_activity_createan_account")).click();
		Thread.sleep(4000);
		
		String expected=	driver.currentActivity();
		System.out.println(expected);
		
		String actual = ".customer.activities.CustomerHomeActivity";
		if(expected.equals(actual))
		{
			driver.findElement(By.id("com.zipz.zipzapp:id/button_customer_baselayout_activity_list")).click();
			//Menu selection
			List<WebElement> menulist = driver.findElements(By.xpath("//android.widget.ListView[1]//android.widget.TextView"));
			menulist.get(2).getText();
			
			System.out.println(menulist);
			
			String Expect = "Account Setup";
			if(menulist.equals(Expect))
			{
				System.out.println("Account Setup menu desplyed");
			}
			else{
				System.out.println("not displayed");
				}
			

			
			Cell pass = sheet3.getRow(14).getCell(10);
			pass.setCellValue("Pass");
			
			Cell num = sheet1.getRow(7).getCell(0);
			num.setCellType(Cell.CELL_TYPE_STRING);
			num.setCellValue("TC0001");
			
			Cell pass1 = sheet1.getRow(7).getCell(1);
			pass1.setCellValue("Pass");
			System.out.println("Functonality " + TC + " is " + "Pass");
			System.out.println("==========================");
			
			//Menu selection
			List<WebElement> logout = driver.findElements(By.xpath("//android.widget.ListView[1]//android.widget.TextView"));
			logout.get(5).click();
			driver.findElement(By.id("android:id/button1")).click();
			driver.findElement(By.id("com.zipz.zipzapp:id/button_customer_signin_activity_createan_account")).click();
			}
		else
		{
			Cell fail = sheet3.getRow(14).getCell(10);
			fail.setCellValue("Fail");
			
			Cell num = sheet1.getRow(7).getCell(0);
			num.setCellType(Cell.CELL_TYPE_STRING);
			num.setCellValue("TC0001");
			
			Cell fail1 = sheet1.getRow(7).getCell(1);
			fail1.setCellValue("Fail");
			System.out.println("Functonality " + TC + " is " + "fail");
			System.out.println("==========================");
			outputbuf2.append(" ~~ Functionality gets failed in : " +TC);
			outputbuf2.append(System.getProperty("line.separator"));
			
			driver.findElement(By.id("android:id/button3")).click();
			driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_firstname")).clear();
			driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_lastname")).clear();
			
			WebElement longp = driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_email"));
			TouchAction pressdown = new TouchAction ((MobileDriver)driver).longPress(longp);
			pressdown.perform();
			longp.getText();
			driver.sendKeyEvent(67);
			driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_password")).clear();
			driver.scrollToExact("Agree to ");
			driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_confirmpassword")).clear();
			driver.findElement(By.id("com.zipz.zipzapp:id/edittext_customer_signup_activity_mobile")).clear();
			WebElement checkBox1 = driver.findElement(By.id("com.zipz.zipzapp:id/checkbox_customer_signup_activity_privacypolicy"));
			checkBox1.click();
			driver.scrollToExact("Full name *");
			
			
			HSSFSheet setup = workbook.getSheetAt(0);
			
			Cell outpath = setup.getRow(43).getCell(9); 
			outpath.setCellType(Cell.CELL_TYPE_STRING);
			String out = outpath.getStringCellValue(); 
			FileOutputStream outFile = new FileOutputStream(new File(out));
			System.out.println("OutPath: " + out );
			workbook.write(outFile);
			file.close();
		  	outFile.close();
		}
		}
		
	}

	@And("^checking the validation pass or fail$")
	public void checking_the_validation_pass_or_fail() throws Throwable {
		System.out.println("closed");
	}

	@Then("^close the app$")
	public void close_the_app() throws Throwable {
		  
		driver.quit();
		System.out.println("closed");
			
		
	}
	
	
}
