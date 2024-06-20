package com.example.practicing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practicing.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
