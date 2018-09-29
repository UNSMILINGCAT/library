//package com.library.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil
//{
//    private static SessionFactory sessionFactory;
//    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
//    private static Configuration configuration = new Configuration();
//
//    static
//    {
//        configuration.configure();
//        sessionFactory = configuration.buildSessionFactory();
//    }
//
//    public static SessionFactory getSessionFactory()
//    {
//        return sessionFactory;
//    }
//
//    public static Session getSession()
//    {
//        Session session = threadLocal.get();
//        if (session == null||!session.isOpen())
//        {
//            if (sessionFactory == null)
//            {
//                rebuildSessionFactory();
//            }
//            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
//            threadLocal.set(session);
//        }
//        return session;
//    }
//
//    public static void rebuildSessionFactory()
//    {
//        configuration.configure("/hibernate.cfg.xml");
//        sessionFactory = configuration.buildSessionFactory();
//    }
//
//    public static void closeSession()
//    {
//        Session session = threadLocal.get();
//        if (session != null)
//        {
//            session.close();
//        }
//    }
//
//    public static void shutdown()
//    {
//        getSessionFactory().close();
//    }
//}
