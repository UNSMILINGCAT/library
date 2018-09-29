//package com.librarymanager.dao;
//
//import com.librarymanager.data.BookBrowse;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//public class BookBrowseDAO extends BasicDAO<BookBrowse>
//{
//    private static BookBrowseDAO bookBrowseDAO = new BookBrowseDAO();
//
//    private BookBrowseDAO() {}
//
//    public static BookBrowseDAO getInstance()
//    {
//        return bookBrowseDAO;
//    }
//
//    public static Query<BookBrowse> getQuery(String hql)
//    {
//        return HibernateUtil.getSession().createQuery(hql,
//                bookBrowseDAO.getEntityClass());
//    }
//
//    public static Query<BookBrowse> getSQLQuery(String sql)
//    {
//        return HibernateUtil.getSession().createSQLQuery(sql);
//    }
//
//    public static boolean addUser(BookBrowse bookBrowse)
//    {
//        return bookBrowseDAO.save(bookBrowse);
//    }
//
//    @Override
//    public boolean save(BookBrowse bookBrowse)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            session.save(bookBrowse);
//            transaction.commit();
//        } catch (Exception ex)
//        {
//            return false;
//        } finally
//        {
//            HibernateUtil.closeSession();
//        }
//        return true;
//    }
//
//    public static List<BookBrowse> selectUser(Query<BookBrowse> query)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            List<BookBrowse> list = query.list();
//            transaction.commit();
//            return list;
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//            return null;
//        } finally
//        {
//            session.close();
//        }
//    }
//
//    public static boolean delete(Query<BookBrowse> query)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            query.executeUpdate();
//            transaction.commit();
//            return true;
//        } catch (Exception ex)
//        {
//            return false;
//        } finally
//        {
//            HibernateUtil.closeSession();
//        }
//    }
//}
