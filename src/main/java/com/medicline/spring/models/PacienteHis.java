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
@Table(name = "pacientehis")
@NamedQueries({
        @NamedQuery(name = "PacienteHis.findAll", query = "SELECT p FROM  PacienteHis p"),
        @NamedQuery(name = "PacienteHis.findByIdPaciente", query = "SELECT p FROM PacienteHis p WHERE p.id_pacienteHis = :id_pacienteHis"),
        @NamedQuery(name = "PacienteHis.findByDni", query = "SELECT p FROM PacienteHis p WHERE p.dni = :dni"),
        @NamedQuery(name = "PacienteHis.findByNombres", query = "SELECT p FROM PacienteHis p WHERE p.nombres = :nombres"),
        @NamedQuery(name = "PacienteHis.findByApellidoPaterno", query = "SELECT p FROM PacienteHis p WHERE p.apellidoPaterno = :apellidoPaterno"),
        @NamedQuery(name = "PacienteHis.findByApellidoMaterno", query = "SELECT p FROM PacienteHis p WHERE p.apellidoMaterno = :apellidoMaterno"),
        @NamedQuery(name = "PacienteHis.findByEstado_civil", query = "SELECT p FROM PacienteHis p WHERE p.estado_civil = :estado_civil"),
        @NamedQuery(name = "PacienteHis.findByTelefono", query = "SELECT p FROM PacienteHis p WHERE p.telefono = :telefono"),
        @NamedQuery(name = "PacienteHis.findByCorreoElectronico", query = "SELECT p FROM PacienteHis p WHERE p.correoElectronico = :correoElectronico"),
        @NamedQuery(name = "PacienteHis.findByHora", query = "SELECT p FROM PacienteHis p WHERE p.hora = :hora"),
        @NamedQuery(name = "PacienteHis.findByDia", query = "SELECT p FROM PacienteHis p WHERE p.dia = :dia"),
        @NamedQuery(name = "PacienteHis.findByEspecialidad", query = "SELECT p FROM PacienteHis p WHERE p.especialidad = :especialidad"),
        @NamedQuery(name = "PacienteHis.findBySede", query = "SELECT p FROM PacienteHis p WHERE p.sede = :sede"),
     })
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class PacienteHis implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    private Integer id_pacienteHis;

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
