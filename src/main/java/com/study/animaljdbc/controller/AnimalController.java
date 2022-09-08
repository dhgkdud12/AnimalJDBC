package com.study.animaljdbc.controller;

import com.study.animaljdbc.domain.Animal;
import com.study.animaljdbc.dto.AnimalUpdateRequestDto;
import com.study.animaljdbc.service.AnimalJdbcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

//    private final AnimalService service; // Spring Jdbc
    private final AnimalJdbcService jdbcService; // Jdbc

//    public AnimalController(AnimalService service) {
//        this.service = service;
//    }

    public AnimalController(AnimalJdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    // 동물 등록
    @PostMapping("")
    public String register(@RequestBody Animal animal) {
        System.out.println(animal.toString());
        jdbcService.insertAnimal(animal);
        return "동물 등록완료";
    }

    // 모든 동물 검색
    @GetMapping("")
    public List<Animal> list() {
        return jdbcService.selectAllAnimals();
    }


    // 동물 id 검색
    @GetMapping("/{id}")
    public List<Animal> selectAnimal(@PathVariable("id") int id) {
        return jdbcService.selectAnimal(id);
    }

    // 동물 id로 name 가져오기
    @GetMapping("/name/{id}")
    public String selectAnimalNameById(@PathVariable("id") int id) {
        return jdbcService.selectAnimalNameById(id);
    }

    // 동물 이름 수정
    @PutMapping("/{id}")
    public String updateAnimal(@PathVariable("id") Integer id, @RequestBody AnimalUpdateRequestDto requesttDto) {
        System.out.println(id);
        System.out.println(id + " 동물정보 수정되었습니다");
        jdbcService.updateAnimal(id,requesttDto);
        return "수정 완료";
    }


    // 동물 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println(id + " 동물 삭제되었습니다");
        jdbcService.deleteAnimal(id);
        return "삭제 완료";
    }

}
