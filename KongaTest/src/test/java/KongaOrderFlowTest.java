import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaOrderFlowTest {

    //import selenium webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {

        //locate chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        driver = new ChromeDriver();

        //2. Input the Konga URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");

//Test 1:Verify that the user entered the right URL and is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Webpage");

        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(10000);

        //3.maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Maximise browser");
    }

    @Test (priority = 0)
    public void login() throws InterruptedException {
        // LOGIN
        //4. click on the login/signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(10000);
        System.out.println("Click login/signup button");

        //5. locate the email field and enter a valid email address
        driver.findElement(By.id("username")).sendKeys("wizkid@mailinator.com");

        //6. locate the password field and enter a valid password
        driver.findElement(By.id("password")).sendKeys("wizkid12$");

        //7. click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(8000);
        System.out.println("Click login button");

    }
    @Test (priority = 1)
    public void selectitem() throws InterruptedException {
        // SELECT FROM CATEGORIES
        //8. click on computer and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(15000);
        System.out.println("Click computer and accessories");

        //9. click on laptops
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(19000);
        System.out.println("Click on laptops");

        // Iframe popup
        // locate the Iframe
        WebElement Iframepopup = driver.findElement(By.tagName("iframe"));

// Switch focus to Iframe
        driver.switchTo().frame("preview-notification-frame");

// Click on the close button
        WebElement closeiframebutton = driver.findElement(By.id("NC_CLOSE_ICON"));
        closeiframebutton.click();

// Switch out of Iframe
        driver.switchTo().defaultContent();
        Thread.sleep(3000);


        //10. click on Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(15000);
        System.out.println("Click on Apple MacBook");

        //11. select item by clicking add to cart beneath the item
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println("Click add to cart");

        //12. click on my cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(7000);
        System.out.println("Click my cart");

        //13. click continue to check out
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(8000);
        System.out.println("Click checkout");
    }

    @Test (priority = 2)
    public void selectaddress() throws InterruptedException {

        // SELECT ADDRESS

        //14. click on change button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);

        //15. Click on add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(6000);
        System.out.println("Click add delivery");

        //16. Select address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
        System.out.println("Select the address");

        //17. Click on use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        // SELECT PAYMENT OPTION

        //18. click on pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(3000);

        //19. click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
        System.out.println("Continue to make payment");
    }

    @Test (priority = 3)
    public void selectpaymentmethod() throws InterruptedException {

        // SELECT PAYMENT METHOD ON IFRAME

        //20. locate the iframe
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        //21. Switch focus to iframe
        driver.switchTo().frame("kpg-frame-component");

        //22. Click on card
        WebElement card = driver.findElement(By.className("Card"));
        card.click();
        Thread.sleep(8000);
        System.out.println("Select card payment");

        // ENTER CARD DETAILS

        //23. locate the card number field and enter invalid card number
        WebElement cardnumberfield = driver.findElement(By.id("card-number"));
        cardnumberfield.sendKeys("4105622231003211");
        System.out.println("Input invalid card details");

        //24. locate the date field and enter date
        WebElement datefield = driver.findElement(By.id("expiry"));
        datefield.sendKeys("0523");

        //25. locate the cvv field and enter the cvv number
        WebElement cvvfield = driver.findElement(By.id("cvv"));
        cvvfield.sendKeys("173");

        //26. print the error message
        WebElement errormessage = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(errormessage.getText());

        //27. close the iframe that displays the input card modal
        WebElement closeiframe = driver.findElement(By.className("data-card__close"));
        closeiframe.click();
        System.out.println("Close the iframe modal");

        //28. switch out of iframe
        driver.switchTo().defaultContent();

        //29. quit the browser
        driver.quit();
        System.out.println("Quit the browser");

    }

}
