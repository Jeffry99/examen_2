/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen.provincias.entities.Provincia;

/**
 *
 * @author Jeffry
 */
public interface IProvinciaRepository extends JpaRepository<Provincia, Long>{
    public List<Provincia> findByNombreContainingIgnoreCase(String nombre);
    public Optional<Provincia> findByCodigo(int codigo);
    //public int sum();
}
