package com.example.practicing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practicing.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
