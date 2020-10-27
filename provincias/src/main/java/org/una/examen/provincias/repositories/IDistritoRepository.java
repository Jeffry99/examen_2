/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.provincias.entities.Distrito;

/**
 *
 * @author Jeffry
 */
public interface IDistritoRepository extends JpaRepository<Distrito, Long>{
    public List<Distrito> findByNombreContainingIgnoreCase(String nombre);
    public Optional<Distrito> findByCodigo(int codigo);
    
    @Query("SELECT a FROM Distrito a LEFT JOIN a.canton e WHERE e.id = :cantonID")
    public List<Distrito> findByCanton(@Param("cantonID") Long canton);
}
