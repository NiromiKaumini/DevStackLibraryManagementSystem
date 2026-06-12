package com.library;

// Inheritance: Book extends LibraryItem.
public class Book extends LibraryItem {
    private int totalPages;
    private Member borrowedBy;

    public Book(String itemId, String title, String author, int totalPages) {
        super(itemId, title, author);
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    @Override
    public String getItemType() {
        return "Physical Book";
    }

    @Override
    public void borrowItem(Member member) throws LibraryException {
        if (!isAvailable()) {
            throw new LibraryException("This book is already borrowed.");
        }

        borrowedBy = member;
        setStatus(BookStatus.BORROWED);
    }

    @Override
    public void returnItem() throws LibraryException {
        if (isAvailable()) {
            throw new LibraryException("This book is already available.");
        }

        borrowedBy = null;
        setStatus(BookStatus.AVAILABLE);
    }

    @Override
    public String getBasicDetails() {
        String borrower = borrowedBy == null ? "" : " | Borrowed by: " + borrowedBy.getName();
        return super.getBasicDetails() + " | Pages: " + totalPages + borrower;
    }
}
