package com.library;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        loadSampleData();

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        viewAllItems();
                        break;
                    case 2:
                        viewAllMembers();
                        break;
                    case 3:
                        searchItem();
                        break;
                    case 4:
                        borrowItem();
                        break;
                    case 5:
                        returnItem();
                        break;
                    case 6:
                        viewBorrowHistory();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Thank you for using the Library Management System.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (LibraryException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void loadSampleData() {
        library.addItem(new Book("B001", "Clean Code", "Robert C. Martin", 464));
        library.addItem(new Book("B002", "Effective Java", "Joshua Bloch", 416));
        library.addItem(new EBook("E001", "Java Basics", "Oracle Team", 12.5, "PDF"));
        library.addItem(new EBook("E002", "Software Testing Guide", "QA Academy", 8.2, "EPUB"));

        library.addMember(new Member("M001", "Niromi", "niromi@example.com"));
        library.addMember(new Member("M002", "Kasun", "kasun@example.com"));
    }

    private static void printMenu() {
        System.out.println("===== Library Management System =====");
        System.out.println("1. View all library items");
        System.out.println("2. View all members");
        System.out.println("3. Search item by title");
        System.out.println("4. Borrow item");
        System.out.println("5. Return item");
        System.out.println("6. View borrow history");
        System.out.println("0. Exit");
    }

    private static void viewAllItems() {
        System.out.println("\n--- Library Items ---");

        for (LibraryItem item : library.getAllItems()) {
            // Polymorphism: same method call works for Book and EBook.
            System.out.println(item.getBasicDetails());
        }
    }

    private static void viewAllMembers() {
        System.out.println("\n--- Members ---");

        for (Member member : library.getAllMembers()) {
            System.out.println(member.getMemberDetails());
        }
    }

    private static void searchItem() {
        System.out.print("Enter title keyword: ");
        String keyword = scanner.nextLine();

        List<LibraryItem> results = library.searchItemsByTitle(keyword);

        if (results.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        System.out.println("\n--- Search Results ---");
        for (LibraryItem item : results) {
            System.out.println(item.getBasicDetails());
        }
    }

    private static void borrowItem() throws LibraryException {
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        library.borrowItem(itemId, memberId);
        System.out.println("Item borrowed successfully.");
    }

    private static void returnItem() throws LibraryException {
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        library.returnItem(itemId);
        System.out.println("Item returned successfully.");
    }

    private static void viewBorrowHistory() {
        System.out.println("\n--- Borrow History ---");

        if (library.getBorrowRecords().isEmpty()) {
            System.out.println("No borrow records yet.");
            return;
        }

        for (BorrowRecord record : library.getBorrowRecords()) {
            System.out.println(record.getRecordDetails());
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
