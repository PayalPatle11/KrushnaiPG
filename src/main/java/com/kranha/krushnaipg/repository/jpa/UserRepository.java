package com.kranha.krushnaipg.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kranha.krushnaipg.dto.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM payal_user order by ID ASC")
    List<User> orderByID();

    @Query(nativeQuery = true, value = "SELECT * FROM payal_user order by Name Dsc")
    List<User> orderByName();

//    Filter records where the name ends with a specific letter.
    List<User> findByNameEndingWith(String letter);


}

