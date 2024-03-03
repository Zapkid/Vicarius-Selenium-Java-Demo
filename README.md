
![Vicarius](assets/Vicarius%20logo.png "Vicarius Logo")
# Vicarius.io Selenium Java Testing Demo

## Introduction
This project demonstrates UI & functionality testing of the Vicarius.io website using Selenium, TestNG, and Allure frameworks.The project is built using the Page Object Model (POM) design pattern for maintainable and scalable test automation.

The framework includes the following layers:

* Pages - Contains page object classes that represent web pages under test. Encapsulates access to page elements.

* Tests - Contains test classes with test methods to validate functionality.

* Extensions - Contains reusable classes for common test actions and assertions.

* Utilities - Contains helper classes for setup, driver management, listeners etc.

* Workflows - Contains methods to execute common end-to-end user workflows.

Tests are executed across core user flows like sign up, sign in, and product interactions. The framework verifies UI elements, texts, network calls to validate functionality and business logic.

## Setup
1. **Prerequisites**: Ensure you have [Java JDK 8+](https://www.oracle.com/il-en/java/technologies/downloads/#jdk21-windows), [Apache Maven 3.6+](https://maven.apache.org/download.cgi) & **Optional** [Allure Report](https://github.com/allure-framework/allure2/releases) properly installed on your machine. Ensure Environment variables are set up for the following:
    * JAVA_HOME - `path/to/java/jdk`
    * Path - `path/to/apache-maven/bin` & **Optional** `path/to/allure/bin`
2. **Clone the repository**: Clone this repository to your local machine using `git clone https://github.com/Zapkid/Vicarius-Selenium-Java-Demo.git`.
3. **Install dependencies & Run tests**: Run `mvn clean install -P Web` to install all necessary dependencies to your local machine & run the Web tests suite.

## Running Tests
Run `mvn -P Web` to run the Web tests suite.
Once the browser opens, tests will execute across the Vicarius.io webpages under test, Logs will be recorded to the terminal & test results will be recorded in the `allure-results` folder.
More test suites can be added to the project by creating new profiles in the `pom.xml` file, and configuring the test suite in a new TestNG xml file.

## Vicarius pages tested

* Sign in page ![Vicarius sign in](assets/Vicarius%20sign%20in.png "Vicarius Sign In page")
* Sign up page ![Vicarius sign up](assets/Vicarius%20sign%20up.png "Vicarius Sign Up page")
* Product page ![Vicarius product](assets/Vicarius%20product.png "Vicarius Product")

## Reporting
The project uses Allure reports, providing a clear and comprehensive representation of test execution output. 
Run `allure generate --clean` in the terminal to generate a HTML report after test execution in `allure-report` folder.

![Allure report overview](assets/Allure%20report%20overview.png "Vicarius tests overview")
![Allure report test breakdown](assets/Allure%20report%20valid%20sign%20in.png "Vicarius Valid Sign in test breakdown")

Screenshots and video recordings of failed tests are also available to help with debugging. Additional reports can be found in the `/target/surefire-reports` folder, including jUnit reports with test duration and status.

## Test Coverage
#### Sign In Page Tests:
* Tests valid, invalid, empty, and unrecognized email sign in flows
* Verifies sign in error texts, notifications, input field style change
* Checks elements visibility, text, styles
* Checks Features and FAQ content
  
#### Sign Up Page Tests:
* Tests valid sign up flow including password complexity requirements
* Verifies sign up error texts, notifications, input field style change
* Verifies elements visibility, text, styles
* Checks Features and FAQ content

#### Product Page Tests:
* Verify product demo video is played
* Verify elements visibility & text

#### Overlay Tests:
* Opens and closes chat widget
* Tests mouse cursor style changes on move

##### TODOs:
* Improve mouse cursor test to cover full UX
* Add chat widget interactions
* Fix - asserting on network traffic on different browsers than chrome
* Expand test coverage on Product page
* **Add E2E test to sign up with a Gmail account, access the verification link with Gmail API & complete a successful sign in.**
  
#### Bugs found:
* On Product page, when video is started (can be reproduced):
1. Cursor blue circle effect can get stuck inside the video player.
2. Chat widget launcher & welcome message block access to the bottom right corner video player options.
3. The play Invaders button slightly overlaps with the video player pause button. Gets worse when button is accidentally hovered when trying to hit the pause button.

![Bugs](assets/Bugs%201%202%203.png "Vicarius Product page bugs 1, 2 & 3")
![Bug 3](assets/Bug%203.png "Vicarius Product page bug 3")

## Future Improvements
* Integrate with CI/CD pipeline for automated testing
* Report summary sent to Slack on a dedicated channel
* Implement integration to link automated tests with test cases in a test management platform
* Implement data-driven tests using TestNG DataProvider
* Parameterize selectors to reduce duplication across page object classes
* Add API testing for backend validation
* Add Mobile testing
* Automate winning Invaders game :)

![Invaders win](assets/Invaders%20win.png "Vicarius Invaders win")


## Contributing

Contributions to the project are welcome! To contribute:

1. Fork the repository
2. Create a new branch
3. Make changes and test
4. Submit a pull request

### Estimated time worked on the project (hrs):
~ 25 hrs