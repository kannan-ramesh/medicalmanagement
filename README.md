# Medical Management System

## Overview
The Medical Management System is a console application designed to facilitate the management of medical shops. It allows administrators to add medical branches, manage medicines, view order details, and perform various administrative tasks. Users can interact with the system to browse available branches, explore medicine categories, place orders, and view their order history.

## Project Structure
The project is organized into several packages:
- `com.kannanrameshrk`: Contains the main classes including Main and BaseView.
- `com.kannanrameshrk.dto`: Contains DTO (Data Transfer Object) classes such as Branch, Medicine, Purchase, and User.
- `com.kannanrameshrk.medical`: Contains classes related to medical views and functionalities.
- `com.kannanrameshrk.user`: Contains classes related to user views and functionalities.

## Technologies Used
- Java: Programming language used for application development.
- MySQL: Database management system utilized for storing data.
- ArrayList: Java collection framework used for data manipulation.
- MVVM Pattern: Architectural pattern employed for better code organization.

## Database Tables
### medical_branches
- `id`: int (Primary Key)
- `name`: varchar(255)
- `address`: varchar(255)
- `phoneNumber`: varchar(15)

### medicines
- `id`: int (Primary Key)
- `name`: varchar(255)
- `category`: varchar(100)
- `price`: decimal(10,2)
- `quantity`: int
- `branch_id`: int (Foreign Key)

### purchases
- `id`: int (Primary Key)
- `userId`: int (Foreign Key)
- `medicineId`: int (Foreign Key)
- `dateTime`: datetime
- `quantity`: int
- `totalPrice`: decimal(10,2)
- `branch_id`: int (Foreign Key)

### users
- `id`: int (Primary Key)
- `name`: varchar(100)
- `address`: varchar(200)
- `phoneNumber`: varchar(15)
- `branch_id`: int (Foreign Key)

## POJO Class Attributes
### Branch
- `id`: int
- `name`: String
- `address`: String
- `phoneNumber`: String

### Medicine
- `id`: int
- `name`: String
- `category`: String
- `price`: double
- `quantity`: int
- `branchId`: int

### Purchase
- `id`: int
- `userId`: int
- `medicineId`: int
- `dateTime`: LocalDateTime
- `quantity`: int
- `totalPrice`: double
- `branchId`: int

### User
- `id`: int
- `name`: String
- `address`: String
- `phoneNumber`: String
- `branchId`: int

## Setup Instructions
### Prerequisites
- JDK (Java Development Kit)
- MySQL Database

### Database Setup
1. Create a database named `medicalshop`.
2. Run the SQL script to create the necessary tables.

### Running the Application
1. Compile the Java files.
2. Execute the Main class to start the application.

## Usage
### Admin Interface
- Access the admin interface by providing valid credentials.
- Perform tasks such as adding medical branches, managing medicines, and viewing order details.

### User Interface
- Interact with the user interface to browse available branches, explore medicine categories, place orders, and view order history.
  ### Project Videos
https://drive.google.com/file/d/1YNZlRg4N3J2e0MCvjZVWvx2A_Av6AX56/view?usp=sharing
### Images
https://drive.google.com/file/d/10YQ_EnuZ64QRyaz61RQCHOpKi4bxOLb6/view?usp=sharing
https://drive.google.com/file/d/14KVWnrFCFRpHacTEPAIgcjCeGpxwx6gg/view?usp=sharing
https://drive.google.com/file/d/1Awi5J3TDeaMt_ADZK3b69LTHxt_RXJ7R/view?usp=sharing
https://drive.google.com/file/d/1B2HIavPYZlxHZSNJgNVVqSBShYZPiAYJ/view?usp=sharing
