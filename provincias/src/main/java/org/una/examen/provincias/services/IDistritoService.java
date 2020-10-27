/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.provincias.dtos.DistritoDTO;

/**
 *
 * @author Jeffry
 */
public interface IDistritoService {
    public Optional<List<DistritoDTO>> findAll();
    
    public Optional<DistritoDTO> findById(Long id);
    
    public Optional<List<DistritoDTO>> findByNombre(String nombre);
    
    public Optional<DistritoDTO> findByCodigo(int codigo);
    
    public Optional<List<DistritoDTO>> findByCanton(Long canton);
    
    public DistritoDTO create(DistritoDTO distrito);
    
    public Optional<DistritoDTO> update(DistritoDTO distrito, Long id);
    
    public void delete(Long id);
}
