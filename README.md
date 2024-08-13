# Description

This is a CRUD (Create, Read, Update, Delete) application built with Spring Boot and Java. The application allows you to manage employee records, including their ID, first name, last name, email, department, and salary.

# Setup CRUD Application

First, install VS Code and the required extensions (JDK). Then, go to Spring Initializr and add the following dependencies:

- Thymeleaf
- H2 in-memory database
- MySQL Server
- Spring Web
- JPA

After setting up the dependencies, open the project in VS Code. Connect MySQL Workbench to the CRUD application. Next, create the following folders and files:

- `model` folder: add `Employee.java`
- `repository` folder: add `EmployeeRepository.java`
- `controller` folder: add `EmployeeController.java`

Then, go to the `resources/application.properties` file and add the MySQL connection details. Finally, go to the `templates` folder and add your HTML files.

# Features

- Add a new employee
- View a list of employees
- Update employee details
- Delete an employee

# Fundamentals

- Java Development Kit (JDK) 17
- Apache Maven
- Visual Studio Code (VS Code)
- MySQL Workbench

## Screenshots

![Registration Functionality]("https://github.com/AbidaMemon/CURD_Application-Java/blob/main/CRUDproject%20screenshot/curd%20registration.png")

**Registration** functionality shows  that the registration page where the user can register before accessing the CRUD application.

![CRUD Operation](https://github.com/AbidaMemon/CURD_Application-Java/blob/main/CRUDproject%20screenshot/curd%20operation.png)


**Edit** functionality shows  that the edit employee data in the CRUD application.

![Add Functionality](https://github.com/AbidaMemon/CURD_Application-Java/blob/main/CRUDproject%20screenshot/add.png)

**Add** functionality shows that  the addition of an employee in the CRUD application.

![Edit Functionality](https://github.com/AbidaMemon/CURD_Application-Java/blob/main/CRUDproject%20screenshot/edit.png)

**Edit** functionality shows that  the edit employee data in the CRUD application.
