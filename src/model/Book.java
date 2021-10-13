package model;

import java.io.Serializable;

public class Book implements Serializable {
    private String bookCode;
    private String bookName;

    public Book() {
    }

    public Book(String bookCode, String bookName) {
        this.bookCode = bookCode;
        this.bookName = bookName;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "bookCode= " + bookCode +
                ", bookName= " + bookName
                ;
    }
}
