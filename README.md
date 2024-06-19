# Smart Campus Project
## Overview
This project is designed to showcase various landmarks and spots within a campus or smart city environment. It provides information about schools, hostels, recreational spots, food spots, and key locations, fetched from a MySQL database.

## Features
- **User Signup and Login**
- **Password validation and confirmation**
- **Basic form validation and error handling**
- **Schools**: Displays information about schools including contact details.
- **Hostels**: Shows details about hostels including type, rating, and curfew timings.
- **Recreational Spots**: Provides information about recreational spots including ratings.
- **Food Spots**: Displays details about food spots including cuisine type, rating, and timings.
- **Key Locations**: Shows details about key locations including the type of location.
## Technologies Used
- **Java**
- **MySQL**
- **JDBC for database connectivity**
- **Swing for GUI components**
## Requirements
- **Java Development Kit (JDK)**
- **MySQL database**
- **MySQL Connector/J**
- **Java Swing library**
## Setup Instructions
### Database Setup:

1. Create a MySQL database named smartcity.
2. Import the provided SQL script (smartcity.sql) to create the necessary tables and populate them with sample data.
## IDE Setup:

1. Import the Java project into your preferred IDE (Eclipse, IntelliJ IDEA, etc.).
Library Dependencies:

2. Ensure the MySQL Connector/J library is added to your project build path.
## Configuration:

- Modify the Actions.java file:
- Update the JDBC_URL, USERNAME

To create a README file for your GitHub project based on the provided Java code, follow these steps. This README will outline the purpose of the project, how to set it up, and how to use it.

Project Name
Provide a concise title or description for your project.

Table of Contents
Introduction
Features
Technologies Used
Setup Instructions
Usage
Examples
Contributing
License
Introduction
Briefly describe what your project does and its objectives. Mention its scope and any key features.

Features
List the main features or functionalities that your project offers. For example:

Display information about schools, hostels, recreational spots, food spots, and key locations.
Connects to a MySQL database to fetch data dynamically.
Technologies Used
Outline the key technologies and libraries used in your project. For example:

Java
JDBC for MySQL connectivity
Swing for GUI components
Setup Instructions
Provide step-by-step instructions on how to set up your project locally. Include prerequisites and installation steps. For example:

Clone the repository:

bash
Copy code
git clone https://github.com/your-username/your-repository.git
cd your-repository
Set up MySQL database:

Create a MySQL database named smartcity.
Import the schema from smartcity.sql located in the repository.
Configure database credentials:

Open the project in your preferred IDE.
Navigate to Actions.java.
Modify the JDBC_URL, USERNAME, and PASSWORD constants according to your MySQL setup.
##Usage
Explain how to use your application. Provide examples or instructions for interacting with different features. For example:

- **Clicking on a School:**

- Retrieves school details from the database based on the selected ID.
-Opens a detailed view of the school including its description, facilities, and contact information.
- **Clicking on a Hostel**:

- Fetches hostel details such as type, rating, and curfew timings.
- Displays these details in a separate window for user 

# Images
## Signup Page
![Image Alt text]()
## Login Page
![Image Alt text]()
## Display Page
![Image ALt text]()
## Information Display Page
![Image Alt text]()
