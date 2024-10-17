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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testRadioButton() throws InterruptedException {
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='radio3']"));
        radioButton.click();
        assertTrue("Radio3 button should be selected", radioButton.isSelected());
        Thread.sleep(2000);
    }

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

    @Test
    public void testCheckboxSelection() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        assertTrue("Option 1 checkbox should be selected", checkbox.isSelected());
        Thread.sleep(2000);
    }

    @Test
    public void testCoursePrice() throws InterruptedException {
        WebElement courseRow = driver.findElement(By.xpath("//td[text()='Master Selenium Automation in simple Python Language']/following-sibling::td[1]"));
        String coursePrice = courseRow.getText();
        assertEquals("It has to give 25, but the result is: " + coursePrice, "25", coursePrice); // Updated expected price
        Thread.sleep(2000);
    }

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



    @After
    public void tearDown() {
        driver.quit();
    }
}
