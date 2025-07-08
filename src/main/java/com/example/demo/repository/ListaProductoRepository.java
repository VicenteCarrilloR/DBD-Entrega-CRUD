package com.example.demo.repository;

import com.example.demo.entity.ListaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaProductoRepository extends JpaRepository<ListaProducto, Integer> {
}
