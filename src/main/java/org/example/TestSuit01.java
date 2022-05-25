package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;



public class TestSuit01 {  // start writing code from here

    protected static WebDriver driver; //(Manualy: through = in POM)import selenium webdriver dpendency by clicking on bulb(red)

    //open chrome browser////////////////////////
    @BeforeMethod
    public void openBrowser() {
//declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        //chrome will open
        driver = new ChromeDriver(); //(in POM file)import chrome web-Driver dependency)
        //waiting of duration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //duration to be wait
        //screen maximize
        driver.manage().window().maximize(); //maximizing screen
        //type URL opening web page
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void userShouldBeAbleToRegisterSuccessfully() {
        // click on register button//////////////////
        // driver.findElement(By.className("ico-register")).click();
        clickOnElement(By.className("ico-register"));

        //select gender  female Radio button//////////////////////
        driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();

        // enter firstname///////////////////////
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Hetal");
        driver.findElement(By.xpath("//input[@name='FirstName']")).click();
        typeText(By.xpath("//input[@name='FirstName']"), "Hhhhh");

        //select last name
        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("Patel");
        typeText(By.id("LastName"), "Patel");
        driver.findElement(By.id("LastName")).click();

        // select birthdate ////////////////
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthDay.selectByValue("24");

        //select month
        Select BirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        BirthMonth.selectByValue("8");

        //select year;
        Select BirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        BirthYear.selectByVisibleText("1984");

        //enter email address
//       driver.findElement(By.id("Email")).sendKeys("hetalpatel@gmail.com");
        driver.findElement(By.id("Email")).sendKeys("eeeee" + RandomDate() + "gmail.com");
        typeText(By.id("Email"), "hetalpatel@gmail.com");

        // enter password
//        driver.findElement(By.id("Password")).sendKeys("hetalllll");
        //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("ooooooooo");
        typeText(By.id("Password"), "hetalllll");

        //confirm password
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("hetalllll");
        // driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("ooooooooo");
        typeText(By.id("ConfirmPassword"), "hetalllll");

        ///click register button
        // driver.findElement(By.id("register-button")).click();
        //gettext from(By.id("//button[@id=\"register-button\"]"));
        driver.findElement(By.xpath("//button[@id=\"register-button\"]")).click();

        // result verification/////////////////////
        //  String actualMessage = getTextFromElement(By.className("result"));

        String actualMessage = driver.findElement(By.className("result")).getText();
        String expectedMessage = " Your registration completed";


        //System.out.println("Actual Message:" + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Registration is not successful");
    }
    // String actualMessage = driver.findElement(By.className("result")).getText();
    // String actualMessage = getTexFromElement(By.xpath("//div[@class='result']"));z

    @Test
    public static void UserShouldBeAbleToAddProductToAddToCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        //chrome will open
        driver = new ChromeDriver(); //(in POM file)import chrome web-Driver dependency)
        //waiting of duration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //duration to be wait
        //screen maximize
        driver.manage().window().maximize(); //maximizing screen
        //type URL opening web page
        driver.get("https://demo.nopcommerce.com/");

        //click on computer/////////////////////
        clickOnElement(By.linkText("Computers"));

        //clickOn Desktops
        clickOnElement(By.linkText("Desktops"));

        //click on Build own computer
        clickOnElement(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));

        //select processor 2.5GHz intel
        Select processor = new Select(driver.findElement(By.name("product-attribute-1")));
        processor.selectByIndex(1);

        //select RAM 2GB
        Select Ram = new Select(driver.findElement(By.id("product_attribute_2")));
        Ram.selectByValue("3");

        //select HDD 320 GB
        driver.findElement(By.xpath("//label[@for=\"product_attribute_3_6\"]")).click();

        //select OS vista
        clickOnElement(By.name("product_attribute_4"));

        //select software all 3 checkboxes options
        //MS Office
        clickOnElement(By.xpath("//input[@id=\"product_attribute_5_10\"]"));
        //Acrobat reader
        clickOnElement(By.xpath("//input[@id=\"product_attribute_5_11\"]"));
        //Total commander
        clickOnElement(By.xpath("//input[@id=\"product_attribute_5_12\"]"));

        //click add to card button
        clickOnElement(By.id("//button[@id=\"add-to-cart-button-1\")]"));

        //open shopping cart
        clickOnElement(By.xpath("//span[@class\"cart-label\"]"));
        //clickOnElement(By.name("cart-label"));

        //to verify product has been added to the basket by product name
        String actualMessage = driver.findElement(By.className("product-name")).getText();

        String expectedMessage = "Build your own computer";

