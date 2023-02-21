package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

import static org.apache.ibatis.io.Resources.*;

public class SqlSessionUtil {
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<>();

    private static final SqlSessionFactory factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(getResourceAsStream("mybatis.config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession fetchSession() {
        var session = local.get();
        if (session == null) {
            session = establishSession();
            local.set(session);
        }
        return session;
    }

    public static void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
            local.remove();
        }
    }

    private static SqlSession establishSession() {
        return factory.openSession(false);
    }

    private SqlSessionUtil() {
    }
}
