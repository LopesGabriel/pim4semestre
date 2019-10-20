package com.virtualcondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcondo.models.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Integer> {

}
