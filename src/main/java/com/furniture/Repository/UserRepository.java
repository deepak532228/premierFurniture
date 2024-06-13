package com.furniture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
