import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Alert;

import java.util.ArrayList;
import java.util.List;


public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    }


    // 1. Radio Button Example
    //Click on Radio3 button and verify whether it is selected.
    @Test
    public void testRadioButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='radio3']")));
        radioButton3.click();
        assertTrue("Radio3 is not selected.",radioButton3.isSelected());
        Thread.sleep(2000);
    }


    // 2. Suggestion Class Example
    //Type Ind in the textbox, and select India from the options. Verify if India is populated
    //in textbox.
    @Test
    public void testSuggestionClass() throws InterruptedException {
        WebElement autocompleteTextbox = driver.findElement(By.id("autocomplete"));
        autocompleteTextbox.sendKeys("Ind");
        Thread.sleep(2000);
        WebElement suggestion = driver.findElement(By.xpath("//div[contains(@class, 'ui-menu-item-wrapper') and text()='India']"));
        suggestion.click();
        String selectedValue = autocompleteTextbox.getAttribute("value");
        assertEquals("India", selectedValue);
    }

    // 3. Dropdown Example
    //Select Option2 from dropdown and verify whether Option2 is displayed in
    //Dropdown.
    @Test
    public void testDropdownSelection() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Option2");
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        assertEquals("Option2", selectedText);
        Thread.sleep(2000);
    }

    // 4. Checkbox Example
    //Select Option1 checkbox. Verify if it got checked.
    @Test
    public void testCheckboxSelection() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        assertTrue("Option 1 checkbox should be selected", checkbox.isSelected());
        Thread.sleep(2000);
    }
    //  7. Web Table Example
    //Write a test to verify if the price of the course 'Master Selenium Automation in
    //simple Python Language' is 35. (Test should fail if its other than 35)
    @Test
    public void testCoursePrice() throws InterruptedException {
        WebElement courseRow = driver.findElement(By.xpath("//td[text()='Master Selenium Automation in simple Python Language']/following-sibling::td[1]"));
        String coursePrice = courseRow.getText();
        assertEquals("It has to give 35, but the result is: " + coursePrice, "35", coursePrice);
        Thread.sleep(2000);
    }

    // 9. Mouse Hover Example
    //Hover the Mouse Hover button (DO NOT CLICK) and select Reload.
    @Test
    public void testMouseOver() throws InterruptedException {
        WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverButton).perform();
        Thread.sleep(2000);
        WebElement reloadLink = driver.findElement(By.xpath("//a[text()='Reload']"));
        reloadLink.click();
        String currentUrl = driver.getCurrentUrl();
        assertTrue("Page should reload after clicking 'Reload'", currentUrl.contains("AutomationPractice"));
        Thread.sleep(2000);
    }

    //6. Switch To Alert Example
    //a. Enter your name in textbox
    //b. Click on Alert button and accept the alert
    //c. Click on confirm button and cancel the alert
    @Test
    public void testAlert() throws InterruptedException {
        WebElement textbox = driver.findElement(By.id("name"));

        //a. Enter your name in textbox
        textbox.sendKeys("Gova");

        //b. Click on Alert button and accept the alert
        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert1.accept();

        //c. Click on confirm button and cancel the alert
        textbox.sendKeys("Gova");
        WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
        confirmButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert2.dismiss();
    }

//    8. Web Table Fixed header
//    Write a test to all all the amounts. Verify if the total matches with the 'Total Amount
//    Collected' value.
    @Test
    public void totalAmount() throws InterruptedException{
        var table = driver.findElement(By.xpath("//div[@class='tableFixHead']/table[@id='product']/tbody"));
        var rows =table.findElements(By.tagName("tr"));
        int sum = 0;
        for(var row:rows) {
            var cells = row.findElements(By.tagName("td"));
            sum +=Integer.parseInt(cells.get(3).getText());
        }
        String totalS = driver.findElement(By.className("totalAmount")).getText();
        int total = Integer.parseInt(totalS.replaceAll("[^0-9]", ""));
        String errorMessage = "The sum is '" + sum + "' but the total amount is '" + total + "'";

        // Use assertEquals with the correct number of parameters
        assertEquals(errorMessage, sum, total);
        Thread.sleep(2000);
    }

    // 5. Switch Tab Example
    //a. Click Open Tab button
    //b. Verify whether the following buttons are displayed :
    //i. Home
    //ii. Courses
    //iii. Access All our Courses
    //iv. Learn More
    //v. Apply Now
    //vi. Contact
    //vii. Blog
    //viii. About us
    @Test
    public void switchTab() throws InterruptedException {
        driver.findElement(By.id("opentab")).click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //validate the new tab
        String expectedTitle = "QAClick Academy - A Testing Academy to Learn, Earn and Shine";
        assertTrue(driver.getTitle().contains(expectedTitle));

        assertTrue(driver.findElement(By.linkText("Home")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Courses")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Access all our Courses")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Learn More")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//div[@class='apply-cont apply-color-2']/a")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Contact']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Blog']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='About us']")).isDisplayed());
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
