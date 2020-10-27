/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.provincias.dtos.CantonDTO;
import org.una.examen.provincias.entities.Canton;
import org.una.examen.provincias.repositories.ICantonRepository;
import org.una.examen.provincias.utils.MapperUtils;
import org.una.examen.provincias.utils.ServiceConvertionHelper;

/**
 *
 * @author Jeffry
 */
public class CantonServiceImplementation implements ICantonService{
    @Autowired
    private ICantonRepository cantonRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CantonDTO>> findAll() {
        return ServiceConvertionHelper.findList(cantonRepository.findAll(), CantonDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CantonDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(cantonRepository.findById(id), CantonDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CantonDTO>> findByNombre(String nombre) {
        return ServiceConvertionHelper.findList(cantonRepository.findByNombreContainingIgnoreCase(nombre), CantonDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<CantonDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(cantonRepository.findByCodigo(codigo), CantonDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<CantonDTO>> findByProvincia(Long provincia) {
        return ServiceConvertionHelper.findList(cantonRepository.findByProvincia(provincia), CantonDTO.class);
    }
    
    @Override
    @Transactional
    public CantonDTO create(CantonDTO canton) {
        Canton c = MapperUtils.EntityFromDto(canton, Canton.class);
        c = cantonRepository.save(c);
        return MapperUtils.DtoFromEntity(c, CantonDTO.class);
    }

    @Override
    @Transactional
    public Optional<CantonDTO> update(CantonDTO canton, Long id) {
        if (cantonRepository.findById(id).isPresent()) {
            Canton c = MapperUtils.EntityFromDto(canton, Canton.class);
            c = cantonRepository.save(c);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(c, CantonDTO.class));
        } else {
            return null;
        } 
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cantonRepository.deleteById(id);
    }
}
