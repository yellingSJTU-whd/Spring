package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {

    private static final SqlSessionFactory factory;

    static {
        try {
            var builder = new SqlSessionFactoryBuilder();
            factory = builder.build(Resources.getResourceAsStream("mybatis.config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static SqlSession establishSession() {
        return factory.openSession(false);
    }
}
