package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Page.ActionsPage;

import java.time.Duration;

import static org.junit.Assert.*;

public class SeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private ActionsPage actionsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actionsPage = new ActionsPage(driver, wait);
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
    }
    // 1
    @Test
    public void testRadioButton() {
        actionsPage.selectRadioButton();
        assertTrue(actionsPage.isRadioButtonSelected());
    }
    // 2
    @Test
    public void testSuggestion() {
        actionsPage.selectSuggestion("Ind");
        assertEquals("India", actionsPage.getSelectedSuggestion());
    }
    // 3
    @Test
    public void testDropdown() {
        actionsPage.selectDropdownOption("Option2");
        assertEquals("Option2", actionsPage.getSelectedDropdownOption());
    }
    // 4
    @Test
    public void testCheckbox() {
        actionsPage.selectCheckbox();
        assertTrue(actionsPage.isCheckboxSelected());
    }
    // 5
    @Test
    public void testSwitchTab() throws InterruptedException {
        // Perform the combined actions of opening the new tab and validating it
        actionsPage.openNewTabAndValidate();
    }
    // 6
    @Test
    public void testAlertHandling() throws InterruptedException {
        System.out.println("Starting test for alert handling...");
        actionsPage.handleAlert("Gova");
        Thread.sleep(2000);
        actionsPage.handleConfirmAlert("Gova");
        Thread.sleep(2000);
    }
    // 7
    @Test
    public void testCoursePrice() {
        assertEquals("35", actionsPage.getCoursePrice());
    }
    // 8
    @Test
    public void testFixedTableSum() {
        int sum = actionsPage.calculateTableSum();
        int total = actionsPage.getTotalAmount();
        assertEquals("The sum of all amounts should match the total amount.", sum, total);
    }
    // 9
    @Test
    public void testMouseHover() throws InterruptedException {
        actionsPage.mouseHoverReload();
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("AutomationPractice"));
        Thread.sleep(3000);
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
