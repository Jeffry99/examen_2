/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Jeffry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString

public class UnidadDTO {
    private Long id;
    private String nombre;
    private int codigo;
    private String tipo;
    private Long area;
    private Long poblacion;
    private DistritoDTO distrito;
}
