
<p style="text-align: center"><img src="assets/Vicarius%20logo.png"></p>
<h1 style="text-align: center;">Vicarius.io Selenium Java Testing Demo</h1>

## Introduction
This project uses Selenium with the TestNG framework in a Page Object Model (POM) design pattern. The project tests the UI, functionality and network traffic associated with user actions of the vicarius.io website.

![Vicarius](assets/Vicarius%20product.png "Vicarius Product")

## Setup
1. **Prerequisites**: Ensure you have Java & Maven properly installed on your machine.
2. **Clone the repository**: Clone this repository to your local machine.
3. **Install dependencies**: Run `mvn install` to install all necessary dependencies.

## Running Tests
Tests can be run directly within the IDE using a Java Test runner extension or by running `mvn test` in the terminal command line from the project root. 

## Vicarius pages tested

* Sign in page ![Vicarius](assets/Vicarius%20sign%20in.png "Vicarius Product")
* Sign up page ![Vicarius](assets/Vicarius%20sign%20up.png "Vicarius Product")
* Product page ![Vicarius](assets/Vicarius%20product.png "Vicarius Product")

## Reporting
The project uses Allure reports, providing a clear and comprehensive representation of test execution output. Screenshots and video recording of failed tests are also available. TestNG also produces reports in the `/target/surefire-reports` folder.