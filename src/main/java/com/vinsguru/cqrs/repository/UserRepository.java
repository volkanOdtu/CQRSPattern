package com.vinsguru.cqrs.repository;

import org.springframework.stereotype.Repository;

import com.vinsguru.cqrs.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
