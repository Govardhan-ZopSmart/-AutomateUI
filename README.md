# Selenium UI Testing Automation

## Introduction
This project demonstrates the use of Selenium WebDriver for automating UI tests. The goal is to automate test cases on various web elements, such as radio buttons, dropdowns, checkboxes, tables, alerts, and mouse hover actions on a sample website.

## Features
- Automates UI testing using Selenium WebDriver.
- Tests include handling radio buttons, dropdowns, checkboxes, web tables, alerts, and mouse hover actions.
- Handles multiple scenarios like element selection, form inputs, and table data validation.
- Detailed test execution reports can be generated.
- Integrated with JUnit for test execution and validation.

## Prerequisites
- **Java JDK** (version 8 or higher)
- **Maven** for managing dependencies
- **Selenium WebDriver** and **ChromeDriver**
- **IDE**: IntelliJ IDEA (or any IDE with Maven support)
- **Git** for version control

## Installation and Setup
1. Clone the repository from GitHub:
   ```bash
   git add origin https://github.com/Govardhan-ZopSmart/-AutomateUI.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Automating-UI-Testing
   ```

3. Install Maven dependencies:
   ```bash
   mvn clean install
   ```

4. Set up the correct path for **ChromeDriver** on your system. Update the path in the `setup` method:
   ```java
   System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
   ```


## Project Structure

```
selenium-ui-testing
 ├── src
 │   └── test
 │       └── java
 │           └── SeleniumTest.java         # Main test class with multiple test cases
 ├── target                               # Output folder for compiled code and test results
 ├── pom.xml                              # Maven configuration file
 └── README.md                            # Documentation
```

## Test Scenarios
Here are some examples of test scenarios automated in the project:

1. **Radio Button Selection**  
   Select and verify if the correct radio button is selected.
   ```java
   @Test
   public void testRadioButton() { ... }
   ```

2. **Suggestion Dropdown**  
   Type a partial input and select from the suggestions.
   ```java
   @Test
   public void testSuggestionClass() { ... }
   ```

3. **Dropdown Selection**  
   Select an option from a dropdown and verify the selection.
   ```java
   @Test
   public void testDropdownSelection() { ... }
   ```

4. **Checkbox Selection**  
   Select a checkbox and validate if it's checked.
   ```java
   @Test
   public void testCheckboxSelection() { ... }
   ```

5. **Web Table Price Validation**  
   Validate that the price of a specific course matches the expected value.
   ```java
   @Test
   public void testCoursePrice() { ... }
   ```

6. **Mouse Hover Action**  
   Perform a mouse hover action and select an option from the hover menu.
   ```java
   @Test
   public void testMouseOver() { ... }
   ```

7. **Switching Tabs**  
   Open a new tab, switch to it, and verify the new tab's content.
   ```java
   @Test
   public void switchTab() { ... }
   ```

8. **Handling Alerts**  
   Handle JavaScript alerts and confirmations.
   ```java
   @Test
   public void testAlert() { ... }
   ```


### Execution Result

The Execution Result can be found in the output or console log after running the test suite, typically indicating whether each test passed, failed, or was skipped.

---

