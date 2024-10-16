import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals; // Import for assertEquals
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); // Update the path

        // Initialize ChromeDriver and WebDriverWait
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the specified URL
            driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

            // Call the methods to test
            testRadioButton(driver);
            testSuggestionClass(driver); // Add the call to testSuggestionClass

        } catch (Exception e) {
            e.printStackTrace(); // Print any exception that occurs
        }
//        finally {
//            // Close the browser
//            driver.quit(); // Ensure the driver is closed to free up resources
//        }
    }

    private static void testRadioButton(WebDriver driver) {
        // Locate the radio button using its value attribute
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='radio3']"));

        // Click on Radio3 button
        radioButton.click();

        // Assertion to verify if the button is selected
        assertTrue("Radio3 button should be selected", radioButton.isSelected());

        // Print success message
        System.out.println("Radio3 button is successfully selected.");
    }

    private static void testSuggestionClass(WebDriver driver) throws InterruptedException {
        // Locate the autocomplete textbox
        WebElement autocompleteTextbox = driver.findElement(By.id("autocomplete"));
        autocompleteTextbox.sendKeys("Ind");
        Thread.sleep(2000); // Consider using WebDriverWait instead

        // Locate and click on the suggestion
        WebElement suggestion = driver.findElement(By.xpath("//div[contains(@class, 'ui-menu-item-wrapper') and text()='India']"));
        suggestion.click();

        // Verify if the value "India" is populated in the textbox
        String selectedValue = autocompleteTextbox.getAttribute("value");
        assertEquals("India", selectedValue);
        System.out.println("Selected value in the autocomplete textbox is: " + selectedValue); // Print the selected value
    }
}
