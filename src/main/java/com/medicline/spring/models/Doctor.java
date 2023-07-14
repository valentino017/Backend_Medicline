package com.medicline.spring.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor")
@NamedQueries({
        @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM  Doctor p"),
        @NamedQuery(name = "Doctor.findByIdDoctor", query = "SELECT p FROM Doctor p WHERE p.id_doctor = :id_doctor"),
        @NamedQuery(name = "Doctor.findByCodigo", query = "SELECT p FROM Doctor p WHERE p.codigo = :codigo"),
        @NamedQuery(name = "Doctor.findByNombres", query = "SELECT p FROM Doctor p WHERE p.nombres= :nombres"),
        @NamedQuery(name = "Doctor.findByApellidoPaterno", query = "SELECT p FROM Doctor p WHERE p.apellidoPaterno= :apellidoPaterno"),
        @NamedQuery(name = "Doctor.findByApellidoMaterno", query = "SELECT p FROM Doctor p WHERE p.apellidoMaterno = :apellidoMaterno"),
        @NamedQuery(name = "Doctor.findByEspecialidad", query = "SELECT p FROM Doctor p WHERE p.especialidad = :especialidad"),
        @NamedQuery(name = "Doctor.findByFecha", query = "SELECT p FROM Doctor p WHERE p.fecha = :fecha"),
        @NamedQuery(name = "Doctor.findByHoraInicio", query = "SELECT p FROM Doctor p WHERE p.horaInicio = :horaInicio"),
        @NamedQuery(name = "Doctor.findByHoraFin", query = "SELECT p FROM Doctor p WHERE p.horaFin = :horaFin"),
})

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    private Integer id_doctor;

    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "horaInicio")
    private String horaInicio;

    @Column(name = "horaFin")
    private String horaFin;

    
}
