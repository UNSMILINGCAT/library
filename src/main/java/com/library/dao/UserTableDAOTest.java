//package com.library.dao;
//
//import com.library.data.Books;
//import com.library.data.UserTable;
//import org.hibernate.query.Query;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.Date;
//
//
//public class UserTableDAOTest
//{
//
//    @Test
//    public void testAddUser()
//    {
////        UserTable userTable = new UserTable();
////        userTable.setUsername("如何");
////        userTable.setPassword("123456");
////        String hql = "delete from UserTable where userName=? and passWord=?";
////        Query<UserTable> query = UserTableDAO.getSQLQuery(hql);
////        query.setString(0, userTable.getUsername());
////        query.setString(1, userTable.getPassword());
////        UserTableDAO.delete(query);
////        for (UserTable user : l)
////        {
////            System.out.println(user.getUsername() + " ");
////        }
//        Books books = new Books();
//        Date date = new Date(new java.util.Date().getTime());
//        books.setBookName("");
//        books.setPress("");
//        books.setAuthor("");
//        books.setAddress("");
//        books.setPressDate(date);
//        books.setPrice(new BigDecimal("5"));
//        books.setBooksCount(new BigInteger("5"));
//        books.setCom("");
//        BooksDAO.addUser(books);
//    }
//}