package com.xrq.util;

/**
 * @author 许瑞琪
 * Date  2025/7/3 10:26
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> local;

    private SqlSessionUtil() {
    }

    public static SqlSession getSession() {
        SqlSession sqlSession = (SqlSession)local.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession();
            local.set(sqlSession);
        }

        return sqlSession;
    }

    public static void closeSession() {
        try {
            SqlSession sqlSession = (SqlSession)local.get();
            if (sqlSession != null) {
                sqlSession.close();
            }
        } finally {
            local.remove();
        }

    }

    public static void commit() {
        SqlSession sqlSession = (SqlSession)local.get();
        sqlSession.commit();
    }

    public static void rollback() {
        SqlSession sqlSession = (SqlSession)local.get();
        sqlSession.rollback();
    }

    public static <T> T getMapper(Class<T> type) {
        return getSession().getMapper(type);
    }

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            Throwable var1 = null;

            try {
                factory = (new SqlSessionFactoryBuilder()).build(inputStream);
            } catch (Throwable var11) {
                var1 = var11;
                throw var11;
            } finally {
                if (inputStream != null) {
                    if (var1 != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var10) {
                            var1.addSuppressed(var10);
                        }
                    } else {
                        inputStream.close();
                    }
                }

            }
        } catch (IOException var13) {
            IOException e = var13;
            e.printStackTrace();
        }

        local = new ThreadLocal();
    }
}
