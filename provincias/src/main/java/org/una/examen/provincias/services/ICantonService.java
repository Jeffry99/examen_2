/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.provincias.dtos.CantonDTO;

/**
 *
 * @author Jeffry
 */
public interface ICantonService {
    public Optional<List<CantonDTO>> findAll();
    
    public Optional<CantonDTO> findById(Long id);
    
    public Optional<List<CantonDTO>> findByNombre(String nombre);
    
    public Optional<CantonDTO> findByCodigo(int codigo);
    
    public Optional<List<CantonDTO>> findByProvincia(Long provincia);
    
    public CantonDTO create(CantonDTO canton);
    
    public Optional<CantonDTO> update(CantonDTO canton, Long id);
    
    public void delete(Long id);
}
