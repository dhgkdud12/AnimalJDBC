package com.study.animaljdbc.dao;

import com.study.animaljdbc.domain.Animal;
import com.study.animaljdbc.dto.AnimalUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AnimalDao {

    private final JdbcTemplate jdbcTemplate;

    public AnimalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // 동물 등록
    public void insertAnimal(Animal animal) {
        String query = "INSERT INTO Animal (id, name, type, age) values (?, ?, ?, ?)" ;
        jdbcTemplate.update(query, animal.getId(), animal.getName(), animal.getType(), animal.getAge());
    }

    public class AnimalRowMapper implements RowMapper<Animal> {
        @Override
        public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Animal(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("age")
            );
        }
    }

    // 동물 모두 가져오기
    public List<Animal> selectAllAnimals() {
        String query = "SELECT * FROM Animal";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<Animal>(Animal.class));
        return jdbcTemplate.query(query,
                (rs, rowNum) -> new Animal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("age")
                )
        );
    }
    
    //동물 하나 가져오기
    public List<Animal> selectOne(int id) {
        String query = "SELECT * FROM Animal WHERE ID = ?";
        return jdbcTemplate.query(query, new AnimalRowMapper(), id);
    }
    

    // 동물 이름, 종, 나이 수정하기
    public void updateAnimal(int id, AnimalUpdateRequestDto animalDto) {
        String query = "UPDATE Animal SET name = ?, type = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(query, animalDto.getName(), animalDto.getType(), animalDto.getAge(), id);
    }
    
    // 동물 삭제하기
    public void deleteAnimal(int id) {
        String query = "DELETE FROM Animal WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

}
