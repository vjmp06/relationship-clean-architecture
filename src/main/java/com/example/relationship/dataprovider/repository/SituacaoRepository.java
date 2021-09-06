package com.example.relationship.dataprovider.repository;

import com.example.relationship.dataprovider.entity.Situacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, String> {
}
