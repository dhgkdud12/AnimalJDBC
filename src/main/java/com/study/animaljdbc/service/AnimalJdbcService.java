package com.study.animaljdbc.service;

import com.study.animaljdbc.Jdbc.Delete;
import com.study.animaljdbc.Jdbc.Insert;
import com.study.animaljdbc.Jdbc.Select;
import com.study.animaljdbc.Jdbc.Update;
import com.study.animaljdbc.domain.Animal;
import com.study.animaljdbc.dto.AnimalUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalJdbcService {


    private final Insert insert;
    private final Select select;
    private final Delete delete;
    private final Update update;



    public AnimalJdbcService(Insert insert, Select select, Delete delete, Update update) {
        this.insert = insert;
        this.select = select;
        this.delete = delete;
        this.update = update;
    }


    public void insertAnimal(Animal animal) {
        insert.insert(animal);
    }

    public List<Animal> selectAllAnimals() {
        return select.select();
    }

    public List<Animal> selectAnimal(int id) {
        return null;
    }

    public String selectAnimalNameById(int id) {
        return null;
    }

    public void updateAnimal(int id, AnimalUpdateRequestDto animalDto) {
        update.update(id, animalDto);
    }

    public void deleteAnimal(int id) {
        delete.delete(id);
    }


}
