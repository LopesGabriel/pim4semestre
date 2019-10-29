package com.virtualcondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcondo.models.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}
