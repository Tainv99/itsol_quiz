package com.example.demo.repository;

import com.example.demo.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserBO, Long> {
    @Query("SELECT u FROM UserBO u WHERE u.username=:username")
    Optional<UserBO> getUserByUsername(@Param("username") String username);
}
