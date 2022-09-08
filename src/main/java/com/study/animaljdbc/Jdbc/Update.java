package com.study.animaljdbc.Jdbc;

import com.study.animaljdbc.domain.Animal;
import com.study.animaljdbc.dto.AnimalUpdateRequestDto;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Update {

    public void update(Integer id, AnimalUpdateRequestDto animaldto){

        String name = animaldto.getName();
        String type = animaldto.getType();
        Integer age = animaldto.getAge();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // 1. 드라이버 로딩
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 연결하기
            String url = "jdbc:mysql://211.62.140.76:43306/ulalalab_ohy";
            conn = DriverManager.getConnection(url, "ohy", "Passw0rd123!@#");


            // 3. SQL 쿼리 준비
            String sql = "UPDATE Animal SET name = ?, type = ?, age = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);


            // 4. 데이터 binding
            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setInt(3, age);
            pstmt.setInt(4, id);


            // 5. 쿼리 실행 및 결과 처리
            int count = pstmt.executeUpdate();
            if( count == 0 ){
                System.out.println("데이터 수정 실패");
            }
            else{
                System.out.println("데이터 수정 성공");
            }
        }

        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }

        catch( SQLException e){
            System.out.println("에러 " + e);
        }

        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
}

