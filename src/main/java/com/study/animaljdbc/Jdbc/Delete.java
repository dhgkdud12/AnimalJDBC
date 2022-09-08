package com.study.animaljdbc.Jdbc;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Delete {

    public void delete(Integer id){

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // 1. 드라이버 로딩
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 연결하기
            String url = "jdbc:mysql://211.62.140.76:43306/ulalalab_ohy";
            conn = DriverManager.getConnection(url, "ohy", "Passw0rd123!@#");


            // 3. SQL 쿼리 준비
            String sql = "DELETE FROM Animal WHERE id = " + id;
            pstmt = conn.prepareStatement(sql);

            // 4. 쿼리 실행 및 결과 처리
            // ResultSet 객체가 필요 없고, 바로 pstmt.executeUpdate()메서드를 호출하면 됩니다.
            // INSERT, UPDATE, DELETE 쿼리는 이와 같이 메서드를 호출
            int count = pstmt.executeUpdate();
            if( count == 0 ){
                System.out.println("데이터 삭제 실패");
            }
            else{
                System.out.println("데이터 삭제 성공");
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
