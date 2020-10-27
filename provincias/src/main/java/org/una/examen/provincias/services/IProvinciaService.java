/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.provincias.dtos.ProvinciaDTO;
/**
 *
 * @author Jeffry
 */
public interface IProvinciaService {
    public Optional<List<ProvinciaDTO>> findAll();
    
    public Optional<ProvinciaDTO> findById(Long id);
    
    public Optional<List<ProvinciaDTO>> findByNombre(String nombre);
    
    public Optional<ProvinciaDTO> findByCodigo(int codigo);
    
    public ProvinciaDTO create(ProvinciaDTO provincia);
    
    public Optional<ProvinciaDTO> update(ProvinciaDTO provincia, Long id);
    
    public void delete(Long id);

}
