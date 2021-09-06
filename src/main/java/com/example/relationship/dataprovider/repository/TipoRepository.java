package com.example.relationship.dataprovider.repository;

import com.example.relationship.dataprovider.entity.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, String> {
}
