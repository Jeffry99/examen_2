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
import org.una.examen.provincias.repositories.IProvinciaRepository;
import org.una.examen.provincias.utils.MapperUtils;
import org.una.examen.provincias.dtos.ProvinciaDTO;
import org.una.examen.provincias.entities.Provincia;
import org.una.examen.provincias.utils.ServiceConvertionHelper;



/**
 *
 * @author Jeffry
 */
@Service
public class ProvinciaServiceImplementation implements IProvinciaService{
    @Autowired
    private IProvinciaRepository provinciaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProvinciaDTO>> findAll() {
        return ServiceConvertionHelper.findList(provinciaRepository.findAll(), ProvinciaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinciaDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(provinciaRepository.findById(id), ProvinciaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProvinciaDTO>> findByNombre(String nombre) {
        return ServiceConvertionHelper.findList(provinciaRepository.findByNombreContainingIgnoreCase(nombre), ProvinciaDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<ProvinciaDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(provinciaRepository.findByCodigo(codigo), ProvinciaDTO.class);
    }
    
    @Override
    @Transactional
    public ProvinciaDTO create(ProvinciaDTO provincia) {
        Provincia p = MapperUtils.EntityFromDto(provincia, Provincia.class);
        p = provinciaRepository.save(p);
        return MapperUtils.DtoFromEntity(p, ProvinciaDTO.class);
    }

    @Override
    @Transactional
    public Optional<ProvinciaDTO> update(ProvinciaDTO provincia, Long id) {
        if (provinciaRepository.findById(id).isPresent()) {
            Provincia p = MapperUtils.EntityFromDto(provincia, Provincia.class);
            p = provinciaRepository.save(p);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(p, ProvinciaDTO.class));
        } else {
            return null;
        } 
    }

    @Override
    @Transactional
    public void delete(Long id) {
        provinciaRepository.deleteById(id);
    }
}
