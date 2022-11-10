package com.acmeFresh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
