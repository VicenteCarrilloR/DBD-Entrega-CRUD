package com.example.demo.repository;

import com.example.demo.entity.MedioDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioDePagoRepository extends JpaRepository<MedioDePago, Long> {

}
