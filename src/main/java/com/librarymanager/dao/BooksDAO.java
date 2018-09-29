//package com.librarymanager.dao;
//
//import com.librarymanager.data.Books;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//public class BooksDAO extends BasicDAO<Books>
//{
//    private static BooksDAO booksDAO = new BooksDAO();
//
//    private BooksDAO() {}
//
//    public static Query<Books> getQuery(String hql)
//    {
//        return HibernateUtil.getSession().createQuery(hql,
//                booksDAO.getEntityClass());
//    }
//
//    public static Query<Books> getSQLQuery(String sql)
//    {
//        return HibernateUtil.getSession().createSQLQuery(sql);
//    }
//
//    public static boolean addUser(Books books)
//    {
//        return booksDAO.save(books);
//    }
//
//    @Override
//    public boolean save(Books books)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            session.save(books);
//            transaction.commit();
//            return true;
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//            return false;
//        } finally
//        {
//            HibernateUtil.closeSession();
//        }
//
//    }
//
//    public static List<Books> selectUser(Query<Books> query)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            List<Books> list = query.list();
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
//    public static boolean update(Query<Books> query)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            query.executeUpdate();
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
//}
