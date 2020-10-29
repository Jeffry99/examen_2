/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.provincias.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "exa_jzo_distritos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Distrito implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 25)
    private String nombre;
    
    @Column
    private int codigo;
    
    @ManyToOne
    @JoinColumn(name="canton", nullable = false)
    private Canton canton;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distrito") 
    private List<Unidad> unidades = new ArrayList<>();
}