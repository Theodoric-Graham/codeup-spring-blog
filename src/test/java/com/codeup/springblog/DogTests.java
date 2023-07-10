package com.codeup.springblog;


import com.codeup.springblog.models.Dog;
import com.codeup.springblog.models.DogOwner;
import com.codeup.springblog.repositories.DogOwnerRepository;
import com.codeup.springblog.repositories.DogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DogTests {


    @Autowired
    private DogRepository dogDao;

    @Autowired
    private DogOwnerRepository dogOwnerDao;

    @Test
    public void fetchDogs() {
        List<Dog> dogs = dogDao.findAll();
        System.out.println(dogs);
    }

    @Test
    public void fetchLolasDog() {
        Dog dog = dogDao.findById(8L).get();
        System.out.println(dog);
    }

    @Test
    public void deleteDog() {
    }

//    @Test
//    public void getLolaADog() {
//        //get Lola's pet owner object from the dao
//        DogOwner lola = dogOwnerDao.findById(1L).get();
//        Dog dog = new Dog();
//        dog.setName("Avocado");
//        dog.setAge(1);
//        dog.setOwner(lola);
//
//        dogDao.save(dog);
//    }

    @Test
    public void giveThatDogSomeToys() {
    }

}