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
import org.una.examen.provincias.dtos.DistritoDTO;
import org.una.examen.provincias.entities.Distrito;
import org.una.examen.provincias.repositories.IDistritoRepository;
import org.una.examen.provincias.utils.MapperUtils;
import org.una.examen.provincias.utils.ServiceConvertionHelper;

/**
 *
 * @author Jeffry
 */
@Service
public class DistritoServiceImplementation implements IDistritoService{
    @Autowired
    private IDistritoRepository distritoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<DistritoDTO>> findAll() {
        return ServiceConvertionHelper.findList(distritoRepository.findAll(), DistritoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DistritoDTO> findById(Long id) {
        return ServiceConvertionHelper.oneToOptionalDto(distritoRepository.findById(id), DistritoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DistritoDTO>> findByNombre(String nombre) {
        return ServiceConvertionHelper.findList(distritoRepository.findByNombreContainingIgnoreCase(nombre), DistritoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<DistritoDTO> findByCodigo(int codigo) {
        return ServiceConvertionHelper.oneToOptionalDto(distritoRepository.findByCodigo(codigo), DistritoDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<DistritoDTO>> findByCanton(Long canton) {
        return ServiceConvertionHelper.findList(distritoRepository.findByCanton(canton), DistritoDTO.class);
    }
    
    @Override
    @Transactional
    public DistritoDTO create(DistritoDTO distrito) {
        Distrito d = MapperUtils.EntityFromDto(distrito, Distrito.class);
        d = distritoRepository.save(d);
        return MapperUtils.DtoFromEntity(d, DistritoDTO.class);
    }

    @Override
    @Transactional
    public Optional<DistritoDTO> update(DistritoDTO distrito, Long id) {
        if (distritoRepository.findById(id).isPresent()) {
            Distrito d = MapperUtils.EntityFromDto(distrito, Distrito.class);
            d = distritoRepository.save(d);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(d, DistritoDTO.class));
        } else {
            return null;
        } 
    }

    @Override
    @Transactional
    public void delete(Long id) {
        distritoRepository.deleteById(id);
    }
}
