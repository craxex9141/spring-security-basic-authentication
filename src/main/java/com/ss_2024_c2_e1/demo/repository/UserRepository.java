package com.ss_2024_c2_e1.demo.repository;

import com.ss_2024_c2_e1.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("""
            SELECT u FROM User u WHERE u.username = :username 
            """)
    Optional<User> findUserByUsername(String username);
}
