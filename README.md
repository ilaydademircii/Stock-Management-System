# Stock Management System Using Java Swing and MySQL

## About the Project

This project is a **Stock Management System** developed using **Java Swing** and **MySQL**, following the **Model-View-Controller (MVC)** architectural pattern and incorporating the **Command Design Pattern** for modularity and maintainability.

The system is designed to support companies in efficiently managing their inventory through the creation and maintenance of different types of cards:

* **Stock Type Cards**
* **VAT Type Cards**
* **Stock Cards**

By linking these cards together, the system enables powerful inventory tracking, data visualization, and reporting features.

## Features

* **Card Management:**

  * Create and manage **Stock Type Cards**
  * Create and manage **VAT Type Cards**
  * Create and manage **Stock Cards** that reference the above card types

* **Navigation:**

  * Navigate between records using next/previous buttons for better UX

* **Database Operations (via SQL):**

  * Add, delete, update, and list records for all card types
  * All data is stored in a **MySQL** relational database

* **Contextual Stock Card Access:**

  * Open a specific stock card directly from the list via right-click context menu

* **Reporting and Export:**

  * View the combined Stock Card data with related card details using **JasperReports**
  * Export the report to an **Excel file**
  * Generate a **PDF** report and **send it via email**

## Technologies Used

* Java (Swing for GUI)
* MySQL
* JDBC
* MVC Architecture
* Command Design Pattern
* JasperReports
* Apache POI (for Excel export)
* JavaMail (for sending reports via email)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ilaydademircii/Stock-Management-System.git
   ```

2. **Import the project into your IDE**
   (e.g., IntelliJ IDEA or Eclipse)

3. **Configure your MySQL database:**

   * Create a database
   * Run the provided SQL scripts to create necessary tables
   * Update DB connection settings (URL, username, password) in the source code

4. **Build and run the project**

## Usage

* Launch the application and start by creating **Stock Type Cards** and **VAT Type Cards**
* Use those cards while creating **Stock Cards**
* Navigate easily between cards using navigation buttons
* Right-click any stock card in the list to open it directly
* View comprehensive stock data using JasperReports
* Export reports as Excel or PDF
* Email reports directly from within the application

## Architecture

This application is structured around:

### Model-View-Controller (MVC)

* **Model:** Handles business logic and database operations
* **View:** Manages the GUI using Java Swing
* **Controller:** Connects user interactions to business logic

### Command Design Pattern

* Encapsulates actions such as save, delete, and update into reusable command objects, enhancing flexibility and code reusability

## Contributing

Contributions are welcome!
Feel free to fork the repository, submit improvements, or open issues.
