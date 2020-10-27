/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.provincias.dtos.UnidadDTO;

/**
 *
 * @author Jeffry
 */
public interface IUnidadService {
    public Optional<List<UnidadDTO>> findAll();
    
    public Optional<UnidadDTO> findById(Long id);
    
    public Optional<List<UnidadDTO>> findByNombre(String nombre);
    
    public Optional<UnidadDTO> findByCodigo(int codigo);
    
    public Optional<List<UnidadDTO>> findByDistrito(Long unidad);
    
    public UnidadDTO create(UnidadDTO unidad);
    
    public Optional<UnidadDTO> update(UnidadDTO unidad, Long id);
    
    public void delete(Long id);
}