        Assert.assertEquals( actualMessage,expectedMessage, "build your computer not added to the cart");
    }
    @Test
    public void userShouldBeAbleToSReferAProductToAFriendThrouhEmail () {


        clickOnElement(By.className("ico-register"));

        //select gender  female Radio button//////////////////////
        driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();

        // enter firstname///////////////////////
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Hetal");
        driver.findElement(By.xpath("//input[@name='FirstName']")).click();
        typeText(By.xpath("//input[@name='FirstName']"), "Hhhhh");

        //select last name
        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("Patel");
        typeText(By.id("LastName"), "Patel");
        driver.findElement(By.id("LastName")).click();

        // select birthdate ////////////////
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthDay.selectByValue("24");

        //select month
        Select BirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        BirthMonth.selectByValue("8");

        //select year;
        Select BirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        BirthYear.selectByVisibleText("1984");

        //enter email address
//       driver.findElement(By.id("Email")).sendKeys("hetalpatel@gmail.com");
        driver.findElement(By.id("Email")).sendKeys("eeeee" + RandomDate() + "gmail.com");
        typeText(By.id("Email"), "hetalpatel@gmail.com");

        // enter password
//        driver.findElement(By.id("Password")).sendKeys("hetalllll");
        //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("ooooooooo");
        typeText(By.id("Password"), "hetalllll");

        //confirm password
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("hetalllll");
        // driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("ooooooooo");
        typeText(By.id("ConfirmPassword"), "hetalllll");

        ///click register button
        // driver.findElement(By.id("register-button")).click();
        //gettext from(By.id("//button[@id=\"register-button\"]"));
        driver.findElement(By.xpath("//button[@id=\"register-button\"]")).click();


        //click on computer/////////////////////
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        ;

        //clickOn Desktops
        clickOnElement(By.linkText("Desktops"));

        //click on Build own computer
        clickOnElement(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));

//email a friend
        driver.findElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]")).click();
        //email a friend

        driver.findElement(By.xpath("//*[@id=\"FriendEmail\"]")).sendKeys("zzz@yaoo.com");

        //your email address
        driver.findElement(By.xpath("//*[@id=\"YourEmailAddress\"]")).sendKeys("");

        //personal message

        driver.findElement(By.xpath("//*[@id=\"PersonalMessage\"]")).sendKeys("GOOD PRODUCT TO BUY");

        //click on send email Button
        driver.findElement(By.name("send-email")).click();

        //check build own computer verify

        String actualMessage = driver.findElement(By.className("result")).getText();
        String expectedMessage = "Your message has been sent.";
        Assert.assertEquals(actualMessage, expectedMessage, " your message has not been sent");

    }
///////////////////////currency
        @Test
    public void UserShouldBeAbleToChangeCurrency() {
        clickOnElement(By.name("customerCurrency"));
    }
    // public String getTextFromElement(By by) {
    public static String getTexFromElement(By by) {
        driver.findElement(By.xpath("//id=\"customerCurrency\"]")).getText();
        return null;
    }

    ////after method///////////////////////
        @AfterMethod
        public static void closeBrowser(){
            //driver.quit();
            //   System.out.println("finished");
        }


    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    public static String getTextFromElement(By by) {
        driver.findElement(by).getText();

        return null;
    }
        //driver.findElement(by).getText()

        public static String RandomDate () {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
            return formatter.format(date);
        }
        public static void DriverWaitsUntillURLTobe ( int time, String url){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        }

        public static void driverWaitsUntillURLTobeClickable (By by,int time){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }

        public static void driverWait ( int time, String urlFraction){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.urlContains(urlFraction));
        }

        public static void driveWait ( int time, String Attribute, String value, By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.attributeContains(by, Attribute, value));
        }

        public static void driverWaitUrlContains ( int time, By by, String urlName){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.urlContains(urlName));
        }

        public static void DriverWaitSelectElement ( int time, By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        }

        public static void DriverWaitPresenceOfAllElementsLocatedBy ( int time, By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }

        public static void DriverWaitVisibilityOf ( int time, WebElement element){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOf(element));
        }


        public static void DriverWaitUntilInvisibilityOfWebElement ( int time, WebElement element){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOf(element));
        }


        public static void DriverWaitElementToBeSelected ( int time, By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeSelected(by));

        }
        public static void DriverWait ( int time, String name){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.titleIs(name));
        }



//        click register button
//driver.findElement(By.id("register-button")).click();
//clickElement(By.id("register-button"));

//        if (expectedMessage.equals(actualMessage)) {
//            System.out.println("Your Registration is successful");
//        } else {
//            System.out.println("Your Registration is not successful");
//        }
/////int
//int links = driver.findElement(By.tagName("a")).getSize();
//System.out.println(links);

//   click log in
//driver.findElement(By.className("ico-login");
// clickOnElement(By.className("ico-login"));




}
































