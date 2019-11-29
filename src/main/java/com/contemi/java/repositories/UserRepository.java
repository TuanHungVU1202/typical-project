package com.contemi.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contemi.java.models.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
//
}
