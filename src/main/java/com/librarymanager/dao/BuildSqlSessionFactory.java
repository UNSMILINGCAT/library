package com.librarymanager.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class BuildSqlSessionFactory
{
    private static String CONFIG_PATH = "mybatis-config.xml";

    public static SqlSessionFactory buildSqlSessionFactory()
    {
        return buildSqlSessionFactory("development");
    }

    public static SqlSessionFactory buildSqlSessionFactory(String environmentId)
    {
        InputStream cfx = null;
        SqlSessionFactory sqlSessionFactory = null;
        try
        {
            cfx = Resources.getResourceAsStream(CONFIG_PATH);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfx);
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (cfx != null)
            {
                try
                {
                    cfx.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return sqlSessionFactory;
    }
}
