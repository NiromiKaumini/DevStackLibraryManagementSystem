package com.library;

// Inheritance: EBook is a specialized type of LibraryItem.
public class EBook extends LibraryItem {
    private double fileSizeMb;
    private String downloadFormat;

    public EBook(String itemId, String title, String author, double fileSizeMb, String downloadFormat) {
        super(itemId, title, author);
        this.fileSizeMb = fileSizeMb;
        this.downloadFormat = downloadFormat;
    }

    public double getFileSizeMb() {
        return fileSizeMb;
    }

    public String getDownloadFormat() {
        return downloadFormat;
    }

    @Override
    public String getItemType() {
        return "E-Book";
    }

    @Override
    public void borrowItem(Member member) throws LibraryException {
        if (!isAvailable()) {
            throw new LibraryException("This e-book is currently assigned to another member.");
        }

        setStatus(BookStatus.BORROWED);
    }

    @Override
    public void returnItem() throws LibraryException {
        if (isAvailable()) {
            throw new LibraryException("This e-book is already available.");
        }

        setStatus(BookStatus.AVAILABLE);
    }

    @Override
    public String getBasicDetails() {
        return super.getBasicDetails()
                + " | Size: " + fileSizeMb + " MB"
                + " | Format: " + downloadFormat;
    }
}
