package com.chuwa.learn.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class DataInitializer implements ApplicationRunner {

    private final DataSource dataSource;

    @Autowired
    public DataInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            // 读取 data.sql 文件内容
            try (InputStream inputStream = getClass().getResourceAsStream("/data.sql");
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                StringBuilder sqlScript = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sqlScript.append(line).append("\n");
                }

                // 执行 SQL 脚本
                statement.execute(sqlScript.toString());
            }
        }
    }
}
