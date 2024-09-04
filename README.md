# Grade Calculation

Grade Calculation is a console-based application developed using Core Java. It allows users to manage student grades within a school management system. The application provides functionalities for managing students, teachers, courses, and grades, and performs operations such as adding, viewing, updating, and deleting records. Additionally, it calculates the GPA (Grade Point Average) for students based on their grades.

## Key Features:

#### Student Management: Add, view, update, and delete student records.
#### Teacher Management: Manage teacher details with similar CRUD operations.
#### Course Management: Handle courses including assigning teachers to courses.
#### Grade Management: Assign grades to students, view and update grades, and calculate GPA.

## Technologies Used:
### Java: Core Java for backend logic.
### MySQL: Database management to store school data.
### JDBC: Java Database Connectivity for MySQL interaction.

## Challenges and Future Features:
Challenges: Implementing error handling for database connectivity and managing the relationships between different entities like students, teachers, and courses.

## Table of Contents
* Project Description
* Installation and Setup
* Usage
* Credits
* License

## Installation

### Clone the Repository:
* Copy code

```bash
git clone https://github.com/yourusername/grade-calculation.git
```

```bash
cd grade-calculation
```
## Set Up the Database:
* Create a MySQL database named SchoolManagement.
* Run the SQL script provided in the database folder to create the necessary tables.
* Configure Database Connection:

Update the DBUtil.java file in the util package with your MySQL database credentials.
Add MySQL JDBC Driver:

Download the MySQL JDBC Driver from the official MySQL website.
Add the JDBC driver JAR file to your project's classpath.
Compile and Run the Project:

Compile the project using your IDE or through the command line:

```bash
javac -cp .;path/to/mysql-connector-java-x.x.x.jar MyPackage/client/Main.java
```

## Run the project:
```bash
java -cp .;path/to/mysql-connector-java-x.x.x.jar MyPackage/client/Main
```
## Usage

### Running the Application:

Upon starting the application, a menu will be displayed allowing you to perform various operations.
Follow the prompts to manage students, teachers, courses, and grades.

### Example operations:
Add a new student by entering their details.
Assign grades to students and view their GPA.

## Credits
This project was developed by Palak Biswas.

## Acknowledgements:
Special thanks to the open-source community for providing the tools and libraries used in this project.
MySQL for the database management system.
Java Documentation for the comprehensive guides and references.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
