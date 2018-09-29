package com.library.test;

import com.librarymanager.dao.BuildSqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactory;

public class Test
{
    @org.junit.Test
    public void test()
    {
        SqlSessionFactory sqlSessionFactory = BuildSqlSessionFactory.buildSqlSessionFactory();
        sqlSessionFactory.openSession();
    }
}
