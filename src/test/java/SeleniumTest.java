import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals; // Import for assertEquals
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); // Update the path


        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


            testRadioButton(driver);
            testSuggestionClass(driver);
            testDropdownSelection(driver);
            testCheckboxSelection(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//
//            driver.quit();
//        }
    }

    private static void testRadioButton(WebDriver driver) {
        // Locate the radio button using its value attribute
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='radio3']"));


        radioButton.click();


        assertTrue("Radio3 button should be selected", radioButton.isSelected());


        System.out.println("Radio3 button is successfully selected.");
    }

    private static void testSuggestionClass(WebDriver driver) throws InterruptedException {

        WebElement autocompleteTextbox = driver.findElement(By.id("autocomplete"));
        autocompleteTextbox.sendKeys("Ind");
        Thread.sleep(2000);


        WebElement suggestion = driver.findElement(By.xpath("//div[contains(@class, 'ui-menu-item-wrapper') and text()='India']"));
        suggestion.click();


        String selectedValue = autocompleteTextbox.getAttribute("value");
        assertEquals("India", selectedValue);
        System.out.println("Selected value in the autocomplete textbox is: " + selectedValue); // Print the selected value
    }
    private static void testDropdownSelection(WebDriver driver) {

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));

        // Create a Select object to interact with the dropdown
        Select dropdown = new Select(dropdownElement);

        // Select "Option2" from the dropdown using visible text
        dropdown.selectByVisibleText("Option2");

        // Get the selected option and verify that it is "Option2"
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        assertEquals("Option2", selectedText);

        // Print the selected value
        System.out.println("Selected option in the dropdown is: " + selectedText);
    }
    private static void testCheckboxSelection(WebDriver driver){
        WebElement checkbox= driver.findElement(By.id("checkBoxOption1"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        assertTrue("Option 1 checkbox should be selected", checkbox.isSelected());


    }

}
