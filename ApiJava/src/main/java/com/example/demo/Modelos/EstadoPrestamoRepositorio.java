package com.example.demo.Modelos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPrestamoRepositorio extends JpaRepository<EstadoPrestamo, Long>  {

}
