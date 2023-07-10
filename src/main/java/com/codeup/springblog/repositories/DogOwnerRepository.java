package com.codeup.springblog.repositories;

import com.codeup.springblog.models.DogOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogOwnerRepository extends JpaRepository<DogOwner, Long> {
}
