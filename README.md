# Library Management System

A console-based **Library Management System** developed using **Java** to demonstrate Object-Oriented Programming concepts.  
This project is suitable for beginner Java practice, internship portfolios, and QA/automation learning foundations.

## Project Overview

The system allows users to manage a small library through a console menu. It supports viewing library items, viewing members, searching books, borrowing books, returning books, and checking borrow history.

The main goal of this project is to show clean Java OOP design using separate classes, inheritance, abstraction, encapsulation, polymorphism, interfaces, enums, collections, and custom exception handling.

## Features

- View all library items
- View all members
- Search items by title
- Borrow a library item
- Return a library item
- View borrow history
- Handle invalid actions with custom exceptions
- Support both physical books and e-books

## OOP Concepts Used

| OOP Concept | Implementation |
|---|---|
| Encapsulation | Private fields with public getter methods in classes like `Book`, `Member`, and `BorrowRecord` |
| Abstraction | `LibraryItem` is an abstract class for common item details |
| Inheritance | `Book` and `EBook` extend `LibraryItem` |
| Polymorphism | `Book` and `EBook` override methods such as `getItemType()` and `getBasicDetails()` |
| Interface | `Borrowable` defines borrowing and returning behavior |
| Enum | `BookStatus` manages item status as `AVAILABLE` or `BORROWED` |
| Exception Handling | `LibraryException` handles library-specific errors |
| Collections | `ArrayList` stores items, members, and borrow records |

## Project Structure

```text
LibraryManagementSystem/
  src/
    com/
      library/
        Main.java
        Library.java
        LibraryItem.java
        Borrowable.java
        Book.java
        EBook.java
        Member.java
        BorrowRecord.java
        BookStatus.java
        LibraryException.java
  README.md
  .gitignore
```

## File Descriptions

### `Main.java`

The entry point of the application.  
It contains the console menu and handles user input.

### `Library.java`

The main service class of the system.  
It manages library items, members, searching, borrowing, returning, and borrow records.

### `LibraryItem.java`

An abstract class that stores common details for all library items, such as item ID, title, author, and status.

### `Borrowable.java`

An interface that defines the required methods for borrowing and returning items.

### `Book.java`

Represents a physical book.  
It extends `LibraryItem` and includes page count and borrower details.

### `EBook.java`

Represents a digital book.  
It extends `LibraryItem` and includes file size and download format.

### `Member.java`

Represents a library member with member ID, name, and email.

### `BorrowRecord.java`

Stores borrow history details such as borrowed item, member, borrow date, and return date.

### `BookStatus.java`

An enum that defines the availability status of a library item.

### `LibraryException.java`

A custom exception class used to handle library-specific errors.

## Requirements

- Java JDK 8 or newer
- Command Prompt, PowerShell, Terminal, or any Java IDE

## How to Run

Open a terminal inside the project folder.

### Compile the project

```bash
javac -d out src/com/library/*.java
```

### Run the project

```bash
java -cp out com.library.Main
```

## Sample Menu

```text
===== Library Management System =====
1. View all library items
2. View all members
3. Search item by title
4. Borrow item
5. Return item
6. View borrow history
0. Exit
```

## Sample Data

The system includes sample books and members when it starts.

### Books

```text
B001 | Clean Code | Robert C. Martin
B002 | Effective Java | Joshua Bloch
E001 | Java Basics | Oracle Team
E002 | Software Testing Guide | QA Academy
```

### Members

```text
M001 | Niromi
M002 | Kasun
```
