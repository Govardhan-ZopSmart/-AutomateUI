package Page;
import map.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ActionsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ActionsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to handle radio buttons
    public void selectRadioButton() {
        driver.findElement(Locators.radioButton3).click();
    }

    public boolean isRadioButtonSelected() {
        return driver.findElement(Locators.radioButton3).isSelected();
    }

    // Method to handle autocomplete suggestions
    public void selectSuggestion(String text) {
        driver.findElement(Locators.autocompleteTextbox).sendKeys(text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.suggestionIndia)).click();
    }

    public String getSelectedSuggestion() {
        return driver.findElement(Locators.autocompleteTextbox).getAttribute("value");
    }

    // Method to handle dropdowns
    public void selectDropdownOption(String option) {
        Select dropdown = new Select(driver.findElement(Locators.dropdownElement));
        dropdown.selectByVisibleText(option);
    }

    public String getSelectedDropdownOption() {
        return new Select(driver.findElement(Locators.dropdownElement)).getFirstSelectedOption().getText();
    }

    // Method to handle checkboxes
    public void selectCheckbox() {
        driver.findElement(Locators.checkboxOption1).click();
    }

    public boolean isCheckboxSelected() {
        return driver.findElement(Locators.checkboxOption1).isSelected();
    }

    // Method to handle simple alert
    public void handleAlert(String name) {
        System.out.println("Entering name into the textbox...");
        driver.findElement(Locators.nameTextbox).clear();
        driver.findElement(Locators.nameTextbox).sendKeys(name);

        System.out.println("Clicking on alert button...");
        driver.findElement(Locators.alertButton).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        alert.accept();
        System.out.println("Alert accepted successfully.");
    }

    // Method to handle confirm alert
    public void handleConfirmAlert(String name) {
        System.out.println("Entering name into the textbox...");
        driver.findElement(Locators.nameTextbox).clear();
        driver.findElement(Locators.nameTextbox).sendKeys(name);

        System.out.println("Clicking on confirm button...");
        driver.findElement(Locators.confirmButton).click();

        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirm alert text: " + confirmAlert.getText());
        confirmAlert.dismiss();
        System.out.println("Confirm alert dismissed successfully.");
    }

    // Method for Web Table Example
    public String getCoursePrice() {
        return driver.findElement(Locators.courseRow).getText();
    }

    // Method to calculate the total amount in a fixed header table
    public int calculateTableSum() {
        List<WebElement> rows = driver.findElements(Locators.tableRows);
        int sum = 0;
        for (WebElement row : rows) {
            sum += Integer.parseInt(row.findElements(By.tagName("td")).get(3).getText());
        }
        return sum;
    }

    public int getTotalAmount() {
        String totalText = driver.findElement(Locators.totalAmount).getText();
        return Integer.parseInt(totalText.replaceAll("[^0-9]", ""));
    }

    // Method for mouse hover
    public void mouseHoverReload()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Locators.mouseHoverButton)).perform();
        driver.findElement(Locators.reloadLink).click();
    }


    // Combined method for opening a new tab, switching to it, and validating elements
    public void openNewTabAndValidate() throws InterruptedException {
        // Open the new tab
        WebElement openTabButton = driver.findElement(By.id("opentab"));
        openTabButton.click();

        // Switch to the new tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Validate the new tab title
        String expectedTitle = "QAClick Academy - A Testing Academy to Learn, Earn and Shine";
        if (!driver.getTitle().contains(expectedTitle)) {
            throw new AssertionError("The tab title does not match!");
        }

        // Validate that required elements are displayed
        if (!driver.findElement(By.linkText("Home")).isDisplayed() ||
                !driver.findElement(By.linkText("Courses")).isDisplayed() ||
                !driver.findElement(By.linkText("Access all our Courses")).isDisplayed() ||
                !driver.findElement(By.linkText("Learn More")).isDisplayed() ||
                !driver.findElement(By.xpath("//div[@class='apply-cont apply-color-2']/a")).isDisplayed() ||
                !driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Contact']")).isDisplayed() ||
                !driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Blog']")).isDisplayed() ||
                !driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='About us']")).isDisplayed()) {
            throw new AssertionError("Some elements are missing or not displayed!");
        }

        // Optional: Wait for a few seconds before finishing (for visibility of results)
        Thread.sleep(2000);
    }
}
