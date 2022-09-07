package com.study.animaljdbc.controller;

import com.study.animaljdbc.domain.Animal;
import com.study.animaljdbc.dto.AnimalUpdateRequestDto;
import com.study.animaljdbc.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    // 동물 등록
    @PostMapping("/register")
    public String register(@RequestBody Animal animal) {
        System.out.println(animal.toString());
        service.insertAnimal(animal);
        return "동물 등록완료";
    }

    // 동물 학번 검색
    @GetMapping("/{id}")
    public List<Animal> readStudent(@PathVariable("id") int id) {
        return service.selectAnimal(id);
    }


    // 모든 동물 검색
    @GetMapping("")
    public List<Animal> list() {
        return service.selectAllAnimals();
    }

    // 동물 이름 수정
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable("id") Integer id, @RequestBody AnimalUpdateRequestDto requesttDto) {
        System.out.println(id);
        System.out.println(id + " 동물정보 수정되었습니다");
        service.updateAnimal(id,requesttDto);
        return "수정 완료";
    }


    // 동물 삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println(id + " 동물 삭제되었습니다");
        service.deleteAnimal(id);
        return "삭제 완료";
    }

}
