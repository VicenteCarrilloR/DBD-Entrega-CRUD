package com.example.demo.repository;

import com.example.demo.entity.CarritoProducto;
import com.example.demo.entity.CarritoProductoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoProductoRepository extends JpaRepository<CarritoProducto, CarritoProductoId> {
}
