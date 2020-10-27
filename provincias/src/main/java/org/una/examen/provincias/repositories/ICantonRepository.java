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
import org.una.examen.provincias.entities.Canton;
/**
 *
 * @author Jeffry
 */
public interface ICantonRepository extends JpaRepository<Canton, Long>{
    public List<Canton> findByNombreContainingIgnoreCase(String nombre);
    public Optional<Canton> findByCodigo(int codigo);
    
    @Query("SELECT a FROM Canton a LEFT JOIN a.provincia e WHERE e.id = :provinciaID")
    public List<Canton> findByProvincia(@Param("provinciaID") Long provincia);
}
