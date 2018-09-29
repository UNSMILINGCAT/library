package com.librarymanager.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class BookBrowse
{
    private int id;
    private String studentName;
    private String bookName;
    private Date returnDate;
    private Date borrowDate;
    private String com;
    private String isReturned;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "StudentName", nullable = true, length = 40)
    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "BookName", nullable = true, length = 40)
    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "ReturnDate", nullable = true)
    public Date getReturnDate()
    {
        return returnDate;
    }

    public void setReturnDate(Date returnDate)
    {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "BorrowDate", nullable = true)
    public Date getBorrowDate()
    {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate)
    {
        this.borrowDate = borrowDate;
    }

    @Basic
    @Column(name = "Com", nullable = true, length = 40)
    public String getCom()
    {
        return com;
    }

    public void setCom(String com)
    {
        this.com = com;
    }

    @Basic
    @Column(name = "Is_Returned", nullable = true, length = 2)
    public String getIsReturned()
    {
        return isReturned;
    }

    public void setIsReturned(String isReturned)
    {
        this.isReturned = isReturned;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookBrowse that = (BookBrowse) o;
        return id == that.id &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(borrowDate, that.borrowDate) &&
                Objects.equals(com, that.com) &&
                Objects.equals(isReturned, that.isReturned);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, studentName, bookName, returnDate, borrowDate, com, isReturned);
    }
}
