/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.provincias.dtos.UnidadDTO;
import org.una.examen.provincias.entities.Unidad;
import org.una.examen.provincias.repositories.IUnidadRepository;
import org.una.examen.provincias.utils.MapperUtils;
import org.una.examen.provincias.utils.ServiceConvertionHelper;

/**
 *
 * @author Jeffry
 */
@Service
public class UnidadServiceImplementation implements IUnidadService{
    @Autowired
    private IUnidadRepository unidadRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<UnidadDTO>> findAll() {
        return ServiceConvertionHelper.findList(unidadRepository.findAll(), UnidadDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UnidadDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(unidadRepository.findById(id), UnidadDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UnidadDTO>> findByNombre(String nombre) {
        return ServiceConvertionHelper.findList(unidadRepository.findByNombreContainingIgnoreCase(nombre), UnidadDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<UnidadDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(unidadRepository.findByCodigo(codigo), UnidadDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<UnidadDTO>> findByDistrito(Long distrito) {
        return ServiceConvertionHelper.findList(unidadRepository.findByDistrito(distrito), UnidadDTO.class);
    }
    
    @Override
    @Transactional
    public UnidadDTO create(UnidadDTO distrito) {
        Unidad u = MapperUtils.EntityFromDto(distrito, Unidad.class);
        u = unidadRepository.save(u);
        return MapperUtils.DtoFromEntity(u, UnidadDTO.class);
    }

    @Override
    @Transactional
    public Optional<UnidadDTO> update(UnidadDTO distrito, Long id) {
        if (unidadRepository.findById(id).isPresent()) {
            Unidad u = MapperUtils.EntityFromDto(distrito, Unidad.class);
            u = unidadRepository.save(u);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(u, UnidadDTO.class));
        } else {
            return null;
        } 
    }

    @Override
    @Transactional
    public void delete(Long id) {
        unidadRepository.deleteById(id);
    }
    
}
