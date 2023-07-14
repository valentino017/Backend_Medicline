package com.medicline.spring.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "paciente")
@NamedQueries({
        @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM  Paciente p"),
        @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.id_paciente = :id_paciente"),
        @NamedQuery(name = "Paciente.findByDni", query = "SELECT p FROM Paciente p WHERE p.dni = :dni"),
        @NamedQuery(name = "Paciente.findByNombres", query = "SELECT p FROM Paciente p WHERE p.nombres = :nombres"),
        @NamedQuery(name = "Paciente.findByApellidoPaterno", query = "SELECT p FROM Paciente p WHERE p.apellidoPaterno = :apellidoPaterno"),
        @NamedQuery(name = "Paciente.findByApellidoMaterno", query = "SELECT p FROM Paciente p WHERE p.apellidoMaterno = :apellidoMaterno"),
        @NamedQuery(name = "Paciente.findByEstado_civil", query = "SELECT p FROM Paciente p WHERE p.estado_civil = :estado_civil"),
        @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono"),
        @NamedQuery(name = "Paciente.findByCorreoElectronico", query = "SELECT p FROM Paciente p WHERE p.correoElectronico = :correoElectronico"),
        @NamedQuery(name = "Paciente.findByHora", query = "SELECT p FROM Paciente p WHERE p.hora = :hora"),
        @NamedQuery(name = "Paciente.findByDia", query = "SELECT p FROM Paciente p WHERE p.dia = :dia"),
        @NamedQuery(name = "Paciente.findByEspecialidad", query = "SELECT p FROM Paciente p WHERE p.especialidad = :especialidad"),
        @NamedQuery(name = "Paciente.findBySede", query = "SELECT p FROM Paciente p WHERE p.sede = :sede"),
     })
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    private Integer id_paciente;

    @Basic(optional = false)
    @Column(name = "dni")
    private Integer dni;

    @Column(name = "fechaEmision")
    private String fechaEmision;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "estado_civil")
    private String estado_civil;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correoElectronico")
    private String correoElectronico;

    @Column(name = "hora")
    private String hora;

    @Column(name = "dia")
    private String dia;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "sede")
    private String sede;


}
