//package com.library.data;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.Date;
//import java.util.Objects;
//
//@Entity
//public class Books
//{
//    private int id;
//    private String bookName;
//    private String press;
//    private String author;
//    private Date pressDate;
//    private BigDecimal price;
//    private String com;
//    private BigInteger booksCount;
//    private BigInteger borrowedCount;
//    private String address;
//
//    @Id
//    @Column(name = "ID", nullable = false, precision = 0)
//    public int getId()
//    {
//        return id;
//    }
//
//    public void setId(int id)
//    {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "BookName", nullable = true, length = 20)
//    public String getBookName()
//    {
//        return bookName;
//    }
//
//    public void setBookName(String bookName)
//    {
//        this.bookName = bookName;
//    }
//
//    @Basic
//    @Column(name = "Press", nullable = true, length = 20)
//    public String getPress()
//    {
//        return press;
//    }
//
//    public void setPress(String press)
//    {
//        this.press = press;
//    }
//
//    @Basic
//    @Column(name = "Author", nullable = true, length = 20)
//    public String getAuthor()
//    {
//        return author;
//    }
//
//    public void setAuthor(String author)
//    {
//        this.author = author;
//    }
//
//    @Basic
//    @Column(name = "PressDate", nullable = true)
//    public Date getPressDate()
//    {
//        return pressDate;
//    }
//
//    public void setPressDate(Date pressDate)
//    {
//        this.pressDate = pressDate;
//    }
//
//    @Basic
//    @Column(name = "Price", nullable = true, precision = 2)
//    public BigDecimal getPrice()
//    {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price)
//    {
//        this.price = price;
//    }
//
//    @Basic
//    @Column(name = "Com", nullable = true, length = 20)
//    public String getCom()
//    {
//        return com;
//    }
//
//    public void setCom(String com)
//    {
//        this.com = com;
//    }
//
//    @Basic
//    @Column(name = "books_count", nullable = true, precision = 0)
//    public BigInteger getBooksCount()
//    {
//        return booksCount;
//    }
//
//    public void setBooksCount(BigInteger booksCount)
//    {
//        this.booksCount = booksCount;
//    }
//
//    @Basic
//    @Column(name = "borrowed_count", nullable = true, precision = 0)
//    public BigInteger getBorrowedCount()
//    {
//        return borrowedCount;
//    }
//
//    public void setBorrowedCount(BigInteger borrowedCount)
//    {
//        this.borrowedCount = borrowedCount;
//    }
//
//    @Basic
//    @Column(name = "address", nullable = true, length = 50)
//    public String getAddress()
//    {
//        return address;
//    }
//
//    public void setAddress(String address)
//    {
//        this.address = address;
//    }
//
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Books books = (Books) o;
//        return id == books.id &&
//                Objects.equals(bookName, books.bookName) &&
//                Objects.equals(press, books.press) &&
//                Objects.equals(author, books.author) &&
//                Objects.equals(pressDate, books.pressDate) &&
//                Objects.equals(price, books.price) &&
//                Objects.equals(com, books.com) &&
//                Objects.equals(booksCount, books.booksCount) &&
//                Objects.equals(borrowedCount, books.borrowedCount) &&
//                Objects.equals(address, books.address);
//    }
//
//    @Override
//    public int hashCode()
//    {
//
//        return Objects.hash(id, bookName, press, author, pressDate, price, com, booksCount, borrowedCount, address);
//    }
//}
