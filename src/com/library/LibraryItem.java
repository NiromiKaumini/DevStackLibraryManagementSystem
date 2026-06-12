package com.library;

// Abstraction: common details for all library items are placed here.
public abstract class LibraryItem implements Borrowable {
    private String itemId;
    private String title;
    private String author;
    private BookStatus status;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.status = BookStatus.AVAILABLE;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    protected void setStatus(BookStatus status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    // Polymorphism: subclasses must provide their own item type.
    public abstract String getItemType();

    public String getBasicDetails() {
        return "[" + getItemType() + "] " + itemId + " | " + title + " by " + author + " | " + status;
    }
}
