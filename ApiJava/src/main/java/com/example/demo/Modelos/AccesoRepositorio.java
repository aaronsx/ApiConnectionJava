package com.example.demo.Modelos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoRepositorio extends JpaRepository<Acceso, Long>{

}
