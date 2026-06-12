package com.library;

public interface Borrowable {
    void borrowItem(Member member) throws LibraryException;
    void returnItem() throws LibraryException;
}
