package com.library.test;

import com.library.dao.BuildSqlSessionFactory;
import com.library.data.UserTable;
import com.library.mapper.UserTableMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

public class Test
{
    @org.junit.Test
    public void test()
    {
        SqlSessionFactory sqlSessionFactory = BuildSqlSessionFactory.buildSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserTableMapper userTableMapper = sqlSession.getMapper(UserTableMapper.class);
        UserTable userTable = userTableMapper.select("王林");
//        System.out.println(userTable.getUsername());
        System.out.println(userTable.getClass().getName());
        userTable.setUsername("李慕婉");
        userTable.setPassword("123456");
        userTable.setPower("管理员");

        try
        {
            userTableMapper.addUser(userTable);
            sqlSession.commit();
        } catch (PersistenceException ps)
        {
            sqlSession.rollback();
        }
    }
}
