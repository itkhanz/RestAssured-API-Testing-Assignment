# API Testing with REST Assured [Java]

* This project is a solution for the API Testing assignment and automates API endpoints to validate the
  response.

## Pre-requisites

This project is built and tested with the following dependencies:

* JAVA JDK 17.0.2+ installed and JAVA_HOME in your classpath
* MAVEN 3.9.2+ installed and MAVEN_HOME in your classpath

## Libraries

* [Java 17](https://openjdk.org/projects/jdk/17/) as programming language
* [REST Assured](https://rest-assured.io/) as native app automation library
* [TestNG](https://mvnrepository.com/artifact/org.testng/testng/7.8.0) as testing framework to support the test creation
  and hooks
* [java-faker](https://github.com/DiUS/java-faker) as the faker data generation strategy
* [Log4j2](https://logging.apache.org/log4j/2.x/) as the logging management strategy
* [Owner](https://github.com/matteobaccan/owner) to minimize the code to handle properties files
* [Lombok](https://projectlombok.org/) to reduce the boilerplate and creating POJOs with builder pattern
* [jackson-databind](https://github.com/FasterXML/jackson-databind) to parse the JSON test data
* [Allure TestNG](https://github.com/allure-framework/allure-docs/blob/main/content/frameworks/java/testng.md) TestNG
  adapter for allure reporting
* [Allure rest-assured](https://mvnrepository.com/artifact/io.qameta.allure/allure-rest-assured) Filter for rest-assured
  http client, that generates attachment for allure.

## Running Tests

* Clone the repo
* Open the project `POM.xml` in IDE of your choice and run the maven build that will download and install the required
  dependencies.
    * IntelliJ IDE is recommended.
* Use IDE Terminal or navigate to the project root directory and run following command in terminal:

```shell
mvn clean test
```

* It will run the whole regression suite comprising of 08 test cases split between 2 test classes.
* Results will be available in terminal after the build is finished.

<img src="doc/test-results.PNG" alt="test results">

## Test Reporting

* HTML report is generated by mavens surefire plugin, and is available at `target/surefire-reports/index.html`

### Allure Reports Setup

* Allure Report requires a web server to view the results. If we directly open the index.html file, we won't see any
  reports. To install Allure, first download and install Scoop/brew and then install allure using it.
* Follow the instructions for [Allure Report Installation](https://allurereport.org/docs/gettingstarted/installation/)
    * Install via Homebrew (for macOS and Linux)
        * Make sure Homebrew is installed.
  ```shell
  brew install allure
  ```
    * Install via Scoop (for Windows)
        * Make sure [Scoop](Make sure Scoop is installed.) is installed.
  ```shell
  scoop install allure
  ```
* `allure --version` will show the version of allure downloaded and installed


* Allure HTML report is generated by allure, and is available at `target/allure-results/`
    * To view the allure report, run the command `allure serve target/allure-results` which will open the HTML report in
      your browser.
    * Allure report contains the request and response body as attachment.
        * To populate the request payload, and response body in allure report, we can use the `.filter(new
          AllureRestAssured())` method in our request and response specifications.
    * It also shows the test description, use story, and test steps in the test body.

> Before executing the tests again, stop the allure pressing Ctrl + c.

<img src="doc/allure-behaviors.PNG" alt="allure report">