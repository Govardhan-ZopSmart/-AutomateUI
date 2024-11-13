package map;

import org.openqa.selenium.By;

public class Locators {
    // 1. Radio Button Example
    public static final By radioButton3 = By.xpath("//input[@value='radio3']");

    // 2. Suggestion Class Example
    public static final By autocompleteTextbox = By.id("autocomplete");
    public static final By suggestionIndia = By.xpath("//div[contains(@class, 'ui-menu-item-wrapper') and text()='India']");

    // 3. Dropdown Example
    public static final By dropdownElement = By.id("dropdown-class-example");

    // 4. Checkbox Example
    public static final By checkboxOption1 = By.id("checkBoxOption1");



    // 6. Switch To Alert Example
    public static final By nameTextbox = By.id("name");
    public static final By alertButton = By.id("alertbtn");
    public static final By confirmButton = By.id("confirmbtn");

    // 7. Web Table Example
    public static final By courseRow = By.xpath("//td[text()='Master Selenium Automation in simple Python Language']/following-sibling::td[1]");

    // 8. Web Table Fixed Header Example
    public static final By tableRows = By.xpath("//div[@class='tableFixHead']/table[@id='product']/tbody/tr");
    public static final By totalAmount = By.className("totalAmount");

    // 9. Mouse Hover Example
    public static final By mouseHoverButton = By.id("mousehover");
    public static final By reloadLink = By.xpath("//a[text()='Reload']");


    // 5. Switch Tab Example
    public static final By openTabButton = By.id("opentab");
    public static final By homeLink = By.linkText("Home");
    public static final By coursesLink = By.linkText("Courses");
    public static final By accessCoursesLink = By.linkText("Access all our Courses");
    public static final By learnMoreLink = By.linkText("Learn More");
    public static final By applyNowButton = By.xpath("//div[@class='apply-cont apply-color-2']/a");
    public static final By contactLink = By.xpath("//li[@class='nav-item']/a[text()='Contact']");
    public static final By blogLink = By.xpath("//li[@class='nav-item']/a[text()='Blog']");
    public static final By aboutUsLink = By.xpath("//li[@class='nav-item']/a[text()='About us']");
}
