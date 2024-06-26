# simple Library Management System GUI

## Objective
This Java application is a simple Library Management System that allows users to add and remove books from an inventory. The application uses a graphical user interface (GUI) to interact with the user.

## Features
- Add new books with details such as ISBN, title, author, publisher, and year.
- Remove books from the inventory by selecting it.
- Display the list of books in a table.

## Requirements
- Java Development Kit (JDK) installed.
- IDE or text editor to run the Java application (e.g., IntelliJ IDEA, Eclipse, VS Code).
Code Overview
The LibraryManagementSystemGUI class provides a GUI for managing a library's inventory. The GUI includes labels, text fields, and buttons for adding and removing books, as well as a table to display the current list of books.

## Main Components
- Table: Displays the list of books in the inventory with columns for ISBN, title, author, publisher, and year.
- Input Fields:
ISBN
Title
Author
Publisher
Year
- Buttons:
Add Book: Adds a new book to the inventory.
Remove Book: Removes the selected book from the inventory.
ArrayList of Books: Stores the book objects.
## Error Handling
Ensures that ISBNs are unique when adding new books.
Displays error messages for invalid operations such as attempting to remove a book without selecting a row.
## Usage
- Add a Book:
Enter the book details (ISBN, title, author, publisher, and year) in the respective fields.
Click the "Add Book" button to add the book to the inventory. A success message will be displayed.
- Remove a Book:
Select a row in the table.
Click the "Remove Book" button to remove the selected book from the inventory. A success message will be displayed.
