
![Vicarius](assets/Vicarius%20logo.png "Vicarius Product")
# Vicarius.io Selenium Java Testing Demo

## Introduction
This project uses Selenium with the TestNG framework in a Page Object Model (POM) design pattern. The project tests the UI, functionality and network traffic associated with user actions of the vicarius.io website.

## Setup
1. **Prerequisites**: Ensure you have Java 8+ & Maven 3.6+ properly installed on your machine.
2. **Clone the repository**: Clone this repository to your local machine using `git clone`.
3. **Download dependencies**: Run `mvn dependency:resolve` to download all necessary dependencies to your local machine.

## Running Tests
Tests can be run directly within the IDE using a Java Test runner extension or by running `mvn test` in the terminal command line from the project root. 

## Vicarius pages tested

* Sign in page ![Vicarius](assets/Vicarius%20sign%20in.png "Vicarius Product")
* Sign up page ![Vicarius](assets/Vicarius%20sign%20up.png "Vicarius Product")
* Product page ![Vicarius](assets/Vicarius%20product.png "Vicarius Product")

## Reporting
The project uses Allure reports, providing a clear and comprehensive representation of test execution output. Screenshots and video recordings of failed tests are also available to help with debugging. Additional reports can be found in the `/target/surefire-reports` folder.

### Future Improvements
* Integrate with CI/CD pipeline for automated testing
* Report summary sent to Slack on a dedicated channel
* Implement integration to link automated tests with test cases in a test management platform
* Implement data-driven tests using TestNG DataProvider
* Parameterize selectors to reduce duplication across page object classes
* Add API testing for backend validation on top of UI tests