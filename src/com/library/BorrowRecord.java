package com.library;

import java.time.LocalDate;

// Encapsulation: borrow details are stored safely inside this class.
public class BorrowRecord {
    private LibraryItem item;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(LibraryItem item, Member member) {
        this.item = item;
        this.member = member;
        this.borrowDate = LocalDate.now();
    }

    public LibraryItem getItem() {
        return item;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void closeRecord() {
        this.returnDate = LocalDate.now();
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public String getRecordDetails() {
        String returned = returnDate == null ? "Not returned yet" : returnDate.toString();

        return "Item: " + item.getTitle()
                + " | Member: " + member.getName()
                + " | Borrowed: " + borrowDate
                + " | Returned: " + returned;
    }
}
