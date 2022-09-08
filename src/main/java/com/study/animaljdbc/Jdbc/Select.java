package com.study.animaljdbc.Jdbc;

import com.study.animaljdbc.domain.Animal;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// JDBC 적용
@Repository
public class Select {
    public List<Animal> select() {

        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://211.62.140.76:43306/ulalalab_ohy";

        List<Animal> animals = new ArrayList<>();

        try {

            // 1. 드라이버 객체화
            Class.forName(jdbc_driver).newInstance();

            // 2. DB와 연결
            Connection con = DriverManager.getConnection(jdbc_url, "ohy", "Passw0rd123!@#");

            // 3. 실행도구 생성 (sql문을 실행시키기 위한 Statement 객체 얻어오기)
            Statement st = con.createStatement();

            String sql = "SELECT * FROM Animal";

            // 4. SQL문 실행
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                Integer age = rs.getInt(4);

                animals.add(new Animal(id, name, type, age));
            }

            // DB 연결 종료(자원반납)
            rs.close();
            st.close();
            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }
}
