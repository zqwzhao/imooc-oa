package com.imooc.oa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-16 22:39]
 */
public class DuridDataSourceFactory extends UnpooledDataSourceFactory {
    public DuridDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return this.dataSource;
    }
}
