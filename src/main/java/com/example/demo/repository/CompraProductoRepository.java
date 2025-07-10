package com.example.demo.repository;

import com.example.demo.entity.CompraProducto;
import com.example.demo.entity.CompraProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProductoRepository extends JpaRepository<CompraProducto, CompraProductoId> {
}
