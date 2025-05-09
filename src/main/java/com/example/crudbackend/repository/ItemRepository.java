package com.example.crudbackend.repository;

import com.example.crudbackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // JpaRepository<TipoDaEntidade, TipoDoIdDaEntidade>
    // Nenhum método customizado é necessário por enquanto,
    // pois JpaRepository já fornece:
    // save(), findById(), findAll(), deleteById(), etc.
}