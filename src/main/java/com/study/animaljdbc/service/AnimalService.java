package com.study.animaljdbc.service;

import com.study.animaljdbc.dao.AnimalDao;
import com.study.animaljdbc.domain.Animal;
import com.study.animaljdbc.dto.AnimalUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {


    private final AnimalDao animalDao;

    public AnimalService(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }


    public void insertAnimal(Animal animal) {
//        System.out.println(animal.toString());

        animalDao.insertAnimal(animal);
    }

    public List<Animal> selectAnimal(int id) {
        return animalDao.selectOne(id);
    }

    public List<Animal> selectAllAnimals() {
        return animalDao.selectAllAnimals();
    }


    public void updateAnimal(int id, AnimalUpdateRequestDto animalDto) {
        animalDao.updateAnimal(id, animalDto);
    }

    public void deleteAnimal(int id) {
        animalDao.deleteAnimal(id);
    }


}
