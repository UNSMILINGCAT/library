//package com.library.dao;
//
//import com.library.data.UserTable;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//
//public class UserTableDAO extends BasicDAO<UserTable>
//{
//    private static UserTableDAO userTableDAO = new UserTableDAO();
//
//    private UserTableDAO() {}
//
//    public static Query<UserTable> getQuery(String hql)
//    {
//        return HibernateUtil.getSession().createQuery(hql,
//                userTableDAO.getEntityClass());
//    }
//
//    public static Query<UserTable> getSQLQuery(String sql)
//    {
//        return HibernateUtil.getSession().createSQLQuery(sql);
//    }
//
//    public static boolean addUser(UserTable userTable)
//    {
//        return userTableDAO.save(userTable);
//    }
//
//    @Override
//    public boolean save(UserTable userTable)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            session.save(userTable);
//            transaction.commit();
//        } catch (Exception ec)
//        {
//            ec.printStackTrace();
//            return false;
//        } finally
//        {
//            HibernateUtil.closeSession();
//        }
//        return true;
//    }
//
//    public static List<UserTable> selectUser(Query<UserTable> query)
//    {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        try
//        {
//            List<UserTable> list = query.list();
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
//    public static boolean delete(Query<UserTable> query)
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
//            ex.printStackTrace();
//            return false;
//        } finally
//        {
//            HibernateUtil.closeSession();
//        }
//    }
//
//}
