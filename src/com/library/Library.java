package com.library;

import java.util.ArrayList;
import java.util.List;

// This class contains the main business logic of the system.
public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private List<BorrowRecord> borrowRecords;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        borrowRecords = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<LibraryItem> getAllItems() {
        return items;
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public LibraryItem findItemById(String itemId) throws LibraryException {
        for (LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                return item;
            }
        }

        throw new LibraryException("Item not found with ID: " + itemId);
    }

    public Member findMemberById(String memberId) throws LibraryException {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }

        throw new LibraryException("Member not found with ID: " + memberId);
    }

    public List<LibraryItem> searchItemsByTitle(String keyword) {
        List<LibraryItem> results = new ArrayList<>();

        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(item);
            }
        }

        return results;
    }

    public void borrowItem(String itemId, String memberId) throws LibraryException {
        LibraryItem item = findItemById(itemId);
        Member member = findMemberById(memberId);

        item.borrowItem(member);

        BorrowRecord record = new BorrowRecord(item, member);
        borrowRecords.add(record);
    }

    public void returnItem(String itemId) throws LibraryException {
        LibraryItem item = findItemById(itemId);
        item.returnItem();

        BorrowRecord activeRecord = findActiveBorrowRecord(itemId);
        activeRecord.closeRecord();
    }

    private BorrowRecord findActiveBorrowRecord(String itemId) throws LibraryException {
        for (BorrowRecord record : borrowRecords) {
            if (record.getItem().getItemId().equalsIgnoreCase(itemId) && record.isActive()) {
                return record;
            }
        }

        throw new LibraryException("No active borrow record found for item ID: " + itemId);
    }
}
