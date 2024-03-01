
![Vicarius](assets/Vicarius%20logo.png "Vicarius Logo")
# Vicarius.io Selenium Java Testing Demo

## Introduction
This project uses Selenium with the TestNG framework in a Page Object Model (POM) design pattern. The project tests the UI, functionality and network traffic associated with user actions of the vicarius.io website. 

## Setup
1. **Prerequisites**: Ensure you have [Java JDK 8+](https://www.oracle.com/il-en/java/technologies/downloads/#jdk21-windows), [Apache Maven 3.6+](https://maven.apache.org/download.cgi) & **Optional** [Allure Report](https://github.com/allure-framework/allure2/releases) properly installed on your machine. Ensure Environment variables are set up for the following:
    * JAVA_HOME - `path/to/java/jdk`
    * Path - `path/to/apache-maven/bin` & **Optional** `path/to/allure/bin`
2. **Clone the repository**: Clone this repository to your local machine using `git clone https://github.com/Zapkid/Vicarius-Selenium-Java-Demo.git`.
3. **Install dependencies & Run tests**: Run `mvn clean install -P Web` to install all necessary dependencies to your local machine & run the Web tests suite.

## Running Tests
Once the browser opens, tests will execute across the Vicarius.io webpages under test, Logs will be recorded to the terminal & test results will be recorded in the `allure-results` folder.

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
* Verifies sign in error texts, notifications, input field styles
* Checks elements visibility, text, styles on sign in page
* Tests mouse cursor style changes
* Opens and closes chat widget

#### Sign Up Page Tests:
* Tests valid sign up flow
* Verifies elements visibility, text, styles on sign up page
* Checks features and FAQ content
* Tests mouse cursor style changes
* Opens and closes chat widget

#### Product Page Tests:
* 

##### TODOs:
* Improve mouse cursor test to cover full UX
* Add chat widget interactions
* Fix - asserting on network traffic on different browsers than chrome
* **Add E2E test to sign up with a Gmail account, access the verification link with Gmail API & complete a successful sign in.**
  

## Future Improvements
* Integrate with CI/CD pipeline for automated testing
* Report summary sent to Slack on a dedicated channel
* Implement integration to link automated tests with test cases in a test management platform
* Implement data-driven tests using TestNG DataProvider
* Parameterize selectors to reduce duplication across page object classes
* Add API testing for backend validation
* Add Mobile testing