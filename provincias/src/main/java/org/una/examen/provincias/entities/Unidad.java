/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Jeffry
 */
@Entity
@Table(name = "exa_jzo_unidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Unidad implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 25)
    private String nombre;
    
    @Column
    private int codigo;
    
    @Column
    private Long area;
    
    @Column
    private Long poblacion;
    
    @Column(length = 25)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name="distrito", nullable = false)
    private Distrito distrito;
}