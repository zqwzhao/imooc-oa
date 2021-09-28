package com.imooc.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.function.Function;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-16 21:50]
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static{
        Reader reader = null;

        try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 执行SELECT查询Sql
     * @param func
     * @return
     */
    public static Object executeQuery(Function<SqlSession,Object> func) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Object apply = func.apply(sqlSession);
            return apply;
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**
     * 更新数据
     * @param func
     * @return
     */
    public static Object executeUpdate(Function<SqlSession,Object> func) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try{
            Object apply = func.apply(sqlSession);
            sqlSession.commit();
            return apply;
        }catch (Exception e) {
            sqlSession.rollback();
            throw e;
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }


    /**
     * 创建一个新的SqlSession对象
     * @return
     */
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭sqlSession 会话
     * @param sqlSession
     */
    public static void closeSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
