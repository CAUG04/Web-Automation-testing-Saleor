# Web-Automation-testing-Saleor
This project is a technical challenge with Serenity BDD Screenplay with Saleor web

**WEB AUTOMATION TESTS:**

The challenge will be to automate the search and addition of products from a virtual store.
Select at least 2 products from different categories and add them to the shopping cart.


**The following URL will be used:**

• URL: https://demo.saleor.io/

Carry out the scenarios and validations that you consider pertinent.


**Table of Contents**  
- [Introduction](#introduction)
- [Testing Serenity](#testing_Serenity)
- [Prerequisites](#prerequisites)
- [Run the tests locally](#run-the-tests-locally)


# Introduction

A project that exemplifies the use of the Serenity [ScreenPlay](https://serenity-bdd.github.io/theserenitybook/latest/screenplay-selenium-tasks.html) pattern with Cucumber and Gradle.

The tests in this example are run on the [Saleor](https://demo.saleor.io/) website.

By default, the tests run in Chrome, so you need to have the latest version of the Chrome driver installed and add it as a variable in the system path.


# Testing Serenity

Serenity provides a large number of built-in Screenplay tasks that make interacting with a web application quicker and easier to write. 
In this chapter, we will look at everything you need to know to write web tests with Serenity Screenplay.

[Serenity Screenplay](https://serenity-bdd.github.io/theserenitybook/latest/screenplay-selenium-tasks.html)


### Prerequisites

The project is developed in Java with Maven so it will install the following software:

* [Oracle Java 8 SDK](https://java.oracle.com)
* [Gradle](https://gradle.org/)
* Your favorite IDE, including :
   * [Intellij IDEA](http://www.jetbrains.com): To run features or scenarios tests it will configure:  
  
  
## Run the tests locally

To try to run the demo in the local system, enter the root folder and execute the following commands to install the dependencies and start up the test runners one by one.

```
.\gradlew.bat clean test aggregate
clean test aggregate is the command that will run the tests and generate the report in the /target/site/serenity/ folder
