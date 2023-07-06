package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//creates a dog "DAO"
public interface DogRepository extends JpaRepository<Dog, Long> {
    @Query("from Dog d where d.name like %:dogName")
    List<Dog> searchByName (@Param("dogName") String dogName);
}
