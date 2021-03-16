package testcases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.twitter.base.TestBase;


public class  Sharing_tweets extends TestBase {		
	
public Sharing_tweets() throws IOException {
	
		super();
	
	}


@BeforeMethod
public void setupandlogin() throws IOException
	       {
	         initialization(prop.getProperty("URL"));
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     driver.manage().window().maximize();
		     WebElement login = driver.findElement(By.xpath("//a[@data-testid='loginButton']")); 
		     login.click();
		     WebElement username= driver.findElement(By.xpath("//input[@type='text']"));
		     username.sendKeys(prop.getProperty("username"));
		     WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		     password.sendKeys(prop.getProperty("password"));
		     WebElement login2   =driver.findElement(By.xpath("//div[@data-testid='LoginForm_Login_Button']")); 
		     login2.click();
		    		    
	       }

	  
@Test (priority =1)
public void TW_4() throws IOException, InterruptedException //TW_4 is positive test case in test design PDF
           {

             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
             WebElement text=  driver.findElement(By.xpath("//div[@aria-label='Tweet text']"));
 		     WebElement tweetbutton=  driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']"));
 		     text.sendKeys("sheref");
 		     tweetbutton.click();
		     File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
			 FileUtils.copyFile(srcFile, new File ("C:\\Users\\sherif.helmy\\eclipse-workspace\\Task\\Snapshots\\TW_4.png"));          
	         
           }


@Test (priority =2)
public void TW_2() throws IOException //TW_2 is  negative  test case in test design PDF
           {


             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
             WebElement text=  driver.findElement(By.xpath("//div[@aria-label='Tweet text']"));
 		     text.sendKeys("sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584sheref10334954121221230102584");
 		     // number of characters = "319"  
 		     WebElement tweetbutton=  driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']"));
		     tweetbutton.click();
		     WebElement countcharacters=  driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1p0dtai r-1777fci r-1d2f490 r-ywje51 r-u8s1d r-zchlnj r-ipm5af']"));
		     boolean actual = countcharacters.isDisplayed();// when this count is found , this is mean that tweet isn't shared because the characters are more than the max 
		     Assert.assertTrue(actual, "test cases is failed ");
		    
             
		     File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
			 FileUtils.copyFile(srcFile, new File ("C:\\Users\\sherif.helmy\\eclipse-workspace\\Task\\Snapshots\\TW_2.png"));          
	         
           }

@Test (priority =3)
public void TW_7() throws IOException //TW_7 is  negative  test case in test design PDF
           {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
            WebElement text=  driver.findElement(By.xpath("//div[@aria-label='Tweet text']"));
 		    text.sendKeys("sheref");
 		    WebElement tweetbutton=  driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']"));
		    tweetbutton.click();
		    WebElement failtext=  driver.findElement(By.cssSelector("div[class='css-901oao r-18jsvk2 r-1qd0xha r-a023e6 r-16dba41 r-ad9z0x r-bcqeeo r-qvutc0']"));
            boolean actual = failtext.isDisplayed();// fail text refer to this content is already share it  
            Assert.assertTrue(actual, "yes");
             
		    File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
			FileUtils.copyFile(srcFile, new File ("C:\\Users\\sherif.helmy\\eclipse-workspace\\Task\\Snapshots\\TW_7.png"));          
	         
           }

	
	
@Test (priority =4)
public void TW_11() throws IOException, InterruptedException //TW_11 is positive test case in test design PDF
           {
	
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
             WebElement addGIF=  driver.findElement(By.xpath("//div[@aria-label='Add a GIF']"));
             addGIF.click();
             WebElement chooseGIF=  driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-urgr8i r-1mlwlqe r-16y2uox r-1udh08x r-417010']"));
             chooseGIF.click();
             WebElement confirmGIF=  driver.findElement(By.xpath("//img[@alt='Proud Of You Yes GIF']"));
             confirmGIF.click();
             WebElement tweetbutton=  driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']"));
		     tweetbutton.click();
		     Thread.sleep(5000);//to wait sharing a GIF before quite of after method 
		     WebElement nameofuser=  driver.findElement(By.cssSelector("div[class='css-901oao css-bfa6kz r-m0bqgq r-18u37iz r-1qd0xha r-a023e6 r-16dba41 r-ad9z0x r-bcqeeo r-qvutc0']"));
		     boolean actual = nameofuser.isDisplayed();//confirm that this user share a tweet in your homepage 
		     Assert.assertTrue(actual, "tweet isn't shared yet");
    
		     File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
			 FileUtils.copyFile(srcFile, new File ("C:\\Users\\sherif.helmy\\eclipse-workspace\\Task\\Snapshots\\void TW_11.png"));  //Path of saving screenshots        
	         
           }


@Test (priority =5)
public void TW_13() throws IOException, InterruptedException//TW_13 is positive test case in test design PDF 
           {

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           WebElement addpoll=  driver.findElement(By.xpath("//div[@aria-label='Add poll']"));
           addpoll.click();
           WebElement addtextpoll=  driver.findElement(By.xpath("//div[@aria-label='Tweet text']"));
           addtextpoll.sendKeys("vote");
           WebElement choice1=  driver.findElement(By.xpath("//input[@name='Choice1']"));
           choice1.sendKeys("ch1");
           WebElement choice2=  driver.findElement(By.xpath("//input[@name='Choice2']"));
           choice2.sendKeys("ch2");
           WebElement tweetbutton=  driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']"));		                                                                                   
           tweetbutton.click();
           Thread.sleep(5000);//to wait sharing a poll before quite of after method

	     		     		    		     
 		   File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
		   FileUtils.copyFile(srcFile, new File ("C:\\Users\\sherif.helmy\\eclipse-workspace\\Task\\Snapshots\\TW_13.png"));          
	         
           }

@Test (priority =6)
public void TW_14() throws IOException, InterruptedException//TW_14 is  negative  test case in test design PDF 
         {

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           WebElement addpoll=  driver.findElement(By.xpath("//div[@aria-label='Add poll']"));
           addpoll.click();
           WebElement tweetbutton=  driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']"));		                                                                                   
           tweetbutton.click();
           WebElement choice1=  driver.findElement(By.xpath("//input[@name='Choice1']"));
           boolean actual = choice1.isDisplayed();
           Assert.assertTrue(actual, "testcases is failed ");
           System.out.println(actual);
           	     		    		     
		   File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   
		   FileUtils.copyFile(srcFile, new File ("C:\\Users\\sherif.helmy\\eclipse-workspace\\Task\\Snapshots\\TW_14.png"));          
	         
         }

  @AfterMethod
    public void exit() 
           {
	
		   driver.quit();
	      
           }
	
	
	
           }
