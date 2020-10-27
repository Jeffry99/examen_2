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
import org.una.examen.provincias.entities.Unidad;

/**
 *
 * @author Jeffry
 */
public interface IUnidadRepository extends JpaRepository<Unidad, Long>{
    public List<Unidad> findByNombreContainingIgnoreCase(String nombre);
    public Optional<Unidad> findByCodigo(int codigo);
    
    @Query("SELECT a FROM Unidad a LEFT JOIN a.distrito e WHERE e.id = :distritoID")
    public List<Unidad> findByDistrito(@Param("distritoID") Long distrito);
}
