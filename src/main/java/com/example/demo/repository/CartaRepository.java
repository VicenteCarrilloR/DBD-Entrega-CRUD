package com.example.demo.repository;

import com.example.demo.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartaRepository extends JpaRepository<Carta,Integer>{
}
