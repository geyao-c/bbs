package com.threechenandwu.bbs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class BbsApplicationTests {
    @Autowired
    private DataSource dataSource;
    //测试服务器数据库是否连接成功
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
