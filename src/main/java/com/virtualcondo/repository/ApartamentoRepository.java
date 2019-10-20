package com.virtualcondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcondo.models.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer> {

}
